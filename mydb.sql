-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `iduser` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`aerolinea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`aerolinea` (
  `idaerolinea` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `codigo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idaerolinea`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`vuelo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vuelo` (
  `idvuelo` INT NOT NULL,
  `origen` VARCHAR(45) NOT NULL,
  `destino` VARCHAR(45) NOT NULL,
  `fecha_salida` DATETIME NOT NULL,
  `fecha_llegada` DATETIME NOT NULL,
  `duracion` INT NOT NULL,
  `precio` DECIMAL NOT NULL,
  `asientos_disponibles` INT NOT NULL,
  `descripcion` VARCHAR(500) NOT NULL,
  `aerolinea_idaerolinea` INT NOT NULL,
  PRIMARY KEY (`idvuelo`),
  INDEX `fk_vuelo_aerolinea1_idx` (`aerolinea_idaerolinea` ASC) VISIBLE,
  CONSTRAINT `fk_vuelo_aerolinea1`
    FOREIGN KEY (`aerolinea_idaerolinea`)
    REFERENCES `mydb`.`aerolinea` (`idaerolinea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reserva` (
  `idreserva` INT NOT NULL,
  `fecha_reserva` DATETIME NOT NULL,
  `precio_total` DECIMAL NOT NULL,
  `estado_pago` VARCHAR(45) NOT NULL,
  `user_iduser` INT NOT NULL,
  `vuelo_idvuelo` INT NOT NULL,
  PRIMARY KEY (`idreserva`),
  INDEX `fk_reserva_user_idx` (`user_iduser` ASC) VISIBLE,
  INDEX `fk_reserva_vuelo1_idx` (`vuelo_idvuelo` ASC) VISIBLE,
  CONSTRAINT `fk_reserva_user`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_vuelo1`
    FOREIGN KEY (`vuelo_idvuelo`)
    REFERENCES `mydb`.`vuelo` (`idvuelo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
