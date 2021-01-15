
-- DB Visualizer Limitations

-- SQL HAS NOT ROW LIMITATIONS
-- DBVisualizator for performance reasons only shows you 1,000 rows at max at a time
-- if, for example, I want the newest film actor pairing, I can use order by to ensure I get the appropriate results
-- film actor table

SELECT * 
FROM  film_actor
ORDER BY film_id DESC, actor_id DESC
LIMIT 100;

-- how to select specific rows

SELECT * 
FROM film_actor
WHERE film_id > 900;

-- Number of years since independence for all countries that have a year of independence 

SELECT name, indepyear, (2021 - indepyear) AS "independence_years"
FROM country 
WHERE indepyear IS NOT NULL
ORDER BY independence_years DESC;

-- data dump how do we get data into our database

-- TOP 10 customers by rental 

--WITHOUT GROUPING
SELECT *
FROM customer
JOIN rental ON customer.customer_id = rental.customer_id
ORDER BY customer.customer_id
LIMIT 10;


SELECT customer.first_name, customer.last_name, customer.customer_id, COUNT(rental.rental_id) AS rental_count
FROM customer
JOIN rental ON customer.customer_id = rental.customer_id
GROUP BY customer.customer_id, customer.first_name, customer.last_name -- note that the name fields don't affect the grouping, because the ids are already unique
ORDER BY COUNT(rental.rental_id) DESC
LIMIT 10;

-- joining the other direction

SELECT customer.first_name, customer.last_name, customer.customer_id, COUNT(rental.rental_id) AS rental_count
FROM rental
JOIN customer ON rental.customer_id = customer.customer_id
GROUP BY customer.customer_id, customer.first_name, customer.last_name -- note that the name fields don't affect the grouping, because the ids are already unique
ORDER BY COUNT(rental.rental_id) DESC
LIMIT 10;

-- Absolute value of GNP
SELECT name, (gnp-gnpold) AS gnp_difference, ABS(gnp-gnpold) AS abs_gnp_difference
FROM country
WHERE gnpold IS NOT NULL AND gnp IS NOT NULL
ORDER BY abs_gnp_difference DESC;

-- bonus content coalesce function turns null into a value
SELECT name, (gnp-COALESCE(gnpold,0)) AS gnp_difference, ABS(gnp-COALESCE(gnpold,0)) AS abs_gnp_difference
FROM country
WHERE gnp IS NOT NULL
ORDER BY abs_gnp_difference DESC;


-- inserts/deletes, etc

SELECT * FROM actor LIMIT 5;

START TRANSACTION;

INSERT INTO actor (first_name, last_name) VALUES ('BRAD', 'CHADWICK');

SELECT * FROM actor ORDER BY actor_id DESC LIMIT 5;

DELETE FROM actor WHERE actor_id IN (select MAX(actor_id) FROM actor);
SELECT * FROM actor ORDER BY actor_id DESC LIMIT 5;

ROLLBACK;



-- can you do a join when you are doing an update statement?

START TRANSACTION;

SELECT * FROM film LIMIT 1;

INSERT INTO film (title, description, release_year, language_id) VALUES ('The Hunt for Red January', 'The stoopidist search for a broken submarine yinz have ever seen n''at', 2021, 1);

INSERT INTO category (name) values ('Underwater Excursions');
SELECT max(category_id) FROM category;
SELECT max(film_id) FROM film;

INSERT INTO film_category (film_id, category_id) VALUES (1003,19);

UPDATE film uf
SET rating = 'PG-13'
FROM film AS f
JOIN film_category ON f.film_id = film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE category.name = 'Underwater Excursions' AND uf.film_id = f.film_id;


SELECT * FROM film ORDER BY film_id DESC LIMIT 1;







ROLLBACK;





