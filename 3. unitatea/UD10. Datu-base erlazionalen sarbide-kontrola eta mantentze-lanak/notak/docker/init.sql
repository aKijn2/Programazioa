CREATE DATABASE IF NOT EXISTS programazioa_eskola;

USE programazioa_eskola;

-- Sortu DBa ez baldin bada existitzen era erabili egiten dugu.
-- Behar ditugun taula guztiak sortzen ditugu.
CREATE TABLE zikloak (
    idZikloa VARCHAR(50) PRIMARY KEY,
    izena VARCHAR(100),
    familia VARCHAR(100),
    maila VARCHAR(50)
);

CREATE TABLE erabiltzaileak (
    erabiltzailea VARCHAR(50) PRIMARY KEY,
    izena VARCHAR(100),
    mota VARCHAR(50),
    NA VARCHAR(20),
    pasahitza VARCHAR(100)
);

CREATE TABLE taldeak (
    idTaldea VARCHAR(50) PRIMARY KEY,
    zeinZiklo VARCHAR(50),
    zeinTutore VARCHAR(50),
    FOREIGN KEY (zeinZiklo) REFERENCES zikloak(idZikloa),
    FOREIGN KEY (zeinTutore) REFERENCES erabiltzaileak(erabiltzailea)
);

CREATE TABLE ikasgaiak (
    kodea INT PRIMARY KEY,
    izena VARCHAR(100),
    zeinTalde VARCHAR(50),
    FOREIGN KEY (zeinTalde) REFERENCES taldeak(idTaldea)
);

CREATE TABLE matrikulak (
    idMatrikula INT PRIMARY KEY AUTO_INCREMENT,
    zeinIkasgai INT,
    zeinIkasle VARCHAR(50),
    FOREIGN KEY (zeinIkasgai) REFERENCES ikasgaiak(kodea),
    FOREIGN KEY (zeinIkasle) REFERENCES erabiltzaileak(erabiltzailea)
);

CREATE TABLE irakasle_irakats (
    zeinIrakasle VARCHAR(50),
    zeinIkasgai INT,
    FOREIGN KEY (zeinIrakasle) REFERENCES erabiltzaileak(erabiltzailea),
    FOREIGN KEY (zeinIkasgai) REFERENCES ikasgaiak(kodea)
);

CREATE TABLE notak (
    idNota INT PRIMARY KEY AUTO_INCREMENT,
    zeinMatrikula INT,
    ebaluaketa VARCHAR(50),
    nota INT,
    oharra VARCHAR(255),
    FOREIGN KEY (zeinMatrikula) REFERENCES matrikulak(idMatrikula)
);


-- datuak sartzeko:

-- Zikloak
INSERT INTO zikloak (idZikloa, izena, familia, maila) VALUES
('IFCS', 'Informatika Sistemen Garapena', 'Informatika', 'GS'),
('ASIR', 'Sareen Administrazioa', 'Informatika', 'GS');

-- Erabiltzaileak
INSERT INTO erabiltzaileak (erabiltzailea, izena, mota, NA, pasahitza) VALUES
('aosuna', 'Ane Osuna', 'ikasle', '12345678A', 'pasahitza1'),
('mmartin', 'Mikel Martin', 'ikasle', '23456789B', 'pasahitza2'),
('itarte', 'Irati Arteaga', 'irakasle', '34567890C', 'pasahitza3'),
('jherrera', 'Jon Herrera', 'irakasle', '45678901D', 'pasahitza4');

-- Taldeak
INSERT INTO taldeak (idTaldea, zeinZiklo, zeinTutore) VALUES
('IFCS1A', 'IFCS', 'itarte'),
('ASIR1A', 'ASIR', 'jherrera');

-- Ikasgaiak
INSERT INTO ikasgaiak (kodea, izena, zeinTalde) VALUES
(101, 'Programazioa', 'IFCS1A'),
(102, 'Sistemak', 'ASIR1A');

-- Matrikulak
INSERT INTO matrikulak (zeinIkasgai, zeinIkasle) VALUES
(101, 'aosuna'),
(102, 'mmartin');

-- Irakasle-irakats
INSERT INTO irakasle_irakats (zeinIrakasle, zeinIkasgai) VALUES
('itarte', 101),
('jherrera', 102);

-- Notak
INSERT INTO notak (zeinMatrikula, ebaluaketa, nota, oharra) VALUES
(1, '1. Ebaluazioa', 8, 'Lan bikaina'),
(2, '1. Ebaluazioa', 6, 'Hobetzeko tartea dago');
