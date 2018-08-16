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
`type` VARCHAR(256) NOT NULL,
`price` INT,
PRIMARY KEY (`id_service`)
);

CREATE TABLE `warehouse`(
`id_detail` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(128) NOT NULL,
`quantity` INT NOT NULL,
PRIMARY KEY (`id_detail`)
);

CREATE TABLE `contract`(
`id_contract` INT NOT NULL AUTO_INCREMENT,
`id_user` INT NOT NULL,
`status` ENUM ('UNCHECKED', 'REJECTED', 'CONFIRMED', 'IN_WORK', 'DONE'),
`id_service` INT NOT NULL,
`price` INT,
`id_manager` INT,
`id_master` INT,
`comment` VARCHAR (1000),
FOREIGN KEY (`id_user`) REFERENCES `user`(`id_user`) ON DELETE RESTRICT ON UPDATE CASCADE,
FOREIGN KEY (`id_manager`) REFERENCES `user`(`id_user`) ON DELETE RESTRICT ON UPDATE CASCADE,
FOREIGN KEY (`id_master`) REFERENCES `user`(`id_user`) ON DELETE RESTRICT ON UPDATE CASCADE,
FOREIGN KEY (`id_service`) REFERENCES `service`(`id_service`) ON DELETE RESTRICT ON UPDATE CASCADE,
PRIMARY KEY (`id_contract`)
);

CREATE TABLE `service_contract`(
`id_service` INT,
`id_contract` INT,
FOREIGN KEY (`id_service`) REFERENCES `service`(`id_service`) ON DELETE RESTRICT ON UPDATE CASCADE,
FOREIGN KEY (`id_contract`) REFERENCES `contract` (`id_contract`) ON DELETE RESTRICT ON UPDATE CASCADE,
PRIMARY KEY (`id_service`, `id_contract`)
);
