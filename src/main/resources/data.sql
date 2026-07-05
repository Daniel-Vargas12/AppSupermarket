-- ============================
-- SUCURSALES
-- ============================

INSERT INTO sucursal(nombre, direccion)
VALUES
    ('Sucursal Norte', 'Calle 100 #15 B'),
    ('Sucursal Centro', 'Calle 1 #32-15'),
    ('Sucursal Sur', 'Carrera 45 #10-2');


-- ============================
-- PRODUCTOS
-- ============================

INSERT INTO producto(nombre, categoria, precio, cantidad)
VALUES
    ('Coca cola 1.5 L', 'Bebidas', 1500, 29),
    ('Saco de naranjas', 'Frutas y Verduras', 2400, 78),
    ('Arroz Diana 1 Kg', 'Granos', 4200, 60),
    ('Leche Alpina 1 L', 'Lácteos', 3900, 45),
    ('Pan tajado Bimbo', 'Panadería', 5200, 25),
    ('Huevos AA x30', 'Huevos', 18000, 20),
    ('Aceite Premier 1 L', 'Despensa', 13500, 35),
    ('Azúcar Manuelita 1 Kg', 'Despensa', 4100, 50),
    ('Café Sello Rojo 500 g', 'Bebidas', 9800, 40),
    ('Pechuga de pollo 1 Kg', 'Carnes', 17000, 15);


-- ============================
-- VENTA
-- ============================

INSERT INTO venta(fecha, estado, total, sucursal_id)
VALUES
    ('2026-07-03', 'REGISTRADA', 6300, 1);


-- ============================
-- DETALLE VENTA
-- ============================

INSERT INTO detalle_venta
(
    venta_id,
    producto_id,
    nombre_prod,
    cant_prod,
    precio,
    subtotal
)
VALUES
    (1,1,'Coca cola 1.5 L',1,1500,1500),
    (1,2,'Saco de naranjas',2,2400,4800);