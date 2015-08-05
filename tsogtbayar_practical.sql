-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 05, 2015 at 02:29 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tsogtbayar_practical`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(150) COLLATE utf8_bin NOT NULL,
  `password` varchar(150) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin123');

-- --------------------------------------------------------

--
-- Table structure for table `permission`
--

CREATE TABLE IF NOT EXISTS `permission` (
  `per_id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL,
  `id` tinyint(4) NOT NULL DEFAULT '1',
  `undes` tinyint(4) NOT NULL DEFAULT '1',
  `lastname` tinyint(4) NOT NULL DEFAULT '1',
  `firstname` tinyint(4) NOT NULL DEFAULT '1',
  `gender` tinyint(4) NOT NULL DEFAULT '1',
  `birthday` tinyint(4) NOT NULL DEFAULT '1',
  `phone` tinyint(4) NOT NULL DEFAULT '1',
  `address` tinyint(4) NOT NULL DEFAULT '1',
  `registrationNum` tinyint(4) NOT NULL DEFAULT '1',
  `identityNum` tinyint(4) NOT NULL DEFAULT '1',
  `career` tinyint(4) NOT NULL DEFAULT '1',
  `education` tinyint(4) NOT NULL DEFAULT '1',
  `married` tinyint(4) NOT NULL DEFAULT '1',
  `highschool` tinyint(4) NOT NULL DEFAULT '1',
  `university` tinyint(4) NOT NULL DEFAULT '1',
  `language` tinyint(4) NOT NULL DEFAULT '1',
  `computerKnowledge` tinyint(4) NOT NULL DEFAULT '1',
  `img` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`per_id`),
  KEY `FK_Person_Permission01` (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE IF NOT EXISTS `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `undes` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `lastname` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `firstname` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `gender` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `birthday` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `address` text COLLATE utf8_bin,
  `registrationNum` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `identityNum` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `career` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `education` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `married` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `highschool` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `university` varchar(150) COLLATE utf8_bin DEFAULT NULL,
  `language` text COLLATE utf8_bin,
  `computerKnowledge` text COLLATE utf8_bin,
  `img` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=7 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `permission`
--
ALTER TABLE `permission`
  ADD CONSTRAINT `FK_Person_Permission01` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
