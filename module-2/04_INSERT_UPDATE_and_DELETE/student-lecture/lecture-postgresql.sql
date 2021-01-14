--JOIN REVIEW

SELECT cu.first_name, cu.last_name, ad.address, ad.address2, ad.district, c.city, ad.postal_code
FROM customer AS cu
LEFT JOIN address AS ad --gets ALL the customers & their address, if any address provided (customer is 1st table, address is 2nd), if no address, value stored as NULL
                        --if default JOIN, get ONLY customers that have address provided 
ON cu.address_id = ad.address_id
LEFT JOIN city AS c
ON ad.city_id = c.city_id;

START TRANSACTION;
--DANGEROUS: we always want a WHERE clause on UPDATEs & DELETEs
UPDATE country
SET capital = null;

SELECT capital, * FROM country;
--SOME SQL HERE
DELETE FROM city;
DELETE FROM country;

ROLLBACK; --or ROLLBACK

-- INSERT

-- 1. Add Klingon as a spoken language in the USA
-- 2. Add Klingon as a spoken language in Great Britain
--remember ILIKE is case insensitive
SELECT * FROM countrylanguage WHERE countrycode = 'USA';--use to spulunk through data


SELECT * FROM countrylanguage WHERE countrycode = 'USA' OR countrycode = 'GBR';

START TRANSACTION;

INSERT INTO countrylanguage (countrycode, language, isofficial, percentage)
VALUES ('USA', 'Klingon', false , 0.1);

SELECT * FROM countrylanguage WHERE countrycode = 'USA' OR countrycode = 'GBR';

INSERT INTO countrylanguage(countrycode, language, isofficial, percentage)
VALUES ('GBR', 'Klingon', true , 0.5);

SELECT * FROM countrylanguage WHERE countrycode = 'USA' OR countrycode = 'GBR';

ROLLBACK;

SELECT * FROM countrylanguage WHERE countrycode = 'USA' OR countrycode = 'GBR';

-- UPDATE

-- 1. Update the capital of the USA to Houston

START TRANSACTION;

SELECT capital,headofstate, * FROM country WHERE code = 'USA';
--SELECT * FROM city WHERE name ILIKE '%HOUSTON%';

UPDATE country SET capital = 3796 WHERE code = 'USA';
UPDATE country SET headofstate = 'Joe Biden' WHERE code = 'USA';

SELECT capital,headofstate, * FROM country WHERE code = 'USA';
ROLLBACK; --if updates what you wanted, change this to COMMIT;
SELECT capital,headofstate, * FROM country WHERE code = 'USA';

-- 2. Update the capital of the USA to Washington DC and the head of state



-- DELETE

-- 1. Delete English as a spoken language in the USA
START TRANSACTION;

SELECT * FROM countrylanguage WHERE countrycode = 'USA';

DELETE FROM countrylanguage WHERE countrycode = 'USA' AND language = 'English';

SELECT * FROM countrylanguage WHERE countrycode = 'USA';

ROLLBACK;

SELECT * FROM countrylanguage WHERE countrycode = 'USA';
-- 2. Delete all occurrences of the Klingon language 


-- REFERENTIAL INTEGRITY

-- 1. Try just adding Elvish to the country language table.

-- 2. Try inserting English as a spoken language in the country ZZZ. What happens?
--cannot insert because ZZZ is not a valid country code there SQL stopped us from inserting b/c no matching country
--to complete, create country called ZZZ then you could insert
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('ZZZ', 'English', true, 50.0);

-- 3. Try deleting the country USA. What happens?
--fails b/c cities in the city table depend on the country table where code = 'USA' 
DELETE FROM country WHERE code = 'USA';


-- CONSTRAINTS

-- 1. Try inserting English as a spoken language in the USA
--this table doesn't allow duplicate entries and since USA is already a value cannot insert another
INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES ('USA', 'English', true, 50.0);

-- 2. Try again. What happens?

-- 3. Let's relocate the USA to the continent - 'Outer Space'
--Outer Space is not a continent & continent restricted
UPDATE country SET continent = 'Outer Space' WHERE code = 'USA';

-- How to view all of the constraints

SELECT * FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS;
SELECT * FROM INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE;
SELECT * FROM INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS;


-- TRANSACTIONS

-- 1. Try deleting all of the rows from the country language table and roll it back.

-- 2. Try updating all of the cities to be in the USA and roll it back

-- 3. Demonstrate two different SQL connections trying to access the same table where one happens to be inside of a transaction but hasn't committed yet.