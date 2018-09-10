INSERT INTO `user` (`name`, `surname`, `email`, `password`, `role`)
VALUES ('Jez', 'Chen', 'Jchen@example.com', '$2a$10$/M.JuSabAE4oyRtH0dW67u6gECcePJfSbmOODaF5EVpgN7HgucnPC', 'ADMIN'),
  ('Reinaldos', 'Benna', 'Rbenna@example.com', '$2a$10$djT4vsba//A29kWZkadRnO1ulMVS2CjBU8Au7RcG.9UNIgKapOBLa', 'MASTER'),
  ('Leontine', 'Corrado', 'Lcorrado@example.com', '$2a$10$qMgxmsudJ./D9le67y154eYoWCUhpiQsPxz/MDpyUG.yQje6adNy2', 'MANAGER'),
  ('Marcelo', 'Hooley', 'MHooley@example.com', '$2a$10$kMJfE/iftgszVQnt5jWGhOQU7TSU0JYYUOJQ7MANI7PCZrnleIio6', 'MANAGER'),
  ('Mildrid', 'Karf', 'MKarf@example.com', '$2a$10$WkF.fojEoNiSAxlriZJw0eouHJWfMbqXvHACz7UVnGoergeWX2FkW', 'USER'),
  ('Asher','Perry','APerry@example.com','$2a$10$2irQcVs4mi0AX.NP0BPwVeAfwZn/t0Pctm/.h4Z2I5ymO0CyqGUUu','USER');

