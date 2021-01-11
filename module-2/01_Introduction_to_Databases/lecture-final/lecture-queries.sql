-- SELECT ... FROM
-- Selecting the names for all countries

--       column FROM table
  SELECT name FROM country;
  
  SELECT name
  FROM country;

-- Selecting the name and population of all countries

SELECT name, population FROM country;

SELECT population,name FROM country;


-- Selecting all columns from the city table
-- NOTE: use this for exploration, not for your real code, always select columns by name in your application logic
SELECT * FROM country;


SELECT name, * FROM country;

-- SELECT ... FROM ... WHERE

-- all cities
SELECT * FROM city;

-- Selecting the cities in Ohio

SELECT * FROM city WHERE district = 'Ohio';

-- note that you do not have to include the column in the SELECT part to filter the rows by a column in the WHERE clause
SELECT name FROM city WHERE district = 'Ohio';

-- Selecting countries that gained independence in the year 1776

SELECT * FROM country WHERE indepyear = 1776;

-- Selecting countries not in Asia

SELECT * FROM country WHERE continent <> 'Asia';

-- Selecting countries that do not have an independence year

SELECT * FROM country WHERE indepyear IS NULL;

-- Selecting countries that do have an independence year

SELECT * FROM country WHERE indepyear IS NOT NULL;

-- Selecting countries that have a population greater than 5 million

SELECT * FROM country WHERE population > 500000;

-- SELECT ... FROM ... WHERE ... AND/OR
-- && -> AND     || -> OR

-- Selecting cities in Ohio and Population greater than 400,000
SELECT * FROM city WHERE district = 'Ohio' AND population > 400000;

-- Selecting country names on the continent North America or South America

SELECT name FROM country WHERE continent = 'North America' OR continent = 'South America';

-- Bonus content ... IN 

SELECT name FROM country WHERE continent IN ('North America', 'South America');


-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword

SELECT name, population, lifeexpectancy, surfacearea as "Surface Area" , population / surfacearea AS "Pop per area"
 FROM country
 WHERE continent = 'Asia';


SELECT surfacearea, * from country;













