--RUN THIS AGAINST YOUR POSTGRES CONNECTION
--CREATE DATABASE art_gallery;

--Once the database is made, create a connection to it & switch to that connection (art_gallery_connection)

--by using serial data type: receive sequence object representing the next id, get not null constraint, sequence is assigned to this column AUTOMATICALLY
START TRANSACTION;
CREATE TABLE address
(
        id              serial, 
        house_number    varchar(16) NOT NULL,
        street          varchar(64) NOT NULL,
        street2         varchar(64),
        city            varchar(64) NOT NULL,
        province        varchar(64) NOT NULL,
        postal_code     varchar(16) NOT NULL,
        
        CONSTRAINT pk_address PRIMARY KEY (id)
        --         name                    column that is primary key
        --pk = Primary Key
        --can add multiple columns to primary key by separating with comma (,)
        
        
);

CREATE TABLE person
(
        --column name   datatype                constraints/defaults
        id              serial                  PRIMARY KEY,
        first_name      varchar(64),
        last_name       varchar(64)             NOT NULL,
        create_date     TIMESTAMP               NOT NULL DEFAULT now()
);


INSERT INTO person (first_name, last_name) VALUES ('Katherine', 'Johnson');

SELECT * FROM person;
--JOIN table
CREATE TABLE person_address
(
        person_id       int                     NOT NULL,   
        address_id      int                     NOT NULL, 
        is_primary      boolean                 NOT NULL DEFAULT false,
        is_billing      boolean                 NOT NULL DEFAULT false,
--      CONSTRAINT   NAME                CONSTRAINT-TYPE        COLUMN(S)       VALUE       
        CONSTRAINT  pk_person_address    PRIMARY KEY            (person_id, address_id)

           
         
);




--WARNING: be very careful with this command. It will flush all the data in the table without prompting you unless foreign key constraints & then won't allow deletion.
--DROP TABLE  person;
--DROP TABLE address;

--NOTE: often we add FOREIGN KEY CONSTRAINTS at the  end rather than during table creation b/c it is annoying to create tables in order to fulfill foreign key contraints match up
--this way, we make all the tables and add the contraints after the fact but BEFORE we insert any data
--add constraints at the end, after tables created
--can not change datatype of a column but can drop/add columns
ALTER TABLE person_address
--  CONSTRAINT      NAME            CONSTRAINT-TYPE         COLUMNS         REF             TABLE   COLUMN
ADD CONSTRAINT  fk_person_id_id      FOREIGN KEY            (person_id)     REFERENCES      person(id),
ADD CONSTRAINT  fk_address_id_id     FOREIGN KEY            (address_id)    REFERENCES      address(id);

ALTER TABLE employee
ALTER COLUMN first_name SET NOT NULL; 

ROLLBACK;


--Disconnect from your art_gallery_connection database and run this on Postgres connection to delete the database
--DROP DATABASE art_gallery;