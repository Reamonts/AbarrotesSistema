-- =========================
-- CREAR BASE DE DATOS
-- =========================
CREATE DATABASE IF NOT EXISTS inventario;
USE inventario;

-- =========================
-- TABLA CLIENTES
-- =========================
CREATE TABLE clientes (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          apellido VARCHAR(100),
                          email VARCHAR(150) UNIQUE,
                          telefono VARCHAR(20),
                          direccion VARCHAR(255),
                          activo BOOLEAN DEFAULT TRUE,
                          fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- TABLA PROVEEDORES
-- =========================
CREATE TABLE proveedores (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             nombre VARCHAR(100) NOT NULL,
                             empresa VARCHAR(150),
                             email VARCHAR(150),
                             telefono VARCHAR(20),
                             direccion VARCHAR(255),
                             activo BOOLEAN DEFAULT TRUE
);

-- =========================
-- TABLA PRODUCTOS
-- =========================
CREATE TABLE productos (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nombre VARCHAR(150) NOT NULL,
                           descripcion TEXT,
                           codigo_barras VARCHAR(100) UNIQUE,
                           precio_compra DECIMAL(10,2) NOT NULL,
                           precio_venta DECIMAL(10,2) NOT NULL,
                           stock INT DEFAULT 0,
                           stock_minimo INT DEFAULT 0,
                           activo BOOLEAN DEFAULT TRUE,
                           fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- TABLA VENTAS
-- =========================
CREATE TABLE ventas (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
                        total DECIMAL(10,2) NOT NULL,
                        cliente_id BIGINT,
                        CONSTRAINT fk_ventas_cliente
                            FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

-- =========================
-- TABLA DETALLE_VENTAS
-- =========================
CREATE TABLE detalle_ventas (
                                id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                venta_id BIGINT NOT NULL,
                                producto_id BIGINT NOT NULL,
                                cantidad INT NOT NULL,
                                precio_unitario DECIMAL(10,2) NOT NULL,
                                subtotal DECIMAL(10,2) NOT NULL,

                                CONSTRAINT fk_detalle_venta
                                    FOREIGN KEY (venta_id) REFERENCES ventas(id)
                                        ON DELETE CASCADE,

                                CONSTRAINT fk_detalle_producto
                                    FOREIGN KEY (producto_id) REFERENCES productos(id)
);

-- =========================
-- TABLA COMPRAS
-- =========================
CREATE TABLE compras (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
                         total DECIMAL(10,2) NOT NULL,
                         proveedor_id BIGINT,
                         CONSTRAINT fk_compras_proveedor
                             FOREIGN KEY (proveedor_id) REFERENCES proveedores(id)
);

-- =========================
-- TABLA DETALLE_COMPRAS
-- =========================
CREATE TABLE detalle_compras (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                 compra_id BIGINT NOT NULL,
                                 producto_id BIGINT NOT NULL,
                                 cantidad INT NOT NULL,
                                 precio_unitario DECIMAL(10,2) NOT NULL,
                                 subtotal DECIMAL(10,2) NOT NULL,

                                 CONSTRAINT fk_detalle_compra
                                     FOREIGN KEY (compra_id) REFERENCES compras(id)
                                         ON DELETE CASCADE,

                                 CONSTRAINT fk_detalle_compra_producto
                                     FOREIGN KEY (producto_id) REFERENCES productos(id)
);

-- =========================
-- TABLA ROLES
-- =========================
CREATE TABLE roles (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(50) NOT NULL UNIQUE
);

-- =========================
-- TABLA USUARIOS
-- =========================
CREATE TABLE usuarios (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(50) NOT NULL UNIQUE,
                          password VARCHAR(255) NOT NULL,
                          activo BOOLEAN DEFAULT TRUE,
                          fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- =========================
-- TABLA USUARIOS_ROLES
-- =========================
CREATE TABLE usuarios_roles (
                                usuario_id BIGINT,
                                rol_id BIGINT,
                                PRIMARY KEY (usuario_id, rol_id),

                                CONSTRAINT fk_usuario_rol_usuario
                                    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
                                        ON DELETE CASCADE,

                                CONSTRAINT fk_usuario_rol_rol
                                    FOREIGN KEY (rol_id) REFERENCES roles(id)
                                        ON DELETE CASCADE
);

-- =========================
-- TABLA MOVIMIENTOS INVENTARIO
-- =========================
CREATE TABLE movimientos_inventario (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,

                                        producto_id BIGINT NOT NULL,

                                        tipo ENUM('COMPRA', 'VENTA', 'AJUSTE') NOT NULL,

                                        cantidad INT NOT NULL,

                                        stock_antes INT NOT NULL,
                                        stock_despues INT NOT NULL,

                                        referencia_id BIGINT,

                                        fecha DATETIME DEFAULT CURRENT_TIMESTAMP,

                                        CONSTRAINT fk_movimiento_producto
                                            FOREIGN KEY (producto_id) REFERENCES productos(id)
);

-- =========================
-- ÍNDICES (PERFORMANCE)
-- =========================
CREATE INDEX idx_producto_codigo ON productos(codigo_barras);
CREATE INDEX idx_cliente_email ON clientes(email);

CREATE INDEX idx_ventas_cliente ON ventas(cliente_id);
CREATE INDEX idx_compras_proveedor ON compras(proveedor_id);
CREATE INDEX idx_movimientos_producto ON movimientos_inventario(producto_id);

-- =========================
-- DATOS INICIALES
-- =========================

-- Roles
INSERT INTO roles (nombre) VALUES ('ADMIN'), ('EMPLEADO');

-- Usuarios (password encriptado con BCrypt desde backend)
INSERT INTO usuarios (username, password)
VALUES
    ('admin', '$2a$12$T/0mWo2w5aLbiDdggvduP.xM1DLlMYtQj0X7XRCTKJjs5aKMH4Fwy'),
    ('empleado', '$2a$10$hashbcrypt');

-- Relación usuario-rol
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (2, 2);

-- Clientes
INSERT INTO clientes (nombre, apellido, email, telefono)
VALUES
    ('Juan', 'Pérez', 'juan@test.com', '123456789'),
    ('Ana', 'García', 'ana@test.com', '987654321');

-- Proveedores
INSERT INTO proveedores (nombre, empresa, email)
VALUES
    ('Carlos López', 'Distribuidora ABC', 'proveedor@test.com');

-- Productos
INSERT INTO productos (nombre, descripcion, codigo_barras, precio_compra, precio_venta, stock)
VALUES
    ('Laptop', 'Laptop HP', 'ABC123', 8000.00, 10000.00, 10),
    ('Mouse', 'Mouse inalámbrico', 'XYZ456', 100.00, 200.00, 50);