--DB Visualizer Limitations
        --SQL has no row restrictions
        --DB Visualizer only displays 1000 rows at max at a time for PERFORMANCE REASONS
        --if, for example, I want  the newest film actor pairing, I can use ORDER BY to ensure I display appropriate results
SELECT * 
FROM film_actor
ORDER BY film_id DESC, actor_id DESC;

--how to select specific rows

SELECT *
FROM film_actor
WHERE film_id > 900;

SELECT name, indepyear, (2021 - indepyear) AS "independence_years"
FROM country
WHERE indepyear IS NOT NULL
ORDER BY "independence_years";

--how do we get data in our database

--bonus: coalesce
--FUNCTION TAKES IN COLUMN AND IF HAPPENS TO BE NULL, REPLACES WITH VALUE PROVIDED

--can do a join when you are doin an update stmt
START TRANSACTION;

SELECT * FROM film LIMIT 1;

INSERT INTO film(title, description, release_year, language_id) 
VALUES ('The hunt for Red January', 'Silly', 2021, 1);

INSERT INTO category(name)
VALUES ('Underwater Excursions');
SELET MAX(category

UPDATE film 
SET rating = 'PG13'
FROM film
JOIN 


SELECT * FROM film ORDER BY film_id DESC;

ROLLBACK;