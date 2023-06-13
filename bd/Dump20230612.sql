-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_proyfinal_daw2
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `idestado` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idestado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Activo'),(2,'Inactivo');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matricula` (
  `matricula_id` bigint NOT NULL,
  `curso_id` bigint NOT NULL,
  KEY `FKer9dg736msnpcwjwage0hpkg` (`matricula_id`),
  KEY `FK2wiru6ht82h611x9wmf2qdbs6` (`curso_id`),
  CONSTRAINT `FK2wiru6ht82h611x9wmf2qdbs6` FOREIGN KEY (`curso_id`) REFERENCES `tb_cursos` (`id`),
  CONSTRAINT `FKer9dg736msnpcwjwage0hpkg` FOREIGN KEY (`matricula_id`) REFERENCES `tb_matriculas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
INSERT INTO `matricula` VALUES (1,1),(2,1),(2,2),(3,1),(3,2),(4,1),(4,2);
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor_curso`
--

DROP TABLE IF EXISTS `profesor_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor_curso` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `curso_id` bigint DEFAULT NULL,
  `idestado` bigint DEFAULT NULL,
  `profesor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK99u9snh19ogk5b95hsbyck4af` (`curso_id`),
  KEY `FK5w4f7lhyd8716juy2mgkor9r3` (`idestado`),
  KEY `FKes1b9vpox7x35si05fjicerbm` (`profesor_id`),
  CONSTRAINT `FK5w4f7lhyd8716juy2mgkor9r3` FOREIGN KEY (`idestado`) REFERENCES `estado` (`idestado`),
  CONSTRAINT `FK99u9snh19ogk5b95hsbyck4af` FOREIGN KEY (`curso_id`) REFERENCES `tb_cursos` (`id`),
  CONSTRAINT `FKes1b9vpox7x35si05fjicerbm` FOREIGN KEY (`profesor_id`) REFERENCES `tb_profesores` (`idprof`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor_curso`
--

LOCK TABLES `profesor_curso` WRITE;
/*!40000 ALTER TABLE `profesor_curso` DISABLE KEYS */;
INSERT INTO `profesor_curso` VALUES (1,1,1,1),(2,1,1,2),(3,2,1,3),(4,3,1,2);
/*!40000 ALTER TABLE `profesor_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'ALUMNO');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_alumnos`
--

DROP TABLE IF EXISTS `tb_alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_alumnos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apealum` varchar(255) DEFAULT NULL,
  `celalum` varchar(255) DEFAULT NULL,
  `dnialum` varchar(255) DEFAULT NULL,
  `fechalum` varchar(255) DEFAULT NULL,
  `nomalum` varchar(255) DEFAULT NULL,
  `passalum` varchar(255) DEFAULT NULL,
  `usualum` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_alumnos`
--

