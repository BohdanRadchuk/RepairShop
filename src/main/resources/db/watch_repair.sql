CREATE DATABASE IF NOT EXISTS watch_repair
  CHARACTER SET utf8
  COLLATE utf8_general_ci;

USE watch_repair;

CREATE TABLE `user` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(64) NOT NULL,
  `surname` VARCHAR(64) NOT NULL,
  `email` VARCHAR(64) UNIQUE NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `role` ENUM('USER','MANAGER','MASTER','ADMIN') NOT NULL,
  PRIMARY KEY (`id_user`)
);

CREATE TABLE `service`(
  `id_service` INT NOT NULL AUTO_INCREMENT,
  `type_en` VARCHAR(256) NOT NULL,
  `type_ua` varchar(256) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`id_service`)
);

CREATE TABLE `request`(
  `id_request` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `id_service` INT NOT NULL,
  `status` ENUM ('UNCHECKED', 'REJECTED', 'CONFIRMED', 'IN_WORK', 'DONE'),
  `price` INT,
  `id_manager` INT,
  `consideration_date` DATETIME,
  `id_master` INT,
  `in_work_date` DATETIME,
  `done_date` DATETIME,
  CONSTRAINT FOREIGN KEY (`id_user`) REFERENCES `user`(`id_user`) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (`id_manager`) REFERENCES `user`(`id_user`) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (`id_master`) REFERENCES `user`(`id_user`) ON DELETE RESTRICT ON UPDATE CASCADE,
  FOREIGN KEY (`id_service`) REFERENCES `service`(`id_service`) ON DELETE RESTRICT ON UPDATE CASCADE,
  PRIMARY KEY (`id_request`)
);

CREATE TABLE `comment`(
  `commentary` VARCHAR (1000) NOT NULL,
  `id_request` INT NOT NULL,
  CONSTRAINT FOREIGN KEY (`id_request`) REFERENCES `request` (`id_request`) ON DELETE RESTRICT ON UPDATE CASCADE,
  PRIMARY KEY (`id_request`)
);


