-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 02, 2019 at 05:13 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinica_medica`
--

-- --------------------------------------------------------

--
-- Table structure for table `agenda_equipamento`
--

CREATE TABLE `agenda_equipamento` (
  `data_agendamento` datetime NOT NULL,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `equipamento` int(11) DEFAULT NULL,
  `medico` int(11) DEFAULT NULL,
  `paciente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `agenda_medica`
--

CREATE TABLE `agenda_medica` (
  `data_agendamento` datetime NOT NULL,
  `medico` int(11) DEFAULT NULL,
  `paciente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `convenio`
--

CREATE TABLE `convenio` (
  `codigo` int(11) NOT NULL,
  `sigla` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `dia_atendimento`
--

CREATE TABLE `dia_atendimento` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `equipamento`
--

CREATE TABLE `equipamento` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `exame` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `especialidade`
--

CREATE TABLE `especialidade` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `medico`
--

CREATE TABLE `medico` (
  `codigo` int(11) NOT NULL,
  `crm` int(11) NOT NULL,
  `celular` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `horario_atendimento` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `intervalo_atendimento` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `especialidade` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `medico_dia_atendimento`
--

CREATE TABLE `medico_dia_atendimento` (
  `medico` int(11) NOT NULL,
  `dia_atendimento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `paciente`
--

CREATE TABLE `paciente` (
  `codigo` int(11) NOT NULL,
  `data_nascimento` datetime DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sexo` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `celular` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `convenio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tipo_exame`
--

CREATE TABLE `tipo_exame` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agenda_equipamento`
--
ALTER TABLE `agenda_equipamento`
  ADD PRIMARY KEY (`data_agendamento`),
  ADD KEY `FKat4s2xxfwwdouirrhrdq9gqf5` (`equipamento`),
  ADD KEY `FKimorx7gnakdvhm283w6vco25l` (`medico`),
  ADD KEY `FKe675x304fb6nsikfh9srvfs5k` (`paciente`);

--
-- Indexes for table `agenda_medica`
--
ALTER TABLE `agenda_medica`
  ADD PRIMARY KEY (`data_agendamento`),
  ADD KEY `FKq9rasbd4afh3y72yy9nbhl97u` (`medico`),
  ADD KEY `FK6xmjl9d2aifsjl2xjhj6xf4p` (`paciente`);

--
-- Indexes for table `convenio`
--
ALTER TABLE `convenio`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `dia_atendimento`
--
ALTER TABLE `dia_atendimento`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `equipamento`
--
ALTER TABLE `equipamento`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FKj1dwpvtl44mhpawsvnrrgwnaw` (`exame`);

--
-- Indexes for table `especialidade`
--
ALTER TABLE `especialidade`
  ADD PRIMARY KEY (`codigo`);

--
-- Indexes for table `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FKdmclvr2kjnm3jmdlidvshffwt` (`especialidade`);

--
-- Indexes for table `medico_dia_atendimento`
--
ALTER TABLE `medico_dia_atendimento`
  ADD KEY `FK2lj37oje00so0ng85tipoxtd3` (`dia_atendimento`),
  ADD KEY `FKkevn72ws8vstfls0jhv50wiej` (`medico`);

--
-- Indexes for table `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FK74s4f2eonv2jf2pksp0ujldhk` (`convenio`);

--
-- Indexes for table `tipo_exame`
--
ALTER TABLE `tipo_exame`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `convenio`
--
ALTER TABLE `convenio`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `equipamento`
--
ALTER TABLE `equipamento`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `especialidade`
--
ALTER TABLE `especialidade`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `medico`
--
ALTER TABLE `medico`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `paciente`
--
ALTER TABLE `paciente`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `tipo_exame`
--
ALTER TABLE `tipo_exame`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `agenda_equipamento`
--
ALTER TABLE `agenda_equipamento`
  ADD CONSTRAINT `FKat4s2xxfwwdouirrhrdq9gqf5` FOREIGN KEY (`equipamento`) REFERENCES `equipamento` (`codigo`),
  ADD CONSTRAINT `FKe675x304fb6nsikfh9srvfs5k` FOREIGN KEY (`paciente`) REFERENCES `paciente` (`codigo`),
  ADD CONSTRAINT `FKimorx7gnakdvhm283w6vco25l` FOREIGN KEY (`medico`) REFERENCES `medico` (`codigo`);

--
-- Constraints for table `agenda_medica`
--
ALTER TABLE `agenda_medica`
  ADD CONSTRAINT `FK6xmjl9d2aifsjl2xjhj6xf4p` FOREIGN KEY (`paciente`) REFERENCES `paciente` (`codigo`),
  ADD CONSTRAINT `FKq9rasbd4afh3y72yy9nbhl97u` FOREIGN KEY (`medico`) REFERENCES `medico` (`codigo`);

--
-- Constraints for table `equipamento`
--
ALTER TABLE `equipamento`
  ADD CONSTRAINT `FKj1dwpvtl44mhpawsvnrrgwnaw` FOREIGN KEY (`exame`) REFERENCES `tipo_exame` (`codigo`);

--
-- Constraints for table `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `FKdmclvr2kjnm3jmdlidvshffwt` FOREIGN KEY (`especialidade`) REFERENCES `especialidade` (`codigo`);

--
-- Constraints for table `medico_dia_atendimento`
--
ALTER TABLE `medico_dia_atendimento`
  ADD CONSTRAINT `FK2lj37oje00so0ng85tipoxtd3` FOREIGN KEY (`dia_atendimento`) REFERENCES `dia_atendimento` (`codigo`),
  ADD CONSTRAINT `FKkevn72ws8vstfls0jhv50wiej` FOREIGN KEY (`medico`) REFERENCES `medico` (`codigo`);

--
-- Constraints for table `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `FK74s4f2eonv2jf2pksp0ujldhk` FOREIGN KEY (`convenio`) REFERENCES `convenio` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
