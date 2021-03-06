-- MySQL Script generated by MySQL Workbench
-- Mon Oct  6 23:37:13 2014
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema DBventasGuadalupe
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `DBventasGuadalupe` ;
CREATE SCHEMA IF NOT EXISTS `DBventasGuadalupe` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `DBventasGuadalupe` ;

-- -----------------------------------------------------
-- Table `DBventasGuadalupe`.`tblMarca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DBventasGuadalupe`.`tblMarca` ;

CREATE TABLE IF NOT EXISTS `DBventasGuadalupe`.`tblMarca` (
  `idtblMarca` INT NOT NULL AUTO_INCREMENT,
  `NombreMarca` VARCHAR(45) NULL,
  PRIMARY KEY (`idtblMarca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBventasGuadalupe`.`tblProductos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DBventasGuadalupe`.`tblProductos` ;

CREATE TABLE IF NOT EXISTS `DBventasGuadalupe`.`tblProductos` (
  `CodProducto` VARCHAR(25) NOT NULL,
  `NombreProducto` VARCHAR(45) NULL,
  `PrecioUProducto` DECIMAL(10,2) NULL,
  `PrecioMproducto` DECIMAL(10,2) NULL,
  `Existencias` INT NULL,
  `Estado` TINYINT(1) NOT NULL,
  `DescripcionProducto` VARCHAR(45) NULL,
  `idtblMarca` INT(11) NOT NULL,
  PRIMARY KEY (`CodProducto`),
  INDEX `fk_tblProductos_tblMarca1_idx` (`idtblMarca` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBventasGuadalupe`.`tblClientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DBventasGuadalupe`.`tblClientes` ;

CREATE TABLE IF NOT EXISTS `DBventasGuadalupe`.`tblClientes` (
  `codCliente` VARCHAR(25) NOT NULL,
  `NombreCliente` VARCHAR(45) NULL,
  `ApellidoCliente` VARCHAR(45) NULL,
  `TelefonoCliente` VARCHAR(45) NULL,
  `DireccionCliente` VARCHAR(45) NULL,
  `EstadoCliente` TINYINT(1) NULL,
  PRIMARY KEY (`codCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBventasGuadalupe`.`tblFactura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DBventasGuadalupe`.`tblFactura` ;

CREATE TABLE IF NOT EXISTS `DBventasGuadalupe`.`tblFactura` (
  `idFactura` INT NOT NULL AUTO_INCREMENT,
  `FechaFactura` DATETIME NULL,
  `Total` FLOAT NULL,
  `tblClientes_codCliente` VARCHAR(25) NOT NULL,
  `ImprimirFactura` TINYINT(1) NULL,
  `PagoFactura` FLOAT NULL,
  `CambioFactura` FLOAT NULL,
  `Activa` TINYINT(1) NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_tblFactura_tblClientes1_idx` (`tblClientes_codCliente` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBventasGuadalupe`.`tblProductos_has_tblFactura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DBventasGuadalupe`.`tblProductos_has_tblFactura` ;

CREATE TABLE IF NOT EXISTS `DBventasGuadalupe`.`tblProductos_has_tblFactura` (
  `tblProductos_CodProducto` VARCHAR(25) NOT NULL,
  `tblFactura_idFactura` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `Precio` FLOAT NULL,
  `Cantidad` INT NULL,
  `Subtotal` FLOAT NULL,
  INDEX `fk_tblProductos_has_tblFactura_tblFactura1_idx` (`tblFactura_idFactura` ASC),
  INDEX `fk_tblProductos_has_tblFactura_tblProductos_idx` (`tblProductos_CodProducto` ASC),
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBventasGuadalupe`.`ProductosModificados`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DBventasGuadalupe`.`ProductosModificados` ;

CREATE TABLE IF NOT EXISTS `DBventasGuadalupe`.`ProductosModificados` (
  `idProductosModificados` INT NOT NULL AUTO_INCREMENT,
  `tblProductos_CodProducto` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`idProductosModificados`),
  INDEX `fk_ProductosModificados_tblProductos1_idx` (`tblProductos_CodProducto` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DBventasGuadalupe`.`Usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `DBventasGuadalupe`.`Usuarios` ;

CREATE TABLE IF NOT EXISTS `DBventasGuadalupe`.`Usuarios` (
  `idUsuarios` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`idUsuarios`))
ENGINE = InnoDB;

USE `DBventasGuadalupe` ;

-- -----------------------------------------------------
-- procedure numCliente
-- -----------------------------------------------------

USE `DBventasGuadalupe`;
DROP procedure IF EXISTS `DBventasGuadalupe`.`numCliente`;

DELIMITER $$
USE `DBventasGuadalupe`$$
CREATE PROCEDURE numCliente(OUT param1 INT)
BEGIN
SELECT COUNT(*) INTO param1 FROM tblclientes;
END 
$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure total
-- -----------------------------------------------------

USE `DBventasGuadalupe`;
DROP procedure IF EXISTS `DBventasGuadalupe`.`total`;

DELIMITER $$
USE `DBventasGuadalupe`$$
CREATE PROCEDURE total(OUT param1 INT)
BEGIN
SELECT COUNT(*) INTO param1 FROM tblproductos;
END $$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
