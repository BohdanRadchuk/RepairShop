INSERT INTO `user` (`name`, `surname`, `email`, `password`, `role`)
VALUES ('Reinaldos', 'Benna', 'Rbenna@example.com', 'rb123', 'USER'),
  ('Leontine', 'Corrado', 'Lcorrado@example.com', 'pass223', 'MANAGER'),
  ('Marcelo', 'Hooley', 'MHooley@example.com', '1', 'USER'),
  ('Mildrid', 'Karf', 'MKarf@example.com', 'MILLpass1', 'MANAGER'),
  ('1','1','1@example.com','1','USER');

INSERT INTO `service` (`type_en`, `type_ua`, `description_en`, `description_ua`, `price`)
VALUES ('Battery replacement', 'Заміна батарейки','Selection and replacement of batteries for different categories and types of watches', 'Підбір та заміна елементів живлення для різних категорій і типів годинників', 30),
  ('Bands and straps repair', 'Ремонт ремінців', 'Metal, leather, fabric and other straps repair and replacement', 'Ремонт та заміна металевих, шкіряних, тканинних і інших ремінців',  45);