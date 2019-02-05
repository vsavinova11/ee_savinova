--  DDL for Table USER
--------------------------------------------------------

  CREATE TABLE "USER"
   ("ID" BIGINT NOT NULL PRIMARY KEY,
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
   ("ID" BIGINT NOT NULL PRIMARY KEY,
    "CLIENT_ID" BIGINT,

   );
   --------------------------------------------------------
--  DDL for Table FLOWER
--------------------------------------------------------

  CREATE TABLE "FLOWER"
   ("ID" BIGINT NOT NULL PRIMARY KEY,
    "NAME" VARCHAR,
	"COUNT" INT,
	"PRICE" DOUBLE
   );
--------------------------------------------------------
--  DDL for Table ORDERITEM
--------------------------------------------------------

  CREATE TABLE "ORDERITEM"
   ("ID" BIGINT NOT NULL PRIMARY KEY,
    "FLOWER_ID" BIGINT,
	"COUNT" INT,
	"PRICE" DOUBLE
   );
   --------------------------------------------------------
--  DDL for Table CLIENTORDER_ORDERITEM
--------------------------------------------------------

  CREATE TABLE "CLIENTORDER_ORDERITEM"
   ("CLIENTORDER_ID" BIGINT NOT NULL,
    "ORDERITEM_ID" BIGINT,
	"COUNT" INT,
	"PRICE" DOUBLE
   );


COMMIT;