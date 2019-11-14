-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE IF EXISTS CUSTOMER;

CREATE TABLE CUSTOMER (
                         ID INT AUTO_INCREMENT  PRIMARY KEY,
                         FULL_NAME VARCHAR(250) NOT NULL,
                         EMAIL VARCHAR(250) NOT NULL,
                         PASSWORD VARCHAR(250) DEFAULT NULL
                        );

DROP TABLE IF EXISTS SUBSCRIPTION;

CREATE TABLE SUBSCRIPTION (
                            ID INT AUTO_INCREMENT  PRIMARY KEY,
                            NAME VARCHAR(250) ,
                            AVAILABLE_CONTENT INT,
                            PRICE DOUBLE,
                            REMAINING_CONTENT INT,
                            START_DATE DATE,
                            CUSTOMER_ID INT
                            );

ALTER TABLE SUBSCRIPTION ADD CONSTRAINT FK_CUSTOMER_ID FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(ID);

DROP TABLE IF EXISTS CATEGORY;

CREATE TABLE CATEGORY (
                              ID INT AUTO_INCREMENT  PRIMARY KEY,
                              NAME VARCHAR(250) ,
                              AVAILABLE_CONTENT INT,
                              PRICE DOUBLE,
                              REMAINING_CONTENT INT,
);


INSERT INTO CATEGORY (ID,NAME, AVAILABLE_CONTENT, PRICE,REMAINING_CONTENT) VALUES
(1,'Dutch Films', 10,4.0,10 ),
(2,'Dutch Series',20,6.0,20 ),
(3,'International Films', 10,8.0,10 );