CREATE DATABASE /*!32312 IF NOT EXISTS*/ `clinica_medica` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `clinica_medica`;

--
-- Table structure for table `tipo_exame`
--

DROP TABLE IF EXISTS `tipo_exame`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_exame` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `especialidade`
--

DROP TABLE IF EXISTS `especialidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `especialidade` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `dia_atendimento`
--

DROP TABLE IF EXISTS `dia_atendimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dia_atendimento` (
  `codigo` int(11) NOT NULL,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
--
-- Table structure for table `convenio`
--

DROP TABLE IF EXISTS `convenio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `convenio` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `sigla` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `agenda_equipamento`
--

DROP TABLE IF EXISTS `agenda_equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda_equipamento` (
  `data_agendamento` datetime NOT NULL,
  `descricao` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `equipamento` int(11) DEFAULT NULL,
  `medico` int(11) DEFAULT NULL,
  `paciente` int(11) DEFAULT NULL,
  PRIMARY KEY (`data_agendamento`),
  KEY `FKat4s2xxfwwdouirrhrdq9gqf5` (`equipamento`),
  KEY `FKimorx7gnakdvhm283w6vco25l` (`medico`),
  KEY `FKe675x304fb6nsikfh9srvfs5k` (`paciente`),
  CONSTRAINT `FKat4s2xxfwwdouirrhrdq9gqf5` FOREIGN KEY (`equipamento`) REFERENCES `equipamento` (`codigo`),
  CONSTRAINT `FKe675x304fb6nsikfh9srvfs5k` FOREIGN KEY (`paciente`) REFERENCES `paciente` (`codigo`),
  CONSTRAINT `FKimorx7gnakdvhm283w6vco25l` FOREIGN KEY (`medico`) REFERENCES `medico` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `agenda_medica`
--

DROP TABLE IF EXISTS `agenda_medica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda_medica` (
  `data_agendamento` datetime NOT NULL,
  `medico` int(11) DEFAULT NULL,
  `paciente` int(11) DEFAULT NULL,
  PRIMARY KEY (`data_agendamento`),
  KEY `FKq9rasbd4afh3y72yy9nbhl97u` (`medico`),
  KEY `FK6xmjl9d2aifsjl2xjhj6xf4p` (`paciente`),
  CONSTRAINT `FK6xmjl9d2aifsjl2xjhj6xf4p` FOREIGN KEY (`paciente`) REFERENCES `paciente` (`codigo`),
  CONSTRAINT `FKq9rasbd4afh3y72yy9nbhl97u` FOREIGN KEY (`medico`) REFERENCES `medico` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `equipamento`
--

DROP TABLE IF EXISTS `equipamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipamento` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `exame` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKj1dwpvtl44mhpawsvnrrgwnaw` (`exame`),
  CONSTRAINT `FKj1dwpvtl44mhpawsvnrrgwnaw` FOREIGN KEY (`exame`) REFERENCES `tipo_exame` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico` (  
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `crm` int(11) NOT NULL,
  `celular` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `horario_atendimento` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `intervalo_atendimento` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `especialidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FKdmclvr2kjnm3jmdlidvshffwt` (`especialidade`),
  CONSTRAINT `FKdmclvr2kjnm3jmdlidvshffwt` FOREIGN KEY (`especialidade`) REFERENCES `especialidade` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `medico_dia_atendimento`
--

DROP TABLE IF EXISTS `medico_dia_atendimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico_dia_atendimento` (
  `medico` int(11) NOT NULL,
  `dia_atendimento` int(11) NOT NULL,
  KEY `FK2lj37oje00so0ng85tipoxtd3` (`dia_atendimento`),
  KEY `FKkevn72ws8vstfls0jhv50wiej` (`medico`),
  CONSTRAINT `FK2lj37oje00so0ng85tipoxtd3` FOREIGN KEY (`dia_atendimento`) REFERENCES `dia_atendimento` (`codigo`),
  CONSTRAINT `FKkevn72ws8vstfls0jhv50wiej` FOREIGN KEY (`medico`) REFERENCES `medico` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `data_nascimento` datetime DEFAULT NULL,
  `nome` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sexo` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `celular` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `convenio` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FK74s4f2eonv2jf2pksp0ujldhk` (`convenio`),
  CONSTRAINT `FK74s4f2eonv2jf2pksp0ujldhk` FOREIGN KEY (`convenio`) REFERENCES `convenio` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-16 11:53:51
