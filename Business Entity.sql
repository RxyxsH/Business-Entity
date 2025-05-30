
CREATE DATABASE BusinessEntity;
GO

CREATE TABLE productos (
    id INT  PRIMARY KEY IDENTITY,
    nombre VARCHAR(100),
    precio DECIMAL(10, 2)
);


INSERT INTO productos (nombre, precio) VALUES
('Producto A', 25.50),
('Producto B', 15.00),
('Producto C', 30.00);

SELECT * FROM productos;


