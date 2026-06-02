-- =========================
-- DATU-BASEA
-- =========================
CREATE DATABASE IF NOT EXISTS gimnasioa;
USE gimnasioa;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;

-- =========================
-- TAULA: erabiltzaileak
-- =========================
CREATE TABLE erabiltzaileak (
    idErabiltzailea INT AUTO_INCREMENT PRIMARY KEY,
    izena VARCHAR(50) NOT NULL,
    pasahitza VARCHAR(50) NOT NULL,
    rola VARCHAR(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- =========================
-- TAULA: klaseak
-- =========================
CREATE TABLE klaseak (
  idKlasea INT(11) NOT NULL AUTO_INCREMENT,
  izena VARCHAR(40) NOT NULL,
  instruktorea VARCHAR(40) NOT NULL,
  ordutegia VARCHAR(20) NOT NULL,
  PRIMARY KEY (idKlasea)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- =========================
-- TAULA: erreserbak (ZUZENDUTA)
-- =========================
CREATE TABLE erreserbak (
  idErreserba INT(11) NOT NULL AUTO_INCREMENT,
  idBezeroa INT NOT NULL,
  data DATE NOT NULL,
  idKlasea INT NOT NULL,
  PRIMARY KEY (idErreserba),

  CONSTRAINT fk_erreserba_erabiltzailea
    FOREIGN KEY (idBezeroa) REFERENCES erabiltzaileak(idErabiltzailea),

  CONSTRAINT fk_erreserba_klasea
    FOREIGN KEY (idKlasea) REFERENCES klaseak(idKlasea)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- =========================
-- DATUAK: KLASEAK
-- =========================
INSERT INTO klaseak (izena, instruktorea, ordutegia) VALUES
('Yoga', 'Ana', '10:00'),
('Spinning', 'Carlos', '11:00'),
('Crossfit', 'Laura', '12:00'),
('Pilates', 'Marta', '09:00'),
('Zumba', 'Luis', '18:00');

-- =========================
-- DATUAK: ERABILTZAILEAK
-- =========================
INSERT INTO erabiltzaileak (izena, pasahitza, rola) VALUES
('admin', 'admin123', 'ADMIN'),
('juan', '1234', 'BEZEROA'),
('maria', '1234', 'BEZEROA');

-- =========================
-- DATUAK: ERRESERBAK (ZUZENDUTA)
-- =========================
INSERT INTO erreserbak (idBezeroa, data, idKlasea) VALUES
(2, '2026-04-21', 1),
(3, '2026-04-21', 2),
(2, '2026-04-22', 3),
(3, '2026-04-22', 1),
(2, '2026-04-23', 5);

COMMIT;