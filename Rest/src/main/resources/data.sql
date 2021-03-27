INSERT INTO herd(location) VALUES('disney');
INSERT INTO herd(location) VALUES('messilandia');
INSERT INTO herd(location) VALUES('maiamiii');

INSERT INTO cow(herd_id,eletronic_id,born_date,last_due_date,deliveries,weigth) VALUES(1,1,'2019-11-07','2019-11-07',1,70);
INSERT INTO cow(herd_id,eletronic_id,born_date,last_due_date,deliveries,weigth) VALUES(1,2,'2019-11-07','2019-11-07',1,70);
INSERT INTO cow(herd_id,eletronic_id,born_date,last_due_date,deliveries,weigth) VALUES(2,3,'2019-11-07','2019-11-07',1,70);
INSERT INTO cow(herd_id,eletronic_id,born_date,last_due_date,deliveries,weigth) VALUES(2,4,'2019-11-07','2019-11-07',1,70);
INSERT INTO cow(herd_id,eletronic_id,born_date,last_due_date,deliveries,weigth) VALUES(2,5,'2019-11-07','2019-11-07',1,70);

insert into cow_alert(cow_id,bcs_threshold_min,bcs_threshold_max) values(1,3,8);
insert into cow_alert(cow_id,bcs_threshold_min,bcs_threshold_max) values(2,4,7);

COMMIT;