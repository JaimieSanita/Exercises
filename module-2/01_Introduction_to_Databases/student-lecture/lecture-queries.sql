-- SELECT ... FROM
-- Selecting the names for all countries

SELECT name FROM country;

-- Selecting the name and population of all countries

SELECT name, population FROM country;

SELECT population, name FROM country;

-- Selecting all columns from the city table
--NOTE: USE THIS FOR EXPLORATION, NOT FOR YOUR REAL CODE, ALWAYS SELECT COLUMNS BY NAME IN YOUR APPLICATION LOGIC
SELECT * FROM country;

--NOTE: way to build up your query. By putting column before *, will display that column & then rest of code
SELECT name, * FROM country;

-- SELECT ... FROM ... WHERE

SELECT * FROM city;

-- Selecting the cities in Ohio

SELECT * FROM city WHERE district = 'Ohio';

--NOTE: that you do not have to include the column in the SELECT part to filter the rows by a column in the WHERE clause
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
-- population expressed in terms of 1000's therefore divide 5million by 10
SELECT * FROM country WHERE population > 500000;

-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000
-- population numbers are true; no need to divide

SELECT * FROM city WHERE district = 'Ohio' AND population > 400000;

-- Selecting country names on the continent North America or South America

SELECT name FROM country WHERE continent = 'North America' OR continent = 'South America';

--BONUS CONTENT: IN CLAUSE 

SELECT name FROM country WHERE continent IN ('North America', 'South America');


-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword
                                            --only changed for display                          --not a column in provided
SELECT name, population, lifeexpectancy, surfacearea AS "Surface Area", population / surfacearea AS "Population Per Area"
FROM country 
WHERE continent = 'Asia';











