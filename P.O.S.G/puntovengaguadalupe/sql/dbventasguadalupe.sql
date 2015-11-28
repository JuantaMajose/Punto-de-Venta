-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 06-08-2014 a las 14:50:56
-- Versión del servidor: 5.6.12-log
-- Versión de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `dbventasguadalupe`
--
CREATE DATABASE IF NOT EXISTS `dbventasguadalupe` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `dbventasguadalupe`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productosmodificados`
--

CREATE TABLE IF NOT EXISTS `productosmodificados` (
  `idProductosModificados` int(11) NOT NULL AUTO_INCREMENT,
  `tblProductos_CodProducto` varchar(25) NOT NULL,
  PRIMARY KEY (`idProductosModificados`),
  KEY `fk_ProductosModificados_tblProductos1_idx` (`tblProductos_CodProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblclientes`
--

CREATE TABLE IF NOT EXISTS `tblclientes` (
  `codCliente` varchar(25) NOT NULL,
  `NombreCliente` varchar(45) DEFAULT NULL,
  `ApellidoCliente` varchar(45) DEFAULT NULL,
  `TelefonoCliente` varchar(45) DEFAULT NULL,
  `DireccionCliente` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblfactura`
--

CREATE TABLE IF NOT EXISTS `tblfactura` (
  `idFactura` int(11) NOT NULL,
  `FechaFactura` datetime DEFAULT NULL,
  `Total` float DEFAULT NULL,
  `tblClientes_codCliente` varchar(25) NOT NULL,
  `ImprimirFactura` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `fk_tblFactura_tblClientes1_idx` (`tblClientes_codCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblmarca`
--

CREATE TABLE IF NOT EXISTS `tblmarca` (
  `idtblMarca` int(11) NOT NULL AUTO_INCREMENT,
  `NombreMarca` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtblMarca`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `tblmarca`
--

INSERT INTO `tblmarca` (`idtblMarca`, `NombreMarca`) VALUES
(3, 'Danonino'),
(4, 'Telix'),
(5, 'Telix'),
(6, 'Telota'),
(7, 'Luna'),
(8, 'Estrella');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproductos`
--

CREATE TABLE IF NOT EXISTS `tblproductos` (
  `CodProducto` varchar(25) NOT NULL,
  `NombreProducto` varchar(45) DEFAULT NULL,
  `PrecioUProducto` decimal(10,0) DEFAULT NULL,
  `PrecioMproducto` decimal(10,0) DEFAULT NULL,
  `Existencias` int(11) DEFAULT NULL,
  `Estado` tinyint(1) NOT NULL,
  `DescripcionProducto` varchar(45) DEFAULT NULL,
  `idtblMarca` int(11) NOT NULL,
  PRIMARY KEY (`CodProducto`),
  KEY `fk_tblProductos_tblMarca1_idx` (`idtblMarca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tblproductos`
--

INSERT INTO `tblproductos` (`CodProducto`, `NombreProducto`, `PrecioUProducto`, `PrecioMproducto`, `Existencias`, `Estado`, `DescripcionProducto`, `idtblMarca`) VALUES
('0001D', 'Dacron', '5', '3', 100, 1, '', 3),
('0003', 'Lino', '3', '1', 50, 1, 'tela Lino', 6),
('F1', 'nom', '10', '10', 10, 1, 'null', 5),
('j', 'h', '5', '5', 5, 0, 'lllloo', 6),
('Rt', 'NuevaG', '5', '5', 45, 0, 'ñll', 6),
('T0', 'Pana', '14', '13', 1, 0, 'Solo en Color Azul Nacional', 7),
('T100', 'LinoFino', '100', '60', 10, 0, 'Lino Fino en Colores Varios', 4),
('T101145', 'Felpa', '1', '1', 10, 0, 'Tela en Felpa multiples Colores', 4),
('T104', 'Algodon', '15', '10', 150, 0, 'Tela de Algodon ', 3),
('T114', 'Lona', '31', '30', 2, 0, 'Tela en Lona', 8),
('T5000', 'Estampado', '10', '5', 10, 0, 'Estampado Militar en Colores Primarios', 6),
('TY10', 'Cielo', '1', '1', 10, 0, 'Azul Cielo', 5),
('value-1', 'value-2', '3', '4', 5, 0, '[value-7]', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproductos_has_tblfactura`
--

CREATE TABLE IF NOT EXISTS `tblproductos_has_tblfactura` (
  `tblProductos_CodProducto` varchar(25) NOT NULL,
  `tblFactura_idFactura` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_tblProductos_has_tblFactura_tblFactura1_idx` (`tblFactura_idFactura`),
  KEY `fk_tblProductos_has_tblFactura_tblProductos_idx` (`tblProductos_CodProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
