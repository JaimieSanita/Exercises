DROP TABLE IF EXISTS status;

CREATE TABLE status(
        id              SERIAL          PRIMARY KEY,
        is_apocalyse    boolean         NOT NULL        DEFAULT false,
        message         varchar(120)    NOT NULL
        
);

INSERT INTO status (message)('Looking like it might be soon?!');
INSERT INTO status (message)('Not currently');