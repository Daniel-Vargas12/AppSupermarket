package com.pruebatecnica.ejerciciosupermercado.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pruebatecnica.ejerciciosupermercado.Mapper.Mapper;
import com.pruebatecnica.ejerciciosupermercado.dto.DetalleVentaDTO;
import com.pruebatecnica.ejerciciosupermercado.dto.VentaDTO;
import com.pruebatecnica.ejerciciosupermercado.exception.NotFoundException;
import com.pruebatecnica.ejerciciosupermercado.exception.StockException;
import com.pruebatecnica.ejerciciosupermercado.model.DetalleVenta;
import com.pruebatecnica.ejerciciosupermercado.model.Producto;
import com.pruebatecnica.ejerciciosupermercado.model.Sucursal;
import com.pruebatecnica.ejerciciosupermercado.model.Venta;
import com.pruebatecnica.ejerciciosupermercado.repository.ProductoRepository;
import com.pruebatecnica.ejerciciosupermercado.repository.SucursalRepository;
import com.pruebatecnica.ejerciciosupermercado.repository.VentaRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private VentaRepository ventaRepo;
    @Autowired
    private ProductoRepository productoRepo;
    @Autowired
    private SucursalRepository sucursalRepo;

    @Override
    public List<VentaDTO> traerVentas(){

        List<Venta> ventas = ventaRepo.findAll();
        List<VentaDTO> ventasDto = new ArrayList<>();

        VentaDTO dto;
        for(Venta v: ventas) {
            dto = Mapper.toDTO(v);
            ventasDto.add(dto);
        }
        return ventasDto;
    }


    @Override
    @Transactional
    public VentaDTO crearVenta(VentaDTO ventaDto){

        // Las validaciones de entrada se realizan mediante Bean Validation (@Valid)

        //buscar sucursal
        Sucursal suc = sucursalRepo.findById(ventaDto.getIdSucursal())
                .orElseThrow(() ->
                    new NotFoundException("Sucursal no encontrada"));

        //crear la venta
        Venta vent = new Venta();
        vent.setFecha(ventaDto.getFecha());
        vent.setEstado(ventaDto.getEstado());
        vent.setSucursal(suc);
        
        //la lista de detalles - productos aca
        List<DetalleVenta> detalles = new ArrayList<>();
        Double totalCalculado = 0.0;

        for(DetalleVentaDTO detDTO: ventaDto.getDetalle()){
            //verificar que exista producto    
            Producto p = productoRepo.findById(detDTO.getIdProducto())
                .orElseThrow(()->
                    new NotFoundException("Producto no encontrado"));


            //verificar stock suficiente
            if(p.getCantidad()<detDTO.getCantProd()){
                throw new StockException(
                    "Stock insuficiente para el producto: "+p.getNombre()
                );
            }
            //descontar stock
            p.setCantidad(p.getCantidad()-detDTO.getCantProd());
            productoRepo.save(p);

            //crear detalle
            DetalleVenta detalleVent = new DetalleVenta();
            detalleVent.setProd(p);
            detalleVent.setNombreProd(p.getNombre());
            detalleVent.setCantProd(detDTO.getCantProd());
            detalleVent.setPrecio(p.getPrecio());
            detalleVent.setSubtotal(
                    p.getPrecio() * detDTO.getCantProd()
            );
            detalleVent.setVenta(vent);
        
            detalles.add(detalleVent);
            totalCalculado += detalleVent.getSubtotal();
        
        }
        vent.setTotal(totalCalculado);

        //seteamos lista de detalle venta
        vent.setDetalle(detalles);

        //guardamos en la BD
        vent=ventaRepo.save(vent);//trae el objeto actualizado con formato y datos de la BD

        //mapeo de salida
        return Mapper.toDTO(vent);
    }


    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO ventaDto) {
        
            //buscar si la venta existe
        Venta v = ventaRepo.findById(id).orElse(null);
        if(v==null)throw new RuntimeException("Venta no encontrada");

        if(ventaDto.getFecha()!=null){
            v.setFecha(ventaDto.getFecha());
        }
        if(ventaDto.getEstado()!=null){
            v.setEstado(ventaDto.getEstado());
        }
        if(ventaDto.getTotal()!=null){
            v.setTotal(ventaDto.getTotal());
        }
        if(ventaDto.getIdSucursal()!=null){
            Sucursal suc = sucursalRepo.findById(ventaDto.getIdSucursal()).orElse(null);
            if(suc==null) throw new NotFoundException("Sucursal no encontrada");
            v.setSucursal(suc);
        }
        ventaRepo.save(v);        
    
        VentaDTO ventaSalida = Mapper.toDTO(v);

        return ventaSalida;
    }


    @Override
    public void eliminarVenta(Long id){

        Venta v = ventaRepo.findById(id).orElse(null);
            if(v==null)throw new RuntimeException("Venta no encontrada");
            ventaRepo.delete(v);
    }

}
