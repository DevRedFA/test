CREATE TABLE "contracts" (
	"id" serial NOT NULL,
	CONSTRAINT contracts_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "applications" (
	"id" bigserial NOT NULL,
	"DT_created" TIMESTAMP NOT NULL,
	"contract_id" integer NOT NULL,
	"product_id" integer NOT NULL,
	CONSTRAINT applications_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "products" (
	"id" serial NOT NULL,
	"name" varchar(64) NOT NULL,
	CONSTRAINT Products_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);




ALTER TABLE "applications" ADD CONSTRAINT "applications_fk0" FOREIGN KEY ("contract_id") REFERENCES "contracts"("id");
ALTER TABLE "applications" ADD CONSTRAINT "applications_fk1" FOREIGN KEY ("product_id") REFERENCES "products"("id");


--select * from applications where contract_id = 1 ORDER BY "DT_created" DESC, id DESC LIMIT 1
--
--select ap.contract_id, ap.id, ap."DT_created", products."name" from applications as ap
--left JOIN products on products.id = ap.product_id
--where contract_id = 1 ORDER BY "DT_created" DESC, id DESC LIMIT 1
