-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
SELECT * FROM actor;

START TRANSACTION;

INSERT INTO actor (first_name, last_name) VALUES ('HAMPTON', 'AVENUE');
INSERT INTO actor (first_name, last_name) VALUES ('LISA', 'BYWAY');

SELECT * FROM actor;

COMMIT;

SELECT * FROM actor;
--201 HAMPTON AVENUE
--202 LISA BYWAY
-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
SELECT * FROM film
ORDER BY film_id DESC
LIMIT 5;
START TRANSACTION;

INSERT INTO film (title, description, release_year, language_id, length)
VALUES ('EUCLIDEAN PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 75);


SELECT * FROM film
ORDER BY film_id DESC
LIMIT 5;

COMMIT;

SELECT * FROM film
ORDER BY film_id DESC
LIMIT 5;


-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
SELECT * FROM actor WHERE first_name = 'LISA';
SELECT * FROM film_actor
ORDER BY film_id DESC;

START TRANSACTION;

INSERT INTO film_actor (actor_id, film_id) VALUES (205, 1003);
INSERT INTO film_actor (actor_id, film_id) VALUES (206, 1003);

SELECT * FROM film_actor
ORDER BY film_id DESC;

COMMIT;

SELECT * FROM film_actor
ORDER BY film_id DESC;
-- 4. Add Mathmagical to the category table.

SELECT * FROM category;

START TRANSACTION;

INSERT INTO category (name) VALUES ('Mathmagical');

SELECT * FROM category;

COMMIT;

SELECT * FROM category;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)


-- 7. Add a copy of "Euclidean PI" to all the stores.

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
