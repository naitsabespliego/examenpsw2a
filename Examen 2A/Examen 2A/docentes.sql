
create database docentes;
use docentes;

DROP TABLE IF EXISTS `docentebatiz`;

CREATE TABLE `docentebatiz` (
  `noempleado` varchar(20) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `appat` varchar(30) NOT NULL,
  `apmat` varchar(30) NOT NULL,
  `fechanac` varchar(8) NOT NULL,
  PRIMARY KEY (`noempleado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Mcpu`;

CREATE TABLE `Mcpu` (
  `serial` varchar(20) NOT NULL,
  `descripcion1` varchar(100) NOT NULL,
  PRIMARY KEY (`serial`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Mteclado`;

CREATE TABLE `Mteclado` (
  `teclado` varchar(20) NOT NULL,
  `descripcion2` varchar(100) NOT NULL,
  PRIMARY KEY (`teclado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Mmouse`;

CREATE TABLE `Mmouse` (
  `mouse` varchar(20) NOT NULL,
  `descripcion3` varchar(100) NOT NULL,
  PRIMARY KEY (`mouse`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Cmarca`;

CREATE TABLE `Cmarca` (
  `idmarca` varchar(20) NOT NULL,
  `nommarca` varchar(20) NOT NULL,
  PRIMARY KEY (`idmarca`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Mmonitor`;

CREATE TABLE `Mmonitor` (
  `monitor` varchar(20) NOT NULL,
  `descripcion4` varchar(100) NOT NULL,
  PRIMARY KEY (`monitor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Cestadoequipo`;

CREATE TABLE `Cestadoequipo` (
  `edoequipo` varchar(20) NOT NULL,
  `descripcion5` varchar(100) NOT NULL,
  PRIMARY KEY (`edoequipo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Metiqueta`;

CREATE TABLE `Metiqueta` (
  `etiqueta` varchar(20) NOT NULL,
  PRIMARY KEY (`etiqueta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Mproblema`;

CREATE TABLE `Mproblema` (
  `problema` varchar(100) NOT NULL,
  PRIMARY KEY (`problema`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `equipobatiz`;

CREATE TABLE `equipobatiz` (
  `etiqueta` varchar(20) NOT NULL,
  `serial` varchar(20) NOT NULL,
  `teclado` varchar(20) NOT NULL,
  `mouse` varchar(20) NOT NULL,
  `idmarca` varchar(20) NOT NULL,
  `monitor` varchar(20) NOT NULL,
  `edoequipo` varchar(20) NOT NULL,
  `problema` varchar(100) NOT NULL,
  PRIMARY KEY (`etiqueta`),
  FOREIGN KEY (`etiqueta`) REFERENCES `Metiqueta`(`etiqueta`),
  FOREIGN KEY (`problema`) REFERENCES `Mproblema`(`problema`),
  FOREIGN KEY (`serial`) REFERENCES `Mcpu`(`serial`),
  FOREIGN KEY (`teclado`) REFERENCES `Mteclado`(`teclado`),
  FOREIGN KEY (`mouse`) REFERENCES `Mmouse`(`mouse`),
  FOREIGN KEY (`idmarca`) REFERENCES `Cmarca`(`idmarca`),
  FOREIGN KEY (`monitor`) REFERENCES `Mmonitor`(`monitor`),
  FOREIGN KEY (`edoequipo`) REFERENCES `Cestadoequipo`(`edoequipo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*
SELECT * FROM `Metiqueta`;
SELECT COUNT(*) FROM `Metiqueta`;

SELECT * FROM `Mproblema`;
SELECT COUNT(*) FROM `Mproblema`;

SELECT * FROM `Mcpu`;
SELECT COUNT(*) FROM `Mcpu`;

SELECT * FROM `Mteclado`;
SELECT COUNT(*) FROM `Mteclado`;

SELECT * FROM `Mmouse`;
SELECT COUNT(*) FROM `Mmouse`;

SELECT * FROM `Cmarca`;
SELECT COUNT(*) FROM `Cmarca`;

SELECT * FROM `Mmonitor`;
SELECT COUNT(*) FROM `Mmonitor`;

SELECT * FROM `Cestadoequipo`;
SELECT COUNT(*) FROM `Cestadoequipo`;
*/

DROP TABLE IF EXISTS `Claboratorio`;

CREATE TABLE `Claboratorio` (
  `id_lab` varchar(5) NOT NULL,
  `nom_lab` varchar(5) NOT NULL,
  PRIMARY KEY (`id_lab`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Creporte`;

CREATE TABLE `Creporte` (
  `id_reporte` varchar(10) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `hora` varchar(20) NOT NULL,
  `prioridad` varchar(20) NOT NULL,
  `fechrepre` varchar(20) NOT NULL,
  `horrepre` varchar(20) NOT NULL,
  `responsable` varchar(20) NOT NULL,
  PRIMARY KEY (`id_reporte`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `Mreporte`;

CREATE TABLE `Mreporte` (
  `id_lab` varchar(5) NOT NULL,
  `nom_lab` varchar(5) NOT NULL,
  `id_reporte` varchar(10) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `hora` varchar(20) NOT NULL,
  `etiqueta` varchar(20) NOT NULL,
  `noempleado` varchar(20) NOT NULL,
  `prioridad` varchar(20) NOT NULL,
  `fechrepre` varchar(20) NOT NULL,
  `horrepre` varchar(20) NOT NULL,
  `responsable` varchar(20) NOT NULL,
  PRIMARY KEY (`id_reporte`),
  FOREIGN KEY (`id_lab`) REFERENCES `Claboratorio`(`id_lab`),
  FOREIGN KEY (`nom_lab`) REFERENCES `Claboratorio`(`nom_lab`),
  FOREIGN KEY (`id_reporte`) REFERENCES `Creporte`(`id_reporte`),
  FOREIGN KEY (`fecha`) REFERENCES `Creporte`(`fecha`),
  FOREIGN KEY (`hora`) REFERENCES `Creporte`(`hora`),
  FOREIGN KEY (`etiqueta`) REFERENCES `equipobatiz`(`etiqueta`),
  FOREIGN KEY (`noempleado`) REFERENCES `docentebatiz`(`noempleado`),
  FOREIGN KEY (`prioridad`) REFERENCES `Creporte`(`prioridad`),
  FOREIGN KEY (`fechrepre`) REFERENCES `Creporte`(`fechrepre`),
  FOREIGN KEY (`horrepre`) REFERENCES `Creporte`(`horrepre`),
  FOREIGN KEY (`responsable`) REFERENCES `Creporte`(`responsable`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*
SELECT * FROM `Claboratorio`;
SELECT COUNT(*) FROM `Claboratorio`;

SELECT * FROM `Creporte`;
SELECT COUNT(*) FROM `Creporte`;

SELECT * FROM `equipobatiz`;
SELECT COUNT(*) FROM `equipobatiz`;

SELECT * FROM `docentebatiz`;
SELECT COUNT(*) FROM `docentebatiz`;
*/