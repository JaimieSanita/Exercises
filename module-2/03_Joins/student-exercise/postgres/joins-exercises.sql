-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT a.first_name, a.last_name, f.title
FROM film AS f
JOIN film_actor AS fa ON f.film_id = fa.film_id
JOIN actor AS a ON fa.actor_id = a.actor_id
WHERE a.last_name = 'STALLONE' AND a.first_name = 'NICK';


-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT a.first_name, a.last_name, f.title
FROM film AS f
JOIN film_actor AS fa ON f.film_id = fa.film_id
JOIN actor AS a ON fa.actor_id = a.actor_id
WHERE a.last_name = 'REYNOLDS' AND a.first_name = 'RITA';

-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)

SELECT a.first_name, a.last_name, f.title
FROM film AS f
JOIN film_actor AS fa ON f.film_id = fa.film_id
JOIN actor AS a ON fa.actor_id = a.actor_id
WHERE a.last_name = 'DEAN';

-- 4. All of the the ‘Documentary’ films
-- (68 rows)

SELECT c.name, f.title
FROM film AS f
JOIN film_category AS fc ON f.film_id = fc.film_id
JOIN category AS c ON fc.category_id = c.category_id
WHERE c.name = 'Documentary';



-- 5. All of the ‘Comedy’ films
-- (58 rows)

SELECT c.name, f.title
FROM film AS f
JOIN film_category AS fc ON f.film_id = fc.film_id
JOIN category AS c ON fc.category_id = c.category_id
WHERE c.name = 'Comedy';

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)

SELECT c.name AS "Category", f.rating, f.title
FROM film AS f
JOIN film_category AS fc ON f.film_id = fc.film_id
JOIN category AS c ON fc.category_id = c.category_id
WHERE c.name = 'Children' AND f.rating = 'G';

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)

SELECT c.name AS "Category", f.rating, f.title, f.length
FROM film AS f
JOIN film_category AS fc ON f.film_id = fc.film_id
JOIN category AS c ON fc.category_id = c.category_id
WHERE c.name = 'Family' AND f.rating = 'G' AND f.length < 120;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)

SELECT a.first_name, a.last_name, f.title, f.rating
FROM film AS f
JOIN film_actor AS fa ON f.film_id = fa.film_id
JOIN actor AS a ON fa.actor_id = a.actor_id
WHERE a.last_name = 'LEIGH' AND a.first_name = 'MATTHEW' AND f.rating = 'G';

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)

SELECT c.name AS "Category", f.release_year, f.title
FROM film AS f
JOIN film_category AS fc ON f.film_id = fc.film_id
JOIN category AS c ON fc.category_id = c.category_id
WHERE c.name = 'Sci-Fi' AND f.release_year = 2006;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)

SELECT c.name AS "Category", f.title, a.first_name, a.last_name
FROM film AS f
JOIN film_category AS fc ON f.film_id = fc.film_id
JOIN category AS c ON fc.category_id = c.category_id
JOIN film_actor AS fa ON f.film_id = fa.film_id
JOIN actor AS a ON fa.actor_id = a.actor_id
WHERE c.name = 'Action' AND a.last_name = 'STALLONE' AND a.first_name = 'NICK';

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)

SELECT a.address, city.city, a.district, c.country
FROM store AS s
JOIN address AS a ON s.address_id = a.address_id
JOIN city ON a.city_id = city.city_id
JOIN country AS c ON city.country_id = c.country_id;


-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)

SELECT s.store_id, a.address, staff.last_name, staff.first_name
FROM store AS s
JOIN address AS a ON s.address_id = a.address_id
JOIN city ON a.city_id = city.city_id
JOIN staff ON s.store_id = staff.store_id;

-- 13. The first and last name of the top ten customers ranked by number of rentals 
-- (#1 should be “ELEANOR HUNT�? with 46 rentals, #10 should have 39 rentals)

SELECT c.first_name, c.last_name, COUNT(r.rental_id) AS "# of Rentals"
FROM customer AS c
JOIN rental AS r ON c.customer_id = r.customer_id
GROUP BY c.last_name, c.first_name
ORDER BY "# of Rentals" DESC 
LIMIT 10;

-- 14. The first and last name of the top ten customers ranked by dollars spent 
-- (#1 should be “KARL SEAL�? with 221.55 spent, #10 should be “ANA BRADLEY�? with 174.66 spent)

SELECT c.first_name, c.last_name, SUM(p.amount) AS "Dollars Spent"
FROM customer AS c
JOIN rental AS r ON c.customer_id = r.customer_id
JOIN payment AS p ON r.rental_id = p.rental_id
GROUP BY c.last_name, c.first_name
ORDER BY "Dollars Spent" DESC 
LIMIT 10;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that an employee may work at multiple stores.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)

SELECT s.store_id, a.address, COUNT(r.rental_id) AS "Total # of Rentals", SUM(p.amount) AS "Total Amount of Sales", AVG(p.amount) AS "Average Sale"
FROM store AS s
JOIN address AS a ON s.address_id = a.address_id
JOIN inventory AS i ON s.store_id = i.store_id
JOIN rental AS r ON i.inventory_id = r.inventory_id
JOIN payment AS p ON r.rental_id = p.rental_id
GROUP BY s.store_id, a.address
ORDER BY s.store_id;

-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD�? with 34 rentals and #10 should have 31 rentals)

SELECT f.title, COUNT(r.rental_id) AS "Number of Rentals"
FROM film AS f
JOIN inventory AS i ON f.film_id = i.film_id
JOIN rental AS r ON i.inventory_id = r.inventory_id
GROUP BY f.title
ORDER BY "Number of Rentals" DESC
LIMIT 10;


-- 17. The top five film categories by number of rentals 
-- (#1 should be “Sports�? with 1179 rentals and #5 should be “Family�? with 1096 rentals)

SELECT c.name, COUNT(r.rental_id) AS "Number of Rentals"
FROM film AS f
JOIN film_category AS fc ON f.film_id = fc.film_id
JOIN category AS c ON fc.category_id = c.category_id
JOIN inventory AS i ON f.film_id = i.film_id
JOIN rental AS r ON i.inventory_id = r.inventory_id
GROUP BY c.name
ORDER BY "Number of Rentals" DESC
LIMIT 5;


-- 18. The top five Action film titles by number of rentals 
-- (#1 should have 30 rentals and #5 should have 28 rentals)

SELECT f.title, COUNT(r.rental_id) AS "Number of Rentals"
FROM film AS f
JOIN film_category AS fc ON f.film_id = fc.film_id
JOIN category AS c ON fc.category_id = c.category_id
JOIN inventory AS i ON f.film_id = i.film_id
JOIN rental AS r ON i.inventory_id = r.inventory_id
WHERE c.name = 'Action'
GROUP BY f.title
ORDER BY "Number of Rentals" DESC
LIMIT 5;


-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
-- (#1 should be “GINA DEGENERES�? with 753 rentals and #10 should be “SEAN GUINESS�? with 599 rentals)

-- 20. The top 5 “Comedy�? actors ranked by number of rentals of films in the “Comedy�? category starring that actor 
-- (#1 should have 87 rentals and #5 should have 72 rentals)
