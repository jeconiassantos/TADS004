-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2019 at 03:08 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `campeonato`
--

-- --------------------------------------------------------

--
-- Table structure for table `jogador`
--

CREATE TABLE `jogador` (
  `cod` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `data_nascimento` varchar(20) NOT NULL,
  `Time_cod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jogador`
--

INSERT INTO `jogador` (`cod`, `nome`, `data_nascimento`, `Time_cod`) VALUES
(6, 'Jeconias', '2019-10-10', 1),
(10, 'João', '2019-10-10', 2),
(12, 'José', '2019-03-07', 1);

-- --------------------------------------------------------

--
-- Table structure for table `jogadorparticipante`
--

CREATE TABLE `jogadorparticipante` (
  `cod_participacao` int(11) NOT NULL,
  `jogo_cod` int(11) NOT NULL,
  `jogador_cod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `jogo`
--

CREATE TABLE `jogo` (
  `cod` int(11) NOT NULL,
  `resultado` varchar(45) NOT NULL,
  `timea_cod` int(11) NOT NULL,
  `timeb_cod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jogo`
--

INSERT INTO `jogo` (`cod`, `resultado`, `timea_cod`, `timeb_cod`) VALUES
(3, '0-1', 2, 1),
(50, '1-0', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `time`
--

CREATE TABLE `time` (
  `cod` int(11) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `data_fundacao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `time`
--

INSERT INTO `time` (`cod`, `nome`, `data_fundacao`) VALUES
(1, 'Vasco', '2019-10-10'),
(2, 'Flamengo', '2019-10-11'),
(3, 'São Paulo', '2019-10-10'),
(5, 'Palmeiras', '2019-11-11'),
(54, 'Santos', '2017-11-10'),
(231, 'Bahia', '2019-10-10'),
(323, 'ABC', '2018-05-05');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jogador`
--
ALTER TABLE `jogador`
  ADD PRIMARY KEY (`cod`),
  ADD KEY `Time_cod` (`Time_cod`);

--
-- Indexes for table `jogadorparticipante`
--
ALTER TABLE `jogadorparticipante`
  ADD PRIMARY KEY (`cod_participacao`),
  ADD KEY `jogo_cod` (`jogo_cod`),
  ADD KEY `jogador_cod` (`jogador_cod`);

--
-- Indexes for table `jogo`
--
ALTER TABLE `jogo`
  ADD PRIMARY KEY (`cod`),
  ADD KEY `timea_cod` (`timea_cod`),
  ADD KEY `timeb_cod` (`timeb_cod`);

--
-- Indexes for table `time`
--
ALTER TABLE `time`
  ADD PRIMARY KEY (`cod`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `jogador`
--
ALTER TABLE `jogador`
  ADD CONSTRAINT `jogador_ibfk_1` FOREIGN KEY (`Time_cod`) REFERENCES `time` (`cod`);

--
-- Constraints for table `jogadorparticipante`
--
ALTER TABLE `jogadorparticipante`
  ADD CONSTRAINT `jogadorparticipante_ibfk_1` FOREIGN KEY (`jogo_cod`) REFERENCES `jogo` (`cod`),
  ADD CONSTRAINT `jogadorparticipante_ibfk_2` FOREIGN KEY (`jogador_cod`) REFERENCES `jogador` (`cod`);

--
-- Constraints for table `jogo`
--
ALTER TABLE `jogo`
  ADD CONSTRAINT `jogo_ibfk_1` FOREIGN KEY (`timea_cod`) REFERENCES `time` (`cod`),
  ADD CONSTRAINT `jogo_ibfk_2` FOREIGN KEY (`timeb_cod`) REFERENCES `time` (`cod`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
