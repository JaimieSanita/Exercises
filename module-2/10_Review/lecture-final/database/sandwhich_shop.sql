-- CREATE DATABASE sandwich_shop;

START TRANSACTION;

DROP TABLE IF EXISTS menu_sandwich_type;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS sandwich_type;

CREATE TABLE menu
(
        id  serial PRIMARY KEY,
        name varchar(128) NOT NULL,
        description varchar,
        price decimal,
        unit_price decimal,
        is_available boolean NOT NULL
);

CREATE TABLE sandwich_type
(
        id serial PRIMARY KEY,
        name varchar(128) NOT NULL,
        description varchar NOT NULL DEFAULT '' --empty string rather than null, so that our java code doesn't always have to check for null
);



CREATE TABLE menu_sandwich_type
(
        menu_id int NOT NULL,
        type_id int NOT NULL,
        
        CONSTRAINT pk_menu_sandwich_type PRIMARY KEY (menu_id,type_id),
        CONSTRAINT fk_menu_id_id FOREIGN KEY (menu_id) REFERENCES menu(id),
        CONSTRAINT fk_type_id_id FOREIGN KEY (type_id) REFERENCES sandwich_type(id)
 );


INSERT INTO sandwich_type (name,description) VALUES
('hot','hot off the grill'),
('cold', 'the best cold cuts'),
('open-face', 'big plates for big eaters'),
('Pittsburgh Style', 'Why not put the fries ON THE SANDWICH');




COMMIT;