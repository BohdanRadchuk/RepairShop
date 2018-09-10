# RepairShop
Система Ремонтное Агенство. Пользователь может создать заявку на
ремонт изделия. Менеджер может принять заявку указав цену, либо
отклонить заявку, указав причину. Мастер может выполнить принятую
Менеджером заявку. Пользователь может оставить Отзыв о выполненных
работах.


#Init DB
1) Run resources\db\create_watch_repair_db.sql
2) Add default values recorded in resources\db\dbinit.sql 


| role    |         email        | password |
|---------|:--------------------:|----------|
| Admin   | Jchen@example.com    | Asd123   |
| Master  | Rbenna@example.com   | Rewq12   |
| Manager | Lcorrado@example.com | Qasw21   |
| Manager | MHooley@example.com  | Zaq123   |
| User    | MKarf@example.com    | Karf21   |
| User    | APerry@example.com   | Asdqw2   |
