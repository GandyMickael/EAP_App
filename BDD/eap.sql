-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 05 Avril 2019 à 18:56
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `eap`
--

-- --------------------------------------------------------

--
-- Structure de la table `eap`
--

CREATE TABLE IF NOT EXISTS `eap` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `adresse` varchar(30) DEFAULT NULL,
  `numtel` varchar(30) DEFAULT NULL,
  `adressemail` varchar(30) DEFAULT NULL,
  `idSalle` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idSalle` (`idSalle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `eap`
--

INSERT INTO `eap` (`id`, `nom`, `adresse`, `numtel`, `adressemail`, `idSalle`) VALUES
(1234, 'EspaceAPartager', '2 rue du dragon EVRY', '0123456789', 'eap@eap.com', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `entreprisecliente`
--

CREATE TABLE IF NOT EXISTS `entreprisecliente` (
  `idEntrepriseCliente` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `adresse` varchar(30) DEFAULT NULL,
  `numtel` int(11) DEFAULT NULL,
  `adressemail` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idEntrepriseCliente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `entreprisecliente`
--

INSERT INTO `entreprisecliente` (`idEntrepriseCliente`, `nom`, `adresse`, `numtel`, `adressemail`) VALUES
(1, 'CliCli', '2 bambou', 123456788, 'clicli@clicli.com');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE IF NOT EXISTS `facture` (
  `idFacture` int(11) NOT NULL,
  `prix` int(11) DEFAULT NULL,
  `numBureauxLoué` int(11) DEFAULT NULL,
  `nbHeureBureauxLoué` int(11) DEFAULT NULL,
  `numSalleDRLoué` int(11) DEFAULT NULL,
  `nbHeureSalleDRLoué` int(11) DEFAULT NULL,
  `idLocation` int(11) DEFAULT NULL,
  `idEntrepriseCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idFacture`),
  KEY `idLocation` (`idLocation`),
  KEY `idEntrepriseCliente` (`idEntrepriseCliente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE IF NOT EXISTS `location` (
  `id` int(11) NOT NULL,
  `dateDebut` varchar(30) DEFAULT NULL,
  `dateFin` varchar(30) DEFAULT NULL,
  `idSalle` int(11) DEFAULT NULL,
  `idEntrepriseCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idSalle` (`idSalle`),
  KEY `idEntrepriseCliente` (`idEntrepriseCliente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE IF NOT EXISTS `salle` (
  `idSalle` int(11) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `etat` varchar(30) DEFAULT NULL,
  `typeSalle` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idSalle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `salle`
--

INSERT INTO `salle` (`idSalle`, `nom`, `etat`, `typeSalle`) VALUES
(1, 'Bureaux 1', 'Libre', 'Bureaux'),
(2, 'Bureaux 2', 'Libre', 'Bureaux'),
(3, 'Bureaux 3', 'Libre', 'Bureaux'),
(4, 'Bureaux 4 ', 'Libre', 'Bureaux'),
(5, 'Bureaux 5', 'Libre', 'Bureaux'),
(6, 'Salle de Réunion 1', 'Libre', 'Salle de Réunion'),
(7, 'Salle de Réunion 2', 'Libre', 'Salle de Réunion'),
(8, 'Salle de Réunion 3', 'Libre', 'Salle de Réunion'),
(9, 'Salle de Réunion 4', 'Libre', 'Salle de Réunion'),
(10, 'Salle de Réunion 5', 'Libre', 'Salle de Réunion');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
