CREATE TABLE CUSTOMER (
		ID BIGINT DEFAULT AUTOINCREMENT: start 1 increment 1 NOT NULL GENERATED ALWAYS AS IDENTITY  (START WITH 1 ,INCREMENT BY 1),
		NAME VARCHAR(255) NOT NULL,
		CREATETIME VARCHAR(255) NOT NULL
	);

ALTER TABLE CUSTOMER ADD CONSTRAINT SQL190606145953480 PRIMARY KEY (ID);




CREATE TABLE Sport_Events (
		ID BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
		eventName    VARCHAR(255)  NOT NULL,
		dateOfEvent  VARCHAR(255)  NOT NULL,
		description  VARCHAR(255) ,
		eventType    VARCHAR(255)  NOT NULL,
		venue        VARCHAR(255)  NOT NULL,
		importantInfo    VARCHAR(255) ,
		roomTypes    VARCHAR(255) ,
		eventImage   VARCHAR(255) )
		