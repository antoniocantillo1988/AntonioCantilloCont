CREATE DATABASE  IF NOT EXISTS `contenedores` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `contenedores`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: contenedores
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alquilar`
--

DROP TABLE IF EXISTS `alquilar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `alquilar` (
  `idalquilar` int(11) NOT NULL AUTO_INCREMENT,
  `idusuarios` int(11) NOT NULL,
  `idcontenedor` int(11) NOT NULL,
  `fechaalquiler` timestamp NOT NULL,
  `duracion` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  PRIMARY KEY (`idalquilar`),
  KEY `FK_ALQUILAR_CONTENEDOR_idx` (`idcontenedor`),
  KEY `FK_ALQUILAR_USUARIOS_idx` (`idusuarios`),
  CONSTRAINT `FK_ALQUILAR_CONTENEDOR` FOREIGN KEY (`idcontenedor`) REFERENCES `contenedor` (`idcontenedor`),
  CONSTRAINT `FK_ALQUILAR_USUARIOS` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquilar`
--

LOCK TABLES `alquilar` WRITE;
/*!40000 ALTER TABLE `alquilar` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquilar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contenedor`
--

DROP TABLE IF EXISTS `contenedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `contenedor` (
  `idcontenedor` int(11) NOT NULL AUTO_INCREMENT,
  `tamanyo` int(11) NOT NULL,
  `disponibilidad` tinyint(1) NOT NULL,
  PRIMARY KEY (`idcontenedor`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contenedor`
--

LOCK TABLES `contenedor` WRITE;
/*!40000 ALTER TABLE `contenedor` DISABLE KEYS */;
INSERT INTO `contenedor` VALUES (3,4,1),(4,4,1),(5,4,1),(6,4,1),(7,4,1),(8,4,1),(9,4,1),(10,4,1),(11,4,1),(12,4,1),(13,4,1),(14,4,1),(15,4,1),(16,4,1),(17,4,1),(18,4,1),(19,4,1),(20,4,1),(21,4,1),(22,4,1),(23,4,1),(24,4,1),(25,4,1),(26,4,1),(27,4,1),(28,4,1),(29,4,1),(30,4,1),(31,4,1),(32,4,1),(33,4,1),(34,4,1),(35,4,1),(36,4,1),(37,4,1),(38,4,1),(39,4,1),(40,4,1),(41,4,1),(42,4,1),(43,4,1),(44,4,1),(45,4,1),(46,4,1),(47,4,1),(48,4,1),(49,4,1),(50,4,1);
/*!40000 ALTER TABLE `contenedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `factura` (
  `idfactura` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) NOT NULL,
  `pagado` tinyint(1) NOT NULL,
  `fechaactual` timestamp NOT NULL,
  PRIMARY KEY (`idfactura`),
  KEY `FK_FACTURA_USUARIOS_idx` (`idusuario`),
  CONSTRAINT `FK_FACTURA_USUARIOS` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`idusuarios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `privilegios`
--

DROP TABLE IF EXISTS `privilegios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `privilegios` (
  `idprivilegios` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`idprivilegios`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `privilegios`
--

LOCK TABLES `privilegios` WRITE;
/*!40000 ALTER TABLE `privilegios` DISABLE KEYS */;
INSERT INTO `privilegios` VALUES (1,'cliente'),(2,'trabajador'),(3,'administrador');
/*!40000 ALTER TABLE `privilegios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `idusuarios` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `fechaalta` timestamp NULL DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` int(9) DEFAULT NULL,
  `privilegios` int(11) NOT NULL,
  `correoelectronico` varchar(45) NOT NULL,
  `contrasenya` varchar(45) NOT NULL,
  PRIMARY KEY (`idusuarios`),
  KEY `FK_usuario_privilegios_idx` (`privilegios`),
  CONSTRAINT `FK_usuario_privilegios` FOREIGN KEY (`privilegios`) REFERENCES `privilegios` (`idprivilegios`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'aaa','asa','asdas','2018-11-12 23:00:00','as',21,2,'asdasd',''),(2,'aaa','asa','asdas','2018-11-12 23:00:00','as',21,2,'asdasd',''),(4,'aaa','asa','asdas','2018-11-12 23:00:00','as',21,2,'asdasd',''),(5,'aaa','asa','asdas','2018-11-12 23:00:00','as',21,2,'asdasd',''),(6,'aaa','asa','asdas','2018-11-12 23:00:00','as',21,2,'asdasd',''),(7,'aaa','asa','asdas','2018-11-12 23:00:00','as',21,2,'asdasd',''),(8,'aaa','asa','asdas','2018-11-12 23:00:00','as',21,2,'asdasd',''),(9,'aaa','asa','asdas','2018-11-12 23:00:00','as',21,2,'asdasd',''),(10,'aaa','asa','asdas','2018-11-12 23:00:00','as',21,2,'asdasd',''),(11,'aaa','asa','asdas','2018-11-12 23:00:00','as',21,2,'asdasd',''),(12,'aaa','asa','asdas','2018-11-12 23:00:00','as',21,2,'asdasd',''),(13,'aaa','asa','asdas','2018-11-12 23:00:00','as',21,2,'asdasd',''),(15,'123','Antonio','Cantillo Rueda','2018-11-12 23:00:00','c/Tomas Luis De Victoria,n13',952434196,3,'antonio-cantillo@hotmail.com','123'),(16,'aaa','aaa','aaa','2018-11-12 23:00:00','aaa',123,1,'aaa','aaa');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-19 19:14:06
