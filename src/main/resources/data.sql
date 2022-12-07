ALTER TABLE TRANSACTION ADD FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID);


Insert into CUSTOMER values(1,'Hari');
Insert into CUSTOMER values(2,'Ram');
Insert into CUSTOMER values(3,'Krishna');
Insert into CUSTOMER values(4,'Narayan');
Insert into CUSTOMER values(5,'Shyam');
Insert into CUSTOMER values(6,'Gopal');
Insert into CUSTOMER values(7,'Radhe');

Insert into Transaction values(2001,1,50,'2018-09-01');
Insert into Transaction values(2002,1,10,'2019-03-02');
Insert into Transaction values(2003,1,150,'2020-01-03');
Insert into Transaction values(2004,1,150,'2021-02-04');
Insert into Transaction values(2005,1,50,'2022-04-05');
Insert into Transaction values(2006,2,120,'2022-10-09');
Insert into Transaction values(2007,2,110,'2022-11-10');
Insert into Transaction values(2008,2,140,'2022-10-08');
Insert into Transaction values(2009,2,120,'2022-11-21');
Insert into Transaction values(2010,2,120,'2022-12-20');
Insert into Transaction values(2014,6,200,'2019-05-20');
Insert into Transaction values(2015,7,100,'2016-06-19');
Insert into Transaction values(2011,3,55,'2021-03-30');
Insert into Transaction values(2012,4,105,'2021-03-29');
Insert into Transaction values(2013,5,35,'2021-04-19');