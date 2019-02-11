
CREATE sequence USER_SEQ;
CREATE sequence CLIENTORDER_SEQ;
CREATE sequence FLOWER_SEQ;
CREATE sequence ORDERITEM_SEQ;

--  DDL for Table USER
--------------------------------------------------------

  CREATE TABLE "USER"
   ("ID" BIGINT NOT NULL UNIQUE PRIMARY KEY,
	"DTYPE" VARCHAR NOT NULL,
	"LOGIN" VARCHAR,
	"PASSWORD" VARCHAR,
	"FULLNAME" VARCHAR,
	"ADDRESS" VARCHAR,
	"PHONE" VARCHAR,
	"BALANCE" DOUBLE,
	"DISCOUNT" INT
   );
--------------------------------------------------------
--  DDL for Table CLIENTORDER
--------------------------------------------------------

  CREATE TABLE "CLIENTORDER"
   ("ID" BIGINT NOT NULL UNIQUE PRIMARY KEY,
	"CLOSINGDATE" VARCHAR,
	"CREATIONDATE" VARCHAR,
	"STATUS" VARCHAR,
	"TOTAL" DOUBLE,
    "CLIENT_ID" BIGINT
   );
   --------------------------------------------------------
--  DDL for Table FLOWER
--------------------------------------------------------

  CREATE TABLE "FLOWER"
   ("ID" BIGINT NOT NULL UNIQUE PRIMARY KEY,
    "NAME" VARCHAR,
	  "COUNT" INT,
	  "PRICE" DOUBLE
   );
--------------------------------------------------------
--  DDL for Table ORDERITEM
--------------------------------------------------------

  CREATE TABLE "ORDERITEM"
   ("ID" BIGINT NOT NULL UNIQUE PRIMARY KEY,
    "FLOWER_ID" BIGINT,
	  "COUNT" INT,
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
INSERT INTO FLOWER (ID, NAME,COUNT,PRICE) values (FLOWER_SEQ.NEXTVAL, 'Azalea', 100, 75);
INSERT INTO FLOWER (ID, NAME,COUNT,PRICE) values (FLOWER_SEQ.NEXTVAL, 'Aster', 150, 75);


COMMIT;