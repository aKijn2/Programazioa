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