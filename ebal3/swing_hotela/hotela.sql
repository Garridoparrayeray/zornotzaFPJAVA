DROP DATABASE IF EXISTS hotela;
CREATE DATABASE hotela CHARACTER SET utf8mb4;
USE hotela;

CREATE TABLE bezeroak (
    id          INT PRIMARY KEY,
    izena       VARCHAR(50)  NOT NULL,
    abizena     VARCHAR(50)  NOT NULL,
    dni         VARCHAR(9)   UNIQUE,
    telefonoa   VARCHAR(15)
);

CREATE TABLE gelak (
    id          INT PRIMARY KEY,
    solairua    INT          NOT NULL,
    prezioa     DOUBLE       NOT NULL,
    mota        VARCHAR(10)  NOT NULL,
    extra       VARCHAR(20)
);

INSERT INTO bezeroak (id, izena, abizena, dni, telefonoa) VALUES
(1, 'Aitor',  'Etxeberria', '12345678A', '688112233'),
(2, 'Maialen','Aldama',     '87654321B', '699445566'),
(3, 'Jon',    'Garcia',     '11223344C', '600778899');

INSERT INTO gelak (id, solairua, prezioa, mota, extra) VALUES
(1, 1, 60.0,  'ARRUNTA', '2'),
(2, 1, 75.0,  'ARRUNTA', '3'),
(3, 2, 150.0, 'SUITE',   'bai'),
(4, 3, 120.0, 'SUITE',   'ez');
