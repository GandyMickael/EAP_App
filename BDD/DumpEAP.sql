CREATE DATABASE  IF NOT EXISTS `eap` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `eap`;
-- MySQL dump 10.13  Distrib 5.6.43, for Win64 (x86_64)
--
-- Host: localhost    Database: eap
-- ------------------------------------------------------
-- Server version	5.6.11

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

/*!40000 ALTER TABLE `eap` DISABLE KEYS */;
INSERT INTO `eap` (`id`, `nom`, `adresse`, `numtel`, `adressemail`, `idSalle`) VALUES (1234,'EspaceAPartager','2 rue du dragon EVRY','0123456789','eap@eap.com',NULL);
/*!40000 ALTER TABLE `eap` ENABLE KEYS */;

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
  `mdp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEntrepriseCliente`)
) ENGINE=MyISAM AUTO_INCREMENT=1235468742 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entreprisecliente`
--

/*!40000 ALTER TABLE `entreprisecliente` DISABLE KEYS */;
INSERT INTO `entreprisecliente` (`idEntrepriseCliente`, `nom`, `adresse`, `numtel`, `adressemail`, `nbLocationsEffectuee`, `mdp`) VALUES (1,'CliCli','2 bambou',123456788,'clicli@clicli.com',18,'CliCli'),(2,'AnimaBoire','a',1,'a',0,'AnimaBoire'),(1235468741,'Test','',650020445,'jean@d.fr',0,'Test'),(3,'Cli','3 rue hoche',600000000,'osef@gmail.com',9,'Cli');
/*!40000 ALTER TABLE `entreprisecliente` ENABLE KEYS */;

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
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facture`
--

/*!40000 ALTER TABLE `facture` DISABLE KEYS */;
INSERT INTO `facture` (`idFacture`, `prix`, `idEntrepriseCliente`, `etat`) VALUES (7,200,1,'Payée'),(8,40,1,'Payée'),(9,100,1,'Payée'),(10,340,1,'Payée'),(11,0,1,'Payée'),(12,0,1,'Payée'),(13,0,1,'En attente de paiement'),(14,20,1,'En attente de paiement'),(15,0,3,'Payée');
/*!40000 ALTER TABLE `facture` ENABLE KEYS */;

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
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;

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
) ENGINE=MyISAM AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salle`
--

/*!40000 ALTER TABLE `salle` DISABLE KEYS */;
INSERT INTO `salle` (`idSalle`, `nom`, `etat`, `typeSalle`, `nbLocations`) VALUES (56,'Bureau 459','Libre','Bureaux',1),(57,'Salle de réunion 459','Libre','Salle de Réunion',0),(47,'Bureau 1','Libre','Salle',9),(48,'Salle de réunion 1','Libre','Salle',2),(49,'Bureau 2','Libre','Salle',0),(50,'Bureau 6','Libre','Salle',0),(51,'Salle de réunion 6','Libre','Salle',0),(52,'Bureau 36','Libre','Salle',0),(53,'Bureau 45','Libre','Salle',0),(54,'Bureau 455','Libre','Salle',0),(55,'Bureau 123','Libre','Bureaux',0);
/*!40000 ALTER TABLE `salle` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-01 20:06:18
