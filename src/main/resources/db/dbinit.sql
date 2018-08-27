INSERT INTO `user` (`name`, `surname`, `email`, `password`, `role`)
VALUES ('Reinaldos', 'Benna', 'Rbenna@example.com', 'rb123', 'MASTER'),
  ('Leontine', 'Corrado', 'Lcorrado@example.com', 'pass223', 'MANAGER'),
  ('Marcelo', 'Hooley', 'MHooley@example.com', '1', 'USER'),
  ('Mildrid', 'Karf', 'MKarf@example.com', 'MILLpass1', 'MANAGER'),
  ('1','1','1@example.com','1','USER');

INSERT INTO `service` (`type_en`, `type_ua`, `description_en`, `description_ua`, `price`)
VALUES ('Battery replacement', 'Заміна батарейки','Selection and replacement of batteries for different categories and types of watches', 'Підбір та заміна елементів живлення для різних категорій і типів годинників', 30),
  ('Bands and straps repair', 'Ремонт ремінців', 'Metal, leather, fabric and other straps repair and replacement', 'Ремонт та заміна металевих, шкіряних, тканинних і інших ремінців',  45);

INSERT INTO watch_repair.order (id_user, id_service, status, price, id_manager, consideration_date, id_master, in_work_date, done_date)
VALUES (5, 2, 'DONE', 60, 2,'2018-08-22 10:12:13', 1, '2018-08-24 09:15:22', '2018-08-24 11:30:22');

INSERT INTO watch_repair.order (id_user, id_service, status, price, id_manager, consideration_date, id_master, in_work_date, done_date)
VALUES (5, 1, 'DONE', 55, 4,'2018-08-23 14:24:11', 1, '2018-08-25 10:45:52', '2018-08-26 17:54:31');

INSERT INTO watch_repair.order (id_user, id_service, status, price, id_manager, consideration_date, id_master, in_work_date)
VALUES (5, 1, 'IN_WORK', 45, 2,'2018-08-24 10:12:13', 1, '2018-08-26 11:44:13');

INSERT INTO watch_repair.order (id_user, id_service, status, price, id_manager, consideration_date)
VALUES (5, 2, 'CONFIRM', 60, 2,'2018-08-25 13:17:17');

INSERT INTO watch_repair.order (id_user, id_service, status, id_manager, consideration_date, refuse_reason)
VALUES (3, 1, 'REFUSE', 4, '2018-08-25 15:33:21', 'all masters are busy at the moment');

INSERT INTO watch_repair.order (id_user, id_service, status)
VALUES (3, 1, 'NEW');

INSERT INTO `watch_repair`.`comment` (`id_order`, `commentary`) VALUES (1, 'good work');
