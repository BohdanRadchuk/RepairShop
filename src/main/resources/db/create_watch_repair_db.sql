CREATE SCHEMA IF NOT EXISTS `watch_repair` DEFAULT CHARACTER SET utf8 ;
USE `watch_repair` ;

CREATE TABLE IF NOT EXISTS `watch_repair`.`user` (
  `id_user` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `surname` VARCHAR(64) NOT NULL,
  `email` VARCHAR(64) NOT NULL UNIQUE,
  `password` VARCHAR(64) NOT NULL,
  `role` ENUM('USER', 'MANAGER', 'MASTER', 'ADMIN') NOT NULL,
  PRIMARY KEY (`id_user`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `watch_repair`.`service` (
  `id_service` INT(11) NOT NULL AUTO_INCREMENT,
  `type_en` VARCHAR(256) NOT NULL,
  `type_ua` VARCHAR(256) NOT NULL,
  `description_en` VARCHAR(2000) NOT NULL,
  `description_ua` VARCHAR(2000) NOT NULL,
  `price` DECIMAL NOT NULL,
  PRIMARY KEY (`id_service`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `watch_repair`.`order` (
  `id_order` INT(11) NOT NULL AUTO_INCREMENT,
  `id_user` INT(11) NOT NULL,
  `id_service` INT(11) NOT NULL,
  `status` ENUM('NEW', 'REFUSE', 'CONFIRM', 'IN_WORK', 'DONE') NOT NULL,
  `price` DECIMAL NULL DEFAULT NULL,
  `id_manager` INT(11) NULL DEFAULT NULL,
  `consideration_date` DATETIME NULL DEFAULT NULL,
  `refuse_reason` VARCHAR(256) NULL DEFAULT NULL,
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

CREATE TABLE IF NOT EXISTS `watch_repair`.`comment` (
  `id_order` INT(11) NOT NULL,
  `commentary` VARCHAR(2500) NOT NULL,
  PRIMARY KEY (`id_order`),
  CONSTRAINT `fk_comment_order1`
  FOREIGN KEY (`id_order`)
  REFERENCES `watch_repair`.`order` (`id_order`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `watch_repair`.`order_archive` (
  `id_archive_order` INT(11) NOT NULL,
  `id_user` INT(11) NOT NULL,
  `id_service` INT(11) NOT NULL,
  `status` ENUM('REFUSE', 'DONE') NOT NULL,
  `price` DECIMAL,
  `id_worker` INT(11) NOT NULL,
  `done_date` DATETIME NOT NULL,
  PRIMARY KEY (`id_archive_order`),
  INDEX `id_user` (`id_user` ASC),
  INDEX `id_manager` (`id_worker` ASC),
  INDEX `id_service` (`id_service` ASC),
  CONSTRAINT `request_ibfk_10`
  FOREIGN KEY (`id_user`)
  REFERENCES `watch_repair`.`user` (`id_user`)
    ON UPDATE CASCADE,
  CONSTRAINT `request_ibfk_20`
  FOREIGN KEY (`id_worker`)
  REFERENCES `watch_repair`.`user` (`id_user`)
    ON UPDATE CASCADE,
  CONSTRAINT `request_ibfk_40`
  FOREIGN KEY (`id_service`)
  REFERENCES `watch_repair`.`service` (`id_service`)
    ON UPDATE CASCADE)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;
