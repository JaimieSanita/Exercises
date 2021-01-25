--CREATE DATABASE sandwhich_shop;

START TRANSACTION;

DROP TABLE IF EXISTS menu_sandwhich_type;
DROP TABLE IF EXISTS menu;
DROP TABLE IF EXISTS sandwhich_type;

CREATE TABLE menu
(
        id               serial                 PRIMARY KEY,
        name             varchar(128)           NOT NULL,
        description      varchar,
        price            decimal,
        unit_price       decimal,
        is_available     boolean                NOT NULL
);

CREATE TABLE sandwhich_type
(
        id              serial                  PRIMARY KEY,
        name            varchar(128)            NOT NULL,
        description     varchar                 NOT NULL DEFAULT '' --EMPTY STRING RATHER THAN NULL, SO JAVA CODE DOESN'T ALWAYS HAVE TO CHECK FOR NULL
);


CREATE TABLE menu_sandwhich_type
(
        menu_id         int                     NOT NULL,
        type_id         int                     NOT NULL,
        
        CONSTRAINT pk_menu_sandwhich_type PRIMARY KEY (menu_id, type_id),
        CONSTRAINT fk_menu_id_id FOREIGN KEY (menu_id) REFERENCES menu(id),
        CONSTRAINT fk_type_id_id FOREIGN KEY (type_id) REFERENCES sandwhich_type(id)
);

INSERT INTO sandwhich_type (name, description) VALUES
('hot', 'hot off the grill'),
('cold', 'the best cold cuts'),
('open-face', 'big plates for big eaters'),
('Pittsburgh Style', 'why not put fries on the sandwich');

COMMIT;