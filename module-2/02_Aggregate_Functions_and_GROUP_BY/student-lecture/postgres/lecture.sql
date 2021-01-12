-- ORDERING RESULTS

-- Populations of all countries in descending order
                             --ORDER BY takes a comma separated list of columns
SELECT population FROM country ORDER BY population DESC;

--Names of countries and continents in ascending order

SELECT name, continent FROM country ORDER BY name, continent ASC;

--we can use multiple ORDER BY clauses(use to sort users with duplicate name, allows differentiation)

SELECT name, gnp, continent FROM country WHERE continent LIKE '%Amer%' ORDER BY continent ASC, gnp DESC;

-- LIMITING RESULTS
-- The name and average life expectancy of the countries with the 10 highest life expectancies.
--need WHERE clause to exclude null                                                                     -different DB have alt ways of expressing LIMIT. MSSQL uses SELECT TOP # name...
SELECT name, lifeexpectancy FROM country WHERE lifeexpectancy IS NOT NULL ORDER BY lifeexpectancy DESC LIMIT 10;

-- CONCATENATING OUTPUTS

-- The name & state of all cities in California, Oregon, or Washington.
-- "city, state", sorted by state then city

SELECT (name || ', '|| district) AS "name_and_state"
FROM city 
WHERE district IN( 'California' , 'Oregon' , 'Washington' ) 
ORDER BY district, name;



-- AGGREGATE FUNCTIONS
-- Average Life Expectancy in the World

SELECT AVG(lifeexpectancy) AS "Avg Life Expectancy in the World" FROM country ;

-- Total population in Ohio

SELECT SUM(population) AS "Total Pop in Ohio" FROM city WHERE district = 'Ohio';

-- The surface area of the smallest country in the world

SELECT MIN(surfacearea) FROM country;

SELECT name, surfacearea FROM country ORDER BY surfacearea ASC LIMIT 1;

SELECT MAX(surfacearea) FROM country;

-- The 10 largest countries in the world

SELECT name, surfacearea
FROM country
ORDER BY surfacearea DESC
LIMIT 10;

-- The number of countries who declared independence in 1991

SELECT COUNT(*) FROM country WHERE indepyear = 1991;

SELECT COUNT(*) AS "Number of Cities" FROM city;

-- GROUP BY
-- Count the number of countries where each language is spoken, ordered from most countries to least

SELECT language, COUNT(countrycode) AS "Country Count" 
FROM countrylanguage 
GROUP BY language 
ORDER BY "Country Count" DESC;

-- Average life expectancy of each continent ordered from highest to lowest


SELECT continent, AVG(lifeexpectancy) AS "AVG LE" 
FROM country 
GROUP BY continent 
ORDER BY "AVG LE" DESC;

-- Exclude Antarctica from consideration for average life expectancy
--multiple aggregate functions
SELECT continent, AVG(lifeexpectancy) AS "AVG LE", MAX(lifeexpectancy) AS "Max LE", COUNT (code) AS "Number of Countries"
FROM country 
WHERE continent <> 'Antarctica' 
GROUP BY continent 
ORDER BY "AVG LE" DESC;

-- Sum of the population of cities in each state in the USA ordered by state name

SELECT * FROM city;

SELECT district AS "State", SUM(population) AS "Total Pop"
FROM city 
WHERE countrycode = 'USA' 
GROUP BY district
ORDER BY district ASC;

-- The average population of cities in each state in the USA ordered by state name

SELECT district, AVG(population) AS "AVG POPULATION" 
FROM city 
WHERE countrycode = 'USA' 
GROUP BY district 
ORDER BY district ASC;

-- SUBQUERIES
-- Find the names of cities under a given government leader(2 TABLES ARE IN PLAY HERE)
--IN(NEW QUERY WITH SELECT, FROM ETC clauses)
SELECT name 
FROM city
WHERE countrycode IN 
        (SELECT code 
         FROM country 
         WHERE headofstate LIKE '%George W%');


-- Find the names of cities whose country they belong to has not declared independence yet

SELECT * FROM city;
SELECT * FROM country;

SELECT name
FROM city
WHERE countrycode IN 
        (SELECT code 
         FROM country 
         WHERE indepyear IS NULL);
         


-- Additional samples
-- You may alias column and table names to be more descriptive

-- Alias can also be used to create shorthand references, such as "c" for city and "co" for country.

-- Ordering allows columns to be displayed in ascending order, or descending order (Look at Arlington)

-- Limiting results allows rows to be returned in 'limited' clusters,where LIMIT says how many, and OFFSET (optional) specifies the number of rows to skip

-- Most database platforms provide string functions that can be useful for working with string data. In addition to string functions, string concatenation is also usually supported, which allows us to build complete sentences if necessary.

-- Aggregate functions provide the ability to COUNT, SUM, and AVG, as well as determine MIN and MAX. Only returns a single row of value(s) unless used with GROUP BY.

-- Counts the number of rows in the city table

-- Also counts the number of rows in the city table

-- Gets the SUM of the population field in the city table, as well as
-- the AVG population, and a COUNT of the total number of rows.

-- Gets the MIN population and the MAX population from the city table.

-- Using a GROUP BY with aggregate functions allows us to summarize information for a specific column. For instance, we are able to determine the MIN and MAX population for each countrycode in the city table.
