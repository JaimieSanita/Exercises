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
SELECT * FROM film WHERE title ILIKE '%YOUNG%';
SELECT * FROM film_category WHERE film_id IN (1003, 274, 494, 714, 996);

START TRANSACTION;

INSERT INTO film_category (film_id, category_id) VALUES (1003, 18);
INSERT INTO film_category (film_id, category_id) VALUES (274, 18);
INSERT INTO film_category (film_id, category_id) VALUES (494, 18);
INSERT INTO film_category (film_id, category_id) VALUES (714, 18);
INSERT INTO film_category (film_id, category_id) VALUES (996, 18);

SELECT * FROM film_category WHERE film_id IN (1003, 274, 494, 714, 996);

COMMIT;

SELECT * FROM film_category WHERE film_id IN (1003, 274, 494, 714, 996);

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)


SELECT * FROM film WHERE film_id IN (1003, 274, 494, 714, 996);

START TRANSACTION;

UPDATE film SET rating = 'G' WHERE film_id = 1003;
UPDATE film SET rating = 'G' WHERE film_id = 274;
UPDATE film SET rating = 'G' WHERE film_id = 494;
UPDATE film SET rating = 'G' WHERE film_id = 714;
UPDATE film SET rating = 'G' WHERE film_id = 996;

SELECT * FROM film WHERE film_id IN (1003, 274, 494, 714, 996);

COMMIT;

SELECT * FROM film WHERE film_id IN (1003, 274, 494, 714, 996);


-- 7. Add a copy of "Euclidean PI" to all the stores.

SELECT store_id, COUNT(store_id) AS "Count" FROM inventory
GROUP BY store_id;

SELECT * FROM inventory WHERE film_id = 1003;

START TRANSACTION;

INSERT INTO inventory (film_id, store_id) VALUES (1003, 1);
INSERT INTO inventory (film_id, store_id) VALUES (1003, 2);

SELECT * FROM inventory WHERE film_id = 1003;

COMMIT;

SELECT * FROM inventory WHERE film_id = 1003;



-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
--The code below cannot execute because this action is a violation of the Foreign Key Constraint. Euclidean Pi cannot be deleted from the film table because it's row points to 
--rows in other tables such as film_actor, inventory and film_category, and therefore cannot be deleted.
SELECT * FROM film WHERE film_id = 1003;

START TRANSACTION;

DELETE FROM film WHERE film_id = 1003;

SELECT * FROM film WHERE film_id = 1003;

ROLLBACK;

SELECT * FROM film WHERE film_id = 1003;
-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
--Once again, this deletion cannot be executed due to a Foreign Key Constraint. The category Mathmagical cannot be deleted from the category table because it is referenced
--in the film_category table. 
SELECT * FROM category;
START TRANSACTION;

DELETE FROM category WHERE category_id = 18;
SELECT * FROM category;

ROLLBACK;
SELECT * FROM category;

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
--This deletion was successful because Mathmagical is not linked to other tables as a foreign key and thus no other tables rely on links to Mathmagical. Mathmagical is still
--a defined category in the category table but this deletion will not effect it.
SELECT * FROM film_category WHERE category_id = 18;
START TRANSACTION;

DELETE FROM film_category WHERE category_id = 18;
SELECT * FROM film_category WHERE category_id = 18;

COMMIT;
SELECT * FROM film_category WHERE category_id = 18;

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>
--Mathmagical was deleted from the category table as no other tables rely on it's category_id as a foreign key.
--Euclidean Pi could not be deleted from the film table due to a Foreign Key Constraint. The associated film_id is still referenced in tables film_actor and inventory.

SELECT * FROM category;
START TRANSACTION;

DELETE FROM category WHERE name = 'Mathmagical';
SELECT * FROM category;

COMMIT;
SELECT * FROM category;


SELECT * FROM film WHERE film_id = 1003;
START TRANSACTION;

DELETE FROM film WHERE film_id = 1003;
SELECT * FROM film WHERE film_id = 1003;

ROLLBACK;
SELECT * FROM film WHERE film_id = 1003;


-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
--Remaining Foreign Link Constraints must be deleted before Euclident can be removed from the film table.
--The remaining adjustments required are:
        --delete link in film_actor table
        --delete link in inventory table
        --delete from film table

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;
