-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Lun 09 Avril 2018 à 13:18
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tomcat_serviceannuaire`
--

-- --------------------------------------------------------

--
-- Structure de la table `succursales`
--

DROP TABLE IF EXISTS `succursales`;
CREATE TABLE `succursales` (
  `NOENTREPRISEQUEBEC` int(10) NOT NULL,
  `NOM` varchar(100) NOT NULL,
  `LONGITUDE` decimal(9,6) NOT NULL,
  `LATTITUDE` decimal(9,6) NOT NULL,
  `DESCRIPTION` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS POUR LA TABLE `succursales`:
--

--
-- Vider la table avant d'insérer `succursales`
--

TRUNCATE TABLE `succursales`;
--
-- Contenu de la table `succursales`
--

INSERT INTO `succursales` (`NOENTREPRISEQUEBEC`, `NOM`, `LONGITUDE`, `LATTITUDE`, `DESCRIPTION`) VALUES
(123456789, 'LA bella del torro', '45.540974', '-73.576538', 0x626f626f202a206d616c6d616c);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `succursales`
--
ALTER TABLE `succursales`
  ADD PRIMARY KEY (`NOENTREPRISEQUEBEC`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

CREATE USER 'monuser'@'%' IDENTIFIED BY 'mypassword';
grant all privileges on `tomcat\_%`.* to 'monuser'@'%';
