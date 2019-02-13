CREATE sequence HIBERNATE_SEQUENCE;
--  DDL for Table USER
--------------------------------------------------------

  CREATE TABLE "USER"
   ("ID" BIGINT PRIMARY KEY,
	"DTYPE" VARCHAR(32) NOT NULL,
	"LOGIN" VARCHAR(64) NOT NULL,
	"PASSWORD" VARCHAR(64) NOT NULL,
	"FULLNAME" VARCHAR(128),
	"ADDRESS" VARCHAR(128),
	"PHONE" VARCHAR(20),
	"BALANCE" DOUBLE,
	"DISCOUNT" INTEGER
   );
--------------------------------------------------------
--  DDL for Table CLIENTORDER
--------------------------------------------------------

  CREATE TABLE "CLIENTORDER"
   ("ID" BIGINT PRIMARY KEY,
	"CLOSINGDATE" VARCHAR,
	"CREATIONDATE" VARCHAR NOT NULL,
	"STATUS" VARCHAR(20),
	"TOTAL" DOUBLE,
    "CLIENT_ID" BIGINT
   );
   --------------------------------------------------------
--  DDL for Table FLOWER
--------------------------------------------------------

  CREATE TABLE "FLOWER"
   ("ID" BIGINT PRIMARY KEY,
    "NAME" VARCHAR(45) NOT NULL,
	  "COUNT" INTEGER,
	  "PRICE" DOUBLE
   );
--------------------------------------------------------
--  DDL for Table ORDERITEM
--------------------------------------------------------

  CREATE TABLE "ORDERITEM"
   ("ID" BIGINT PRIMARY KEY,
    "FLOWER_ID" BIGINT,
	  "COUNT" INTEGER,
	  "PRICE" DOUBLE
   );
   
   --------------------------------------------------------
--  DDL for Table CLIENTORDER_ORDERITEM
--------------------------------------------------------

  CREATE TABLE "CLIENTORDER_ORDERITEM"
   ("CLIENTORDER_ID" BIGINT,
    "ORDERITEMS_ID" BIGINT UNIQUE
   );
--------------------------------------------------------
--  Insert data
--------------------------------------------------------
INSERT INTO FLOWER (ID, NAME,COUNT,PRICE) values (HIBERNATE_SEQUENCE.NEXTVAL, 'Azalea', 1000, 50);
INSERT INTO FLOWER (ID, NAME,COUNT,PRICE) values (HIBERNATE_SEQUENCE.NEXTVAL, 'Aster', 1500, 75);
INSERT INTO FLOWER (ID, NAME,COUNT,PRICE) values (HIBERNATE_SEQUENCE.NEXTVAL, 'Iris', 850, 40);
INSERT INTO FLOWER (ID, NAME,COUNT,PRICE) values (HIBERNATE_SEQUENCE.NEXTVAL, 'Lily', 3000, 150);

COMMIT;