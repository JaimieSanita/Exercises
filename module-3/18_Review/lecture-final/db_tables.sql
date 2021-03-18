DROP TABLE IF EXISTS status;

CREATE TABLE status(
        id SERIAL PRIMARY KEY,
        is_apocalypse boolean NOT NULL DEFAULT false,
        message varchar(120) NOT NULL
);

INSERT INTO status (message) VALUES ('Looking like it might be soon?!');
INSERT INTO status (message) VALUES ('Not currently');