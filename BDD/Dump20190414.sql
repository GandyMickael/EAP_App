CREATE DATABASE  IF NOT EXISTS `eap` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `eap`;
-- MySQL dump 10.13  Distrib 5.6.43, for Win64 (x86_64)
--
-- Host: localhost    Database: eap
-- ------------------------------------------------------
-- Server version	5.6.43-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `eap`
--

DROP TABLE IF EXISTS `eap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eap` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `adresse` varchar(30) DEFAULT NULL,
  `numtel` varchar(30) DEFAULT NULL,
  `adressemail` varchar(30) DEFAULT NULL,
  `idSalle` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idSalle` (`idSalle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eap`
--

LOCK TABLES `eap` WRITE;
/*!40000 ALTER TABLE `eap` DISABLE KEYS */;
INSERT INTO `eap` (`id`, `nom`, `adresse`, `numtel`, `adressemail`, `idSalle`) VALUES (1234,'EspaceAPartager','2 rue du dragon EVRY','0123456789','eap@eap.com',NULL);
/*!40000 ALTER TABLE `eap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entreprisecliente`
--

DROP TABLE IF EXISTS `entreprisecliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entreprisecliente` (
  `idEntrepriseCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) DEFAULT NULL,
  `adresse` varchar(30) DEFAULT NULL,
  `numtel` int(11) DEFAULT NULL,
  `adressemail` varchar(30) DEFAULT NULL,
  `nbLocationsEffectuee` int(45) DEFAULT NULL,
  PRIMARY KEY (`idEntrepriseCliente`)
) ENGINE=MyISAM AUTO_INCREMENT=1235468735 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entreprisecliente`
--

LOCK TABLES `entreprisecliente` WRITE;
/*!40000 ALTER TABLE `entreprisecliente` DISABLE KEYS */;
INSERT INTO `entreprisecliente` (`idEntrepriseCliente`, `nom`, `adresse`, `numtel`, `adressemail`, `nbLocationsEffectuee`) VALUES (1,'CliCli','2 bambou',123456788,'clicli@clicli.com',2),(2,'AnimaBoire','a',1,'a',0);
/*!40000 ALTER TABLE `entreprisecliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facture`
--

DROP TABLE IF EXISTS `facture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facture` (
  `idFacture` int(11) NOT NULL AUTO_INCREMENT,
  `prix` int(11) DEFAULT NULL,
  `idEntrepriseCliente` int(11) DEFAULT NULL,
  `etat` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idFacture`),
  KEY `idEntrepriseCliente` (`idEntrepriseCliente`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facture`
--

LOCK TABLES `facture` WRITE;
/*!40000 ALTER TABLE `facture` DISABLE KEYS */;
INSERT INTO `facture` (`idFacture`, `prix`, `idEntrepriseCliente`, `etat`) VALUES (4,160,1,'Payée');
/*!40000 ALTER TABLE `facture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebut` varchar(30) DEFAULT NULL,
  `dateFin` varchar(30) DEFAULT NULL,
  `idSalle` int(11) DEFAULT NULL,
  `idEntrepriseCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idSalle` (`idSalle`),
  KEY `idEntrepriseCliente` (`idEntrepriseCliente`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` (`id`, `dateDebut`, `dateFin`, `idSalle`, `idEntrepriseCliente`) VALUES (1,'11/02/1997','13/02/1997',2,1),(2,'11/02/2010','13/02/2010',3,2),(3,'12/04/2010','25/04/2010',22,1),(5,'12/05/2010','13/05/2010',22,1);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salle`
--

DROP TABLE IF EXISTS `salle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salle` (
  `idSalle` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) DEFAULT NULL,
  `etat` varchar(30) DEFAULT NULL,
  `typeSalle` varchar(30) DEFAULT NULL,
  `nbLocations` int(45) DEFAULT NULL,
  PRIMARY KEY (`idSalle`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salle`
--

LOCK TABLES `salle` WRITE;
/*!40000 ALTER TABLE `salle` DISABLE KEYS */;
INSERT INTO `salle` (`idSalle`, `nom`, `etat`, `typeSalle`, `nbLocations`) VALUES (1,'Bureaux 1','Libre','Bureaux',0),(2,'Bureaux 2','Libre','Bureaux',0),(3,'Bureaux 3','Libre','Bureaux',0),(4,'Bureaux 4 ','Libre','Bureaux',0),(5,'Bureaux 5','Libre','Bureaux',0),(6,'Salle de Réunion 1','Libre','Salle de Réunion',0),(7,'Salle de Réunion 2','Libre','Salle de Réunion',0),(8,'Salle de Réunion 3','Libre','Salle de Réunion',0),(9,'Salle de Réunion 4','Libre','Salle de Réunion',0),(10,'Salle de Réunion 5','Libre','Salle de Réunion',0),(22,'Bureau 136','Libre','Bureaux',1);
/*!40000 ALTER TABLE `salle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-14  1:00:37
