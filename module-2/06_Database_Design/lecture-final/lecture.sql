-- RUN THIS AGAINST YOUR Postgres connection
--CREATE DATABASE art_gallery;

-- Once the database is made create a connection to it and switch to that connection
BEGIN TRANSACTION;

CREATE TABLE address
(
        id              serial, --we get a sequence object representing the next id, we get a not-null constraint - the sequence is also assigned to this column
        house_number    varchar(16) NOT NULL,
        street          varchar(64) NOT NULL,
        street2         varchar(64),
        city            varchar(64) NOT NULL,
        province        varchar(64) NOT NULL,
        postal_code     varchar(16) NOT NULL,

        CONSTRAINT pk_address PRIMARY KEY (id)
        
);

CREATE TABLE person
(
--     column_name      datatype        constraints/defaults , 
        id              serial          PRIMARY KEY,
        first_name      varchar(64),
        last_name       varchar(64)     NOT NULL,
        create_date     TIMESTAMP       NOT NULL DEFAULT now()
        
-- additional constraints declared below if needed        
);

INSERT INTO person (first_name, last_name) VALUES ('Katherine', 'Johnson');
SELECT * FROM person;

CREATE TABLE person_address
(
        person_id       int             NOT NULL,
        address_id      int             NOT NULL,
        is_primary      boolean         NOT NULL DEFAULT false,
        is_billing      boolean         NOT NULL DEFAULT false,
        
--      constraint  name                constraint-type         columns  value        
        CONSTRAINT pk_person_address    PRIMARY KEY             (person_id,address_id)

);




-- deleting tables
-- WARNING be very careful with this command. It will flush all the data in the table without prompting you.
--DROP TABLE person;
--DROP TABLE address;


-- NOTE: Often we add foreign key constraints at the end, rather than while we're creating the tables
-- this is because it is annoying to have to create the tables in order to make the constraints match up
-- this way, we make all the tables and add the constraints after the fact but BEFORE we insert any data

ALTER TABLE person_address
        --  constraint      name            constraint type         column          references      table   column    
        ADD CONSTRAINT fk_person_id_id      FOREIGN KEY             (person_id) REFERENCES          person(id),    
        ADD CONSTRAINT fk_address_id_id     FOREIGN KEY             (address_id) REFERENCES         address(id);

ALTER TABLE person
        ALTER COLUMN first_name SET NOT NULL;

-- ONLY FOR EXAMPLE - you would modify the create statement
ALTER TABLE person
ADD COLUMN greeting     varchar(16)     NOT NULL DEFAULT 'Hi!';

SELECT * FROM person;




COMMIT;


START TRANSACTION;

ALTER TABLE person_address
        DROP CONSTRAINT fk_person_id_id,    
        DROP CONSTRAINT fk_address_id_id;

DROP TABLE person;
DROP TABLE address;
DROP TABLE person_address;

ROLLBACK;

-- Disconnect from your art_gallery database and run this on Postgres connection to delete the database
--DROP DATABASE art_gallery;