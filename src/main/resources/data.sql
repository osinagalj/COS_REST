INSERT INTO herd(location) VALUES('primer herd');
INSERT INTO herd(location) VALUES('segundo herd');
INSERT INTO herd(location) VALUES('tercer herd');
INSERT INTO herd(location) VALUES('cuarto herd');

INSERT INTO cow(herd_id,eletronic_id,born_date,last_due_date,deliveries,weigth) VALUES(1,1,'2019-11-07','2021-03-27',1,70);
INSERT INTO cow(herd_id,eletronic_id,born_date,last_due_date,deliveries,weigth) VALUES(1,2,'2019-11-07','2021-03-27',1,70);

INSERT INTO cow(herd_id,eletronic_id,born_date,last_due_date,deliveries,weigth) VALUES(2,3,'2019-11-07','2021-03-27',1,70);
INSERT INTO cow(herd_id,eletronic_id,born_date,last_due_date,deliveries,weigth) VALUES(2,4,'2019-11-07','2021-03-27',1,70);
INSERT INTO cow(herd_id,eletronic_id,born_date,last_due_date,deliveries,weigth) VALUES(2,5,'2019-11-07','2021-03-27',1,70);

INSERT INTO cow_bcs(cow_id,date,cc) VALUES(1,'2016-07-06',1);
INSERT INTO cow_bcs(cow_id,date,cc) VALUES(1,'2015-10-12',2);
INSERT INTO cow_bcs(cow_id,date,cc) VALUES(1,'2021-03-27',3);
INSERT INTO cow_bcs(cow_id,date,cc) VALUES(1,'2017-08-03',4);
INSERT INTO cow_bcs(cow_id,date,cc) VALUES(2,'2020-10-15',4);

insert into cow_alert(cow_id,bcs_threshold_min,bcs_threshold_max) values(1,3,8);
insert into cow_alert(cow_id,bcs_threshold_min,bcs_threshold_max) values(2,4,7);

insert into herd_alert(herd_id,bcs_threshold_min,bcs_threshold_max) values(1,4,6);

COMMIT;