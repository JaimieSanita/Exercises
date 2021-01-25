SELECT * FROM city ORDER BY id DESC LIMIT 5;
                                                                                                     --after insert, give me back results from what I updated & in this case id
                                                                                                     --useful if row has timestamps, at returning gives back immediately
                                                                                                     --don't need id before, can add after insert
                                                                                                     --RETURNING = SELECT AFTER
INSERT INTO city (name, countrycode, district, population) VALUES ('ExampleTown', 'USA', 'Kansas', 1) RETURNING id; 