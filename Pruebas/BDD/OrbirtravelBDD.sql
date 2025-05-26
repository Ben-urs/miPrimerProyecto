DROP DATABASE IF EXISTS orbitravel; 
CREATE DATABASE orbitravel;
USE orbitravel;

-- --- Usuario y privilegios -----------------------------------------------------------------------------
-- CREATE USER 'developer'@'localhost' IDENTIFIED BY 'developer';
-- GRANT ALL PRIVILEGES ON orbitravel TO 'developer'@'localhost';
-- SHOW GRANTS FOR 'developer'@'localhost';

-- DROP USER 'developer';

-- Creacion de Tablas --------------------------------------------------------------------------------

-- Usuarios -------------------------------------------
CREATE TABLE usuarios (
    usuario_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    correo_electronico VARCHAR(255) NOT NULL UNIQUE,
    contraseña VARCHAR(255) NOT NULL, 
    telefono VARCHAR(20)
);

-- Paises --------------------------------------------
CREATE TABLE paises (
    pais_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Ciudades ------------------------------------------
CREATE TABLE ciudades (
    ciudad_id  INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    pais_id INT NOT NULL,
    FOREIGN KEY (pais_id) REFERENCES paises(pais_id)
);


-- Aerolineas ----------------------------------------
CREATE TABLE aerolineas (
    aerolinea_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL
);

-- Aeropuertos ----------------------------------------
CREATE TABLE aeropuertos (
    aeropuerto_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    ciudad_id INT NOT NULL,
    aerolinea_id INT NOT NULL,
    FOREIGN KEY (ciudad_id) REFERENCES ciudades(ciudad_id),
    FOREIGN KEY (aerolinea_id) REFERENCES aerolineas(aerolinea_id)
);


-- Vuelos --------------------------------------------
CREATE TABLE vuelos (
    vuelo_id INT AUTO_INCREMENT PRIMARY KEY,
    origen_id INT NOT NULL,
    destino_id INT NOT NULL,
    salida_fecha DATETIME NOT NULL,
    llegada_fecha DATETIME NOT NULL,
    precio_base DECIMAL(10,2) NOT NULL,
    aerolinea_id INT,
    FOREIGN KEY (origen_id) REFERENCES aeropuertos(aeropuerto_id),
    FOREIGN KEY (destino_id) REFERENCES aeropuertos(aeropuerto_id),
	FOREIGN KEY (aerolinea_id) REFERENCES aerolineas(aerolinea_id)
);

-- Tipo de Transporte --------------------------------
CREATE TABLE tipo_transporte (
    tipo_transporte_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Tipo de Vuelos ------------------------------------
CREATE TABLE tipo_vuelo (
    tipo_vuelo_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Clase ---------------------------------------------
CREATE TABLE clase (
    clase_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Estado de las Reseervas ---------------------------
CREATE TABLE estado_reserva (
    estado_reserva_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Estado de los pagos -------------------------------
CREATE TABLE estado_pago (
    estado_pago_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Reservas ------------------------------------------
CREATE TABLE reservas (
    reserva_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    vuelo_id INT NOT NULL,
    tipo_transporte_id INT NOT NULL,
    tipo_vuelo_id INT NOT NULL,
    clase_id INT NOT NULL,
    fecha_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    asientos INT NOT NULL,
    precio_total DECIMAL(10,2) NOT NULL,
    estado_reserva_id INT NOT NULL DEFAULT 1,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (vuelo_id) REFERENCES vuelos(vuelo_id),
    FOREIGN KEY (tipo_transporte_id) REFERENCES tipo_transporte(tipo_transporte_id),
    FOREIGN KEY (tipo_vuelo_id) REFERENCES tipo_vuelo(tipo_vuelo_id),
    FOREIGN KEY (clase_id) REFERENCES clase(clase_id),
    FOREIGN KEY (estado_reserva_id) REFERENCES estado_reserva(estado_reserva_id)
);

-- Pagos ---------------------------------------------
CREATE TABLE pagos (
    pago_id INT AUTO_INCREMENT PRIMARY KEY,
    reserva_id INT NOT NULL,
    moneda CHAR(3) NOT NULL,
    metodo_pago VARCHAR(50),
    fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    precio DECIMAL(10,2) NOT NULL,
    estado_pago_id INT NOT NULL DEFAULT 1,
    FOREIGN KEY (reserva_id) REFERENCES reservas(reserva_id),
    FOREIGN KEY (estado_pago_id) REFERENCES estado_pago(estado_pago_id),
    CONSTRAINT chk_moneda CHECK (moneda IN (
	'EUR','USD','GBP','ARS','MXN','COP','CLP','THB','CZK','DKK','ISK',
	'NOK','SEK','BHD','JOD','KWD','AED','AUD','CAD','HKD','FJD',
	'NAD','NZD','SGD','HUF','XOF','CHF','UAH','GEL','MDL','RON',
	'BGN','EGP','TRY','AZN','TWD','ILS','MOP','ZAR','BRL','QAR',
	'OMR','SAR','MYR','RUB','INR','IDR','KZT','KRW','JPY','CNY','PLN'))
);

-- Reseñas ------------------------------------------
CREATE TABLE resenas (
    resena_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    vuelo_id INT NOT NULL,
    calificacion TINYINT CHECK (calificacion BETWEEN 1 AND 5),
    comentario TEXT,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id),
    FOREIGN KEY (vuelo_id) REFERENCES vuelos(vuelo_id)
);

-- Promociones --------------------------------------
CREATE TABLE promociones (
    promocion_id INT AUTO_INCREMENT PRIMARY KEY,
    vuelo_id INT,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    descuento_pct DECIMAL(5,2) NOT NULL CHECK (descuento_pct BETWEEN 0 AND 100),
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    FOREIGN KEY (vuelo_id) REFERENCES vuelos(vuelo_id)
);


-- Inserts --------------------------------------------------------------------------------

-- Usuarios ----------------------------------------
INSERT INTO usuarios 
VALUES (1, 'Admin', 'Admin', '1990-05-04', 'admin.admin@email.com', '12345', '555123459'),
(2, 'Juan', 'Pérez', '1990-05-01', 'juan.perez@email.com', '12345', '555123456'),
(3, 'Marcos', 'Perez', '1990-05-02', 'marcos.perez@email.com', '12345', '555123454'),
(4, 'Ana', 'Lerele', '1990-05-04', 'ana.lerele@email.com', '12345', '555123451'),
(5, 'Maria', 'Cape', '1990-05-04', 'maria.ape@email.com', '12345', '555123452'),
(6, 'Luis', 'Gonzales', '1990-05-04', 'admin.gonzales@email.com', '12345', '555123453'),
(7, 'Camilo', 'Longo', '1990-05-04', 'admin.longo@email.com', '12345', '555123457'),
(8, 'Antonio', 'Mane', '1990-05-04', 'admin.mane@email.com', '12345', '555123458');

-- Paises --------------------------------------------
INSERT INTO paises 
VALUES (1,'España'), (2,'Alemania'), (3,'Australia'), (4,'Inglatera'), (5,'Rusia'), (6,'Francia'),
(7,'Brasil'),(8,'Portugal'), (9,'Perú'), (10,'Noruega'), (11,'Turquia'), (12,'Grecia'), (13,'Corea del Sur'),
(14,'China'), (15,'India'), (16,'Canada'), (17,'Estados Unidos'), (18,'Tailandia'), (19,'Dinamarca'), 
(20,'Bélgica'), (21,'Colombia'), (22,'México'), (23,'Japón'), (24,'Puerto Rico'), (25,'Chile'), (26,'Italia');

-- Ciudades -------------------------------------------
INSERT INTO ciudades
VALUES (1,'Madrid', 1), (2,'Berlín', 2), (3,'Canberra', 3), (4,'Londres', 4), (5,'Moscú', 5), (6,'Paris', 6),
(7,'Brasilia', 7),(8,'Lisboa', 8), (9,'Lima', 9), (10,'Oslo', 10), (11,'Ankara', 11), (12,'Atenas', 12), (13,'Seul', 13),
(14,'Pekin', 14), (15,'Nueva Delhi', 15), (16,'Ottawa', 16), (17,'Washington D.C', 17), (18,'Bangkok', 18), (19,'Copenhague', 19), 
(20,'Bruselas', 20), (21,'Bogotá', 21), (22,'Ciudad de México', 22), (23,'Tokio', 23), (24,'San Juan', 24), (25,'Santiago', 25), (26,'Roma', 26);

-- Aerolineas ------------------------------------------
INSERT INTO aerolineas
VALUES 
  (1,'Iberia'), (2,'Lufthansa'), (3,'Emirates'), (4,'British Airways'), (5,'Air India'),
  (6,'ANA All Nippon Airways'), (7,'Qatar Airways'), (8,'Ryanair'), (9,'Air France-KLM'),
  (10,'American Airlines'), (11,'Delta Air Lines'), (12,'United Airlines'),
  (13,'Turkish Airlines'), (14,'Lufthansa'), (15,'KLM Royal Dutch Airlines'),
  (16,'Cathay Pacific');
  
-- Aeropuertos--------------------------------------------------------------------------------
INSERT INTO aeropuertos (aeropuerto_id, nombre, ciudad_id, aerolinea_id)
VALUES 
  (1,  'Adolfo Suárez Madrid-Barajas',                          1,  1),
  (2,  'Brandenburgo Willy Brandt',                             2,  2),
  (3,  'Canberra International Airport',                        3,  4),
  (4,  'Heathrow',                                               4,  4),
  (5,  'Sheremetyevo',                                           5,  2),
  (6,  'París-Charles de Gaulle',                               6,  9),
  (7,  'Aeropuerto Internacional Presidente Juscelino Kubitschek', 7,  7),
  (8,  'Aeropuerto Humberto Delgado',                           8,  8),
  (9,  'Aeropuerto Internacional Jorge Chávez',                 9, 11),
  (10, 'Aeropuerto de Oslo-Gardermoen',                         10, 2),
  (11, 'Aeropuerto Internacional Esenboğa',                     11,13),
  (12, 'Aeropuerto Internacional Eleftherios Venizelos',        12,12),
  (13, 'Aeropuerto Internacional de Incheon',                   13, 6),
  (14, 'Aeropuerto Internacional de Pekín-Daxing',              14,16),
  (15, 'Aeropuerto Internacional Indira Gandhi',                15, 5),
  (16, 'Aeropuerto Internacional Macdonald-Cartier de Ottawa',  16,16),
  (17, 'Aeropuerto Nacional Ronald Reagan de Washington',       17,10),
  (18, 'Aeropuerto Internacional Suvarnabhumi',                 18, 3),  
  (19, 'Aeropuerto de Copenhague-Kastrup',                      19, 2),
  (20, 'Aeropuerto de Bruselas-Zaventem',                       20, 9),
  (21, 'Aeropuerto Internacional El Dorado Luis Carlos Galán Sarmiento', 21,11),
  (22, 'Aeropuerto Internacional Benito Juárez',                22,10),
  (23, 'Aeropuerto Internacional de Narita',                    23, 6),
  (24, 'Aeropuerto Internacional Luis Muñoz Marín',             24,14),
  (25, 'Aeropuerto Internacional Comodoro Arturo Merino Benítez',25, 9),
  (26, 'Aeropuerto Internacional Leonardo da Vinci',            26,15);
  
-- Vuelos --------------------------------------------------------------------------------
INSERT INTO vuelos (origen_id, destino_id, salida_fecha, llegada_fecha, precio_base, aerolinea_id)
VALUES 
(1, 3, '2025-12-12 23:21:12', '2025-12-13 05:21:12', 300.00, 1),
(5, 8, '2025-12-12 16:21:12', '2025-12-13 05:21:12', 300.00, 4),
(6, 1, '2025-12-12 09:21:12', '2025-12-13 05:21:12', 300.00, 7),
(3, 11, '2025-12-12 11:21:12', '2025-12-13 05:21:12', 300.00, 12),
(8, 13, '2025-12-12 22:21:12', '2025-12-13 05:21:12', 300.00, 11),
(3, 21, '2025-12-12 21:21:12', '2025-12-13 05:21:12', 300.00, 5),
(16, 6, '2025-12-12 16:21:12', '2025-12-13 05:21:12', 300.00, 3),
(9, 23, '2025-12-12 14:21:12', '2025-12-13 05:21:12', 300.00, 7),
(2, 12, '2025-12-12 19:21:12', '2025-12-13 05:21:12', 300.00, 4),
(11, 6, '2025-12-12 02:21:12', '2025-12-13 05:21:12', 300.00, 2),
(24, 12, '2025-12-12 23:21:12', '2025-12-13 05:21:12', 300.00, 14),
(16, 17, '2025-12-12 23:21:12', '2025-12-13 05:21:12', 300.00, 16),
(19, 2, '2025-12-12 23:21:12', '2025-12-13 05:21:12', 300.00, 15),
(14, 4, '2025-12-12 23:21:12', '2025-12-13 05:21:12', 300.00, 9);
  
-- Tipo Transporte ---------------------------------
INSERT INTO tipo_transporte (nombre)
VALUES ('Vuelo'), ('Tras Atlantico');

-- Tipo Vuelo --------------------------------------
INSERT INTO tipo_vuelo (nombre)
VALUES ('Solo ida'), ('Ida y vuelta'), ('Multiples destinos');

-- Clase -------------------------------------------
INSERT INTO clase (nombre)
VALUES ('Turista'), ('Turista premium'), ('Business'), ('Primera clase');

-- Estado de las Reserva ---------------------------
INSERT INTO estado_reserva (nombre)
VALUES ('pendiente'), ('confirmada'), ('cancelada');

-- Estado de los Pagos -----------------------------
INSERT INTO estado_pago (nombre)
VALUES ('pendiente'), ('pagado'), ('reembolsado');


