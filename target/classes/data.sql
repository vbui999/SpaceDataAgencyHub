DROP TABLE "MISSION";
CREATE TABLE mission(
   Mission_Id   INT              NOT NULL,
   Mission_Name VARCHAR(100)     NOT NULL,
   Image_Type  CHAR(40)          NOT NULL,
   Start_Date  TIMESTAMP ,
   Finish_Date   TIMESTAMP,       
   PRIMARY KEY (Mission_Id)
);
insert into mission
values(1, 'Ranga all', 'Panchromatic', '1970-01-01 00:00:01','1980-02-01 00:00:01');
insert into mission
values(2, 'Toan binance', 'Multispectral', '1990-03-01 00:00:01', '1999-04-01 00:00:01');

DROP TABLE "PRODUCT";
CREATE TABLE PRODUCT(
   Product_Id   INT              NOT NULL,
   Mission_Name VARCHAR(100)     NOT NULL,
   Taken_Date  TIMESTAMP          NOT NULL,
   Footprint  INT ,
   Price   FLOAT,      
   Url	CHAR(100), 
   PRIMARY KEY (Product_Id)
);

insert into product
values(1, 'Ranga all', '1975-08-01 00:00:01', 2, 100.00, '/images/moon.jpg');

DROP TABLE "CART";
CREATE TABLE CART(
   Id	   		INT  AUTO_INCREMENT   NOT NULL,
   Product_Id 	INT     NOT NULL,
   Customer_Id  INT     NOT NULL,
   Mission_Id  INT     NOT NULL,
   Product_Name VARCHAR(100) ,
   Price   		FLOAT,      
   Url	   		CHAR(100), 
   Bill_Date 	TIMESTAMP,
   PRIMARY KEY (Id)
);

insert into cart
values(1, 2, 1, 1, 'moon star', 300.03, '/images/virus1.jpg', '1990-07-01 00:00:01');
insert into cart
values(2, 1, 1, 1, 'moon star 2', 200.90, '/images/virus2.jpg', '1990-08-01 00:00:01');
insert into cart
values(3, 3, 1, 1, 'moon star 3', 100.02, '/images/virus3.jpg', '1990-09-01 00:00:01');
insert into cart
values(4, 5, 1, 2, 'moon star 5', 100.04, '/images/virus5.jpg', '1990-10-01 00:00:01');

DROP TABLE "BILL";
CREATE TABLE BILL(
   Id	   		INT  AUTO_INCREMENT   NOT NULL,
   Customer_Id  INT     NOT NULL,
   Amount  FLOAT     NOT NULL,
   Bought_Date 	TIMESTAMP,
   PRIMARY KEY (Id)
);