LOCK TABLES `tb_alumnos` WRITE;
/*!40000 ALTER TABLE `tb_alumnos` DISABLE KEYS */;
INSERT INTO `tb_alumnos` VALUES (1,'Malpartida Roncal','918470963','77391507','1995-05-08','Junior Jhony','Qx4zio','juniorjhonnymalpartida@gmail.com',NULL),(2,'Anna Marie','D\'Ancanto','56325961','2004-10-01','923456739','rogue@xmen.com','111111',NULL),(3,'Bobby','Drake','58320963','2003-02-11','998456210','iceman@xmen.com','222222',NULL),(4,'Pietro','Maximoff','58320970','2003-03-01','998456233','quicksilver@xmen.com','333333',NULL),(8,'Malpartida Roncal','918470963','77391507','1995-05-08','Junior Jhony',NULL,NULL,9),(9,'Malpartida Roncal','918470963','77391507','1995-06-08','Junior Jhony',NULL,NULL,10),(10,'Quispe Ruis','918470960','77391508','1996-02-02','Luis Alonso',NULL,NULL,11);
/*!40000 ALTER TABLE `tb_alumnos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cursos`
--

DROP TABLE IF EXISTS `tb_cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cursos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nomcurso` varchar(255) DEFAULT NULL,
  `descripcion_curso` varchar(255) DEFAULT NULL,
  `precio` double NOT NULL,
  `url_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cursos`
--

LOCK TABLES `tb_cursos` WRITE;
/*!40000 ALTER TABLE `tb_cursos` DISABLE KEYS */;
INSERT INTO `tb_cursos` VALUES (1,'Bases de datos (Mysql)','Es un sistema de gestión de bases de datos relacional desarrollado bajo licencia dual: Licencia pública general/Licencia comercial por Oracle Corporation y está considerada como la base de datos de código abierto más popular del mundo.',95.65,'img/curso/mysql-logo.svg'),(2,'Angular','El marco de desarrollo web para construir el futuro',102.45,'img/curso/angular.svg'),(3,'Bases de datos (PostgreSQL)','PostgreSQL: La base de datos relacional de código abierto más avanzada del mundo',98.5,'img/curso/postgresql.png'),(4,'Phyton','es un sistema de gestión de bases de datos relacional desarrollado bajo licencia dual: Licencia pública general/Licencia comercial por Oracle Corporation y está considerada como la base de datos de código abierto más popular del mundo',120.57,'img/curso/python-logo.png');
/*!40000 ALTER TABLE `tb_cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_horarios`
--

DROP TABLE IF EXISTS `tb_horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_horarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `deshorario` varchar(255) DEFAULT NULL,
  `fin` datetime(6) DEFAULT NULL,
  `inicio` datetime(6) DEFAULT NULL,
  `profesor_curso_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_horarios`
--

LOCK TABLES `tb_horarios` WRITE;
/*!40000 ALTER TABLE `tb_horarios` DISABLE KEYS */;
INSERT INTO `tb_horarios` VALUES (1,NULL,'2023-06-12 09:15:00.000000','2023-06-12 07:00:00.000000',1),(2,NULL,'2023-01-01 09:15:00.000000','2023-01-01 07:00:00.000000',2),(3,NULL,'2023-06-13 09:15:00.000000','2023-06-13 07:00:00.000000',3),(4,NULL,'2023-01-01 11:30:00.000000','2023-01-01 09:15:00.000000',1);
/*!40000 ALTER TABLE `tb_horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_matriculas`
--

DROP TABLE IF EXISTS `tb_matriculas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_matriculas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `fechmat` datetime(6) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_matriculas`
--

LOCK TABLES `tb_matriculas` WRITE;
/*!40000 ALTER TABLE `tb_matriculas` DISABLE KEYS */;
INSERT INTO `tb_matriculas` VALUES (1,'2023-06-11 03:07:31.827638',4),(2,'2023-06-11 12:35:05.852725',4),(3,'2023-06-11 12:40:22.030806',4),(4,'2023-06-12 23:04:51.407281',4);
/*!40000 ALTER TABLE `tb_matriculas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_profesores`
--

DROP TABLE IF EXISTS `tb_profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_profesores` (
  `idprof` bigint NOT NULL AUTO_INCREMENT,
  `celprof` varchar(255) DEFAULT NULL,
  `dniprof` varchar(255) DEFAULT NULL,
  `espeprof` varchar(255) DEFAULT NULL,
  `ape_mat_prof` varchar(255) DEFAULT NULL,
  `ape_pat_prof` varchar(255) DEFAULT NULL,
  `nombresprof` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idprof`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_profesores`
--

LOCK TABLES `tb_profesores` WRITE;
/*!40000 ALTER TABLE `tb_profesores` DISABLE KEYS */;
INSERT INTO `tb_profesores` VALUES (1,'876543210','67890123','ANALISTA DE BASE DATOS','García','Pérez','Juan Luis'),(2,'321098765','78901234','ANALISTA DE BASE DATOS','Rodríguez','Martínez','María Ana'),(3,'109876543','89012345','FRONT END','López','Sánchez','Pedro'),(4,'109876543','23456789','ANALISTA DE BASE DATOS','González','Romero','Laura Andrea');
/*!40000 ALTER TABLE `tb_profesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKhfh9dx7w3ubf1co1vdev94g3f` (`user_id`),
  KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`),
  CONSTRAINT `FKh8ciramu9cc9q3qcqiv4ue8a6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `FKhfh9dx7w3ubf1co1vdev94g3f` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (4,1),(9,1),(10,1),(11,1),(4,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (4,'$2a$10$SLjZ2KeWGzjWtqDJzf4XKuga7uy26s8A6gsUMlJtgd6qKJyuclOje','admin'),(9,'$2a$10$Hx0cbJ3K5/KyyxEAhWfSaehXHMPytUt/fyMjWntEWTBOLgqIHLSgC','junmalpart@gmail.com'),(10,'$2a$10$Hx0cbJ3K5/KyyxEAhWfSaehXHMPytUt/fyMjWntEWTBOLgqIHLSgC','jmalpartida@gmail.com'),(11,'$2a$10$yU4pLFyqIwk95pnX8U9Slumdu/N8n1WuZPotARiVHM38w2RCKShei','lalonso@gmail.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-12 23:12:24
