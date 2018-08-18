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

CREATE TABLE `request`(
`id_request` INT NOT NULL AUTO_INCREMENT,
`id_service` INT NOT NULL,
`price` DECIMAL,
FOREIGN KEY (`id_service`) REFERENCES `service`(`id_service`) ON DELETE RESTRICT ON UPDATE CASCADE,
PRIMARY KEY (`id_request`)
);

CREATE TABLE `status`(
`id_status` INT NOT NULL AUTO_INCREMENT,
`status` ENUM ('UNCHECKED', 'REJECTED', 'CONFIRMED', 'IN_WORK', 'DONE') NOT NULL,
`date` DATETIME NOT NULL,
`id_request` INT NOT NULL,
`id_user` INT NOT NULL,
FOREIGN KEY (`id_request`) REFERENCES `request`(`id_request`) ON DELETE RESTRICT ON UPDATE CASCADE,
FOREIGN KEY (`id_user`) REFERENCES `user`(`id_user`) ON DELETE RESTRICT ON UPDATE CASCADE,
PRIMARY KEY (`id_status`)
);

CREATE TABLE `comment`(
`id_comment` INT NOT NULL AUTO_INCREMENT,
`id_user` INT NOT NULL,
`commentary` VARCHAR (1000),
FOREIGN KEY (`id_user`) REFERENCES `user`(`id_user`) ON DELETE RESTRICT ON UPDATE CASCADE,
PRIMARY KEY (`id_comment`)
);

CREATE TABLE `comment_request`(
`id_comment` INT,
`id_request` INT,
FOREIGN KEY (`id_comment`) REFERENCES `comment`(`id_comment`) ON DELETE RESTRICT ON UPDATE CASCADE,
FOREIGN KEY (`id_request`) REFERENCES `request` (`id_request`) ON DELETE RESTRICT ON UPDATE CASCADE,
PRIMARY KEY (`id_comment`, `id_request`)
);

