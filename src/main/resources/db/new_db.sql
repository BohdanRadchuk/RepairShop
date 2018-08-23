-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema watch_repair
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema watch_repair
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `watch_repair` DEFAULT CHARACTER SET utf8 ;
USE `watch_repair` ;

-- -----------------------------------------------------
-- Table `watch_repair`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `watch_repair`.`user` (
  `id_user` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `surname` VARCHAR(64) NOT NULL,
  `email` VARCHAR(64) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `role` ENUM('USER', 'MANAGER', 'MASTER', 'ADMIN') NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `email` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `watch_repair`.`service`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `watch_repair`.`service` (
  `id_service` INT(11) NOT NULL AUTO_INCREMENT,
  `type_en` VARCHAR(256) NOT NULL,
  `type_ua` VARCHAR(256) NOT NULL,
  `price` DECIMAL NOT NULL,
  PRIMARY KEY (`id_service`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `watch_repair`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `watch_repair`.`order` (
  `id_order` INT(11) NOT NULL,
  `id_user` INT(11) NOT NULL,
  `id_service` INT(11) NOT NULL,
  `status` ENUM('UNCHECKED', 'REJECTED', 'CONFIRMED', 'IN_WORK', 'DONE') NULL DEFAULT NULL,
  `price` DECIMAL NULL DEFAULT NULL,
  `id_manager` INT(11) NULL DEFAULT NULL,
  `consideration_date` DATETIME NULL DEFAULT NULL,
  `id_master` INT(11) NULL DEFAULT NULL,
  `in_work_date` DATETIME NULL DEFAULT NULL,
  `done_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  INDEX `id_user` (`id_user` ASC),
  INDEX `id_manager` (`id_manager` ASC),
  INDEX `id_master` (`id_master` ASC),
  INDEX `id_service` (`id_service` ASC),
  CONSTRAINT `request_ibfk_1`
    FOREIGN KEY (`id_user`)
    REFERENCES `watch_repair`.`user` (`id_user`)
    ON UPDATE CASCADE,
  CONSTRAINT `request_ibfk_2`
    FOREIGN KEY (`id_manager`)
    REFERENCES `watch_repair`.`user` (`id_user`)
    ON UPDATE CASCADE,
  CONSTRAINT `request_ibfk_3`
    FOREIGN KEY (`id_master`)
    REFERENCES `watch_repair`.`user` (`id_user`)
    ON UPDATE CASCADE,
  CONSTRAINT `request_ibfk_4`
    FOREIGN KEY (`id_service`)
    REFERENCES `watch_repair`.`service` (`id_service`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `watch_repair`.`order_archive`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `watch_repair`.`order_archive` (
  `id_order` INT(11) NOT NULL,
  `id_user` INT(11) NOT NULL,
  `id_service` INT(11) NOT NULL,
  `status` ENUM('REJECTED', 'DONE') NOT NULL,
  `price` DECIMAL NULL,
  `id_employee` INT(11) NOT NULL,
  `done_date` DATETIME NOT NULL,
  `comentary` VARCHAR(1000) NULL,
  PRIMARY KEY (`id_order`),
  INDEX `id_user` (`id_user` ASC),
  INDEX `id_manager` (`id_employee` ASC),
  INDEX `id_service` (`id_service` ASC),
  CONSTRAINT `request_ibfk_10`
    FOREIGN KEY (`id_user`)
    REFERENCES `watch_repair`.`user` (`id_user`)
    ON UPDATE CASCADE,
  CONSTRAINT `request_ibfk_20`
    FOREIGN KEY (`id_employee`)
    REFERENCES `watch_repair`.`user` (`id_user`)
    ON UPDATE CASCADE,
  CONSTRAINT `request_ibfk_40`
    FOREIGN KEY (`id_service`)
    REFERENCES `watch_repair`.`service` (`id_service`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