INSERT INTO `service` (`type_en`, `type_ua`, `description_en`, `description_ua`, `price`)
VALUES ('Preventive clockwork diagnostics and shell cleaning', 'Профілактична діагностика механізму і чищення корпусу',
        'A high-quality watch can serve for centuries, transmitted from generation to generation, and become a true family relic. In order for your watch to work perfectly,
        we recommend to carry out preventive clockwork diagnostics and shell cleaning at least once per every 3 years. Such a precautionary measure will help to detect and
        prevent the beginning corrosion in the mechanism or to eliminate the possible causes of its occurrence. Our watchmakers will carefully disassemble the clockwork
        and clear all the smallest details externally and internally and if replace them if necessary.',
        'Якісний годинник може служити століттями, передаючись із покоління в покоління, і стати справжньою сімейною реліквією. Аби ваш наручний годинник завжди працював
        бездоганно, рекомендується проводити профілактичну діагностику механізму і чищення корпусу хоча би раз на 3 роки. Такий запобіжний захід допоможе виявити і вчасно
        попередити появу корозії в механізмі або усунути можливі причини її виникнення. Наші майстри дбайливо розберуть годинниковий механізм і очистять усі найдрібніші
        деталі зовні і всередині, а при необхідності - підберуть їм заміну.', 30),
  ('Battery replacement', 'Заміна елементів живлення',
   'In our workshop, you can quickly replace watch batteries of any kind. Leave a request on our website, bring your watch at the agreed time, and our watchmakers will
   make an instant replacement right on the spot. You won\'t have to wait for a long time, and the work will be done with the utmost care. We have a huge variety of
   batteries of different price categories, suitable for any electronic watch. Therefore, you will be able to choose the very battery that suits you.',
   'У нас в майстерні ви можете швидко замінити годинникові батарейки будь-якого типу. Залишайте   замовлення на нашому сайті, приносьте свій годинник в обумовлений час,
   і майстер зробить миттєву заміну прямо на місці. Вам не доведеться довго чекати, а робота буде   виконана з максимальною акуратністю. У нас в наявності є елементи
   живлення різного обєму та різних цінових категорій, які підходять до будь-яких електронних годинників. Тому ви самі зможете вибрати саме ту батарейку, яка вам підійде.',  45),
  ('Watch crystal replacement and polishing', 'Заміна та шліфування годинникового скла',
   'Our workshop provides a wide range of watch crystals of different durability and of various price categories. We can restore the water tightness of the waterproof
   watch, remove small chips, scratches, paint marks and other damages to the crystals. Modern ultrasonic cleaning and polishing will make the crystal perfectly smooth
   and transparent, and the additional protective spraying will help to protect the watch from daily friction and other minor mechanical impact for a long time.',
   'Наша майстерня надає широкий вибір годинникового скла різної міцності і різних цінових   категорій. У нас також можна відновити герметичність водонепроникних
   годинників, видалити дрібні відколи, подряпини, сліди фарби та інші пошкодження на склі. Сучасне ультразвукове чищення та полірування зроблять скло ідеально гладким
   і прозорим, а додаткове захисне напилення допоможе надовго захистити годинник від щоденного тертя та інших дрібних механічних впливів.', 60),
  ('Watchband and strap replacement and repair', 'Ремонт, подовження, вкорочення та заміна ремінців',
   'With us, you can restore your old watch strap or choose a worthy replacement of any material: metal, leather, fabric, rubber or caoutchouc. In our workshop you
   will find a wide selection of men\'s and women\'s straps of different length and width. If the strap does not suit you, our watchmakers will be able to measure
   your wrist and change the length of the strap in the right direction: to lengthen it or to shorten it.',
   'У нас ви можете реставрувати старий годинниковий ремінець або підібрати йому гідну заміну із будь-якого матеріалу: металу, шкіри, тканини, гуми або каучуку.
   У нашій майстерні ви знайдете великий вибір чоловічих та жіночих ремінців різної довжини і ширини. Якщо ремінець вам не підходить, наш майстер зможе заміряти
   ваше зап’ястя і змінити довжину ремінця в потрібну сторону: подовжити або вкоротити.',  25),
  ('Clockwork replacement and calibration', 'Заміна та налаштування механізму',
   'The clockwork is the most important part of any watch. We provide our customers the best clockwork repair services of various complexities. We can fix both
   the old and the new clockworks. If necessary, our watchmakers will be able to replace the broken or missing parts. In case of impossibility of repair or lack of
   necessary parts, the watchmakers will assemble your faulty watch for free.',
   'Годинниковий механізм - це найважливіша частина будь-якого годинника. Ми надаємо нашим клієнтам послуги з ремонту механізмів різного ступеня складності для
   годинників будь-якого року випуску. При необхідності майстер зможе замінити деталь, котра вийшла з ладу, аналогічною новою. У разі неможливості ремонту годинника
   або відсутності необхідних деталей, майстер зробить збірку несправного годинника безкоштовно.', 130),
  ('Dial and hands restoration and replacement', 'Реставрація циферблату та стрілок',
   'Here you can place an order for repair or replacement of hour, minute and second hands, as well as numbers and divisions on the dial. We also accept orders for
   painting, polishing and updating old dials of different complexity.',
   'У нас ви можете оформити замовлення на лагодження або заміну годинної, хвилинної і секундної стрілок, а також цифр і поділів на циферблаті. Окрім того, ми
   приймаємо замовлення на фарбування, полірування і оновлення старих годинникових циферблатів різних моделей.',  145),
  ('Shell engraving', 'Гравіювання корпусу',
   'A beautiful laser shell engraving will make your wristwatch to be an exclusive memorable gift. According to your personal order, the watchmakers will engrave
   the initials, names or any other inscriptions on the back of the watch. Anyone, who places a wholesale order of 5 or more engravings, will get a 10% discount.',
   'Зробити з наручного годинника пам’ятний подарунок допоможе красиве лазерне гравіювання на корпусі. За вашим індивідуальним замовленням майстер вигравіює на
   зворотному боці годинника ініціали, імена або будь-які інші написи. При оптовому замовленні гравіювань від 5 одиниць діє знижка 10%.', 50);

INSERT INTO watch_repair.order (id_user, id_service, status, price, id_manager, consideration_date, id_master, in_work_date, done_date)
VALUES (6, 2, 'DONE', 60, 3,'2018-08-22 10:12:13', 2, '2018-08-24 09:15:22', '2018-08-24 11:30:22');

INSERT INTO watch_repair.order (id_user, id_service, status, price, id_manager, consideration_date, id_master, in_work_date, done_date)
VALUES (6, 1, 'DONE', 55, 4,'2018-08-23 14:24:11', 2, '2018-08-25 10:45:52', '2018-08-26 17:54:31');

INSERT INTO watch_repair.order (id_user, id_service, status, price, id_manager, consideration_date, id_master, in_work_date)
VALUES (6, 1, 'IN_WORK', 45, 3,'2018-08-24 10:12:13', 2, '2018-08-26 11:44:13');

INSERT INTO watch_repair.order (id_user, id_service, status, price, id_manager, consideration_date)
VALUES (5, 2, 'CONFIRM', 60, 3,'2018-08-25 13:17:17');

INSERT INTO watch_repair.order (id_user, id_service, status, id_manager, consideration_date, refuse_reason)
VALUES (6, 1, 'REFUSE', 4, '2018-08-25 15:33:21', 'all masters are busy at the moment');

INSERT INTO watch_repair.order (id_user, id_service, status)
VALUES (5, 1, 'NEW');

INSERT INTO `watch_repair`.`comment` (`id_order`, `commentary`) VALUES (1, 'good work');
