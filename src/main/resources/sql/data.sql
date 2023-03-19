INSERT INTO hall(id, number_of_seats) VALUES (1, 20);
INSERT INTO hall(id, number_of_seats) VALUES (2, 30);

INSERT INTO film(id, title, year_of_release, age_restriction, description, poster_name) VALUES (1, 'Gei nigers', 1990, 12, 'super description of gei niggers', 'default.jpeg');
INSERT INTO film(id, title, year_of_release, age_restriction, description, poster_name) VALUES (2, 'Gorbataya gora', 1995, 14, 'super description of gorbataya gora', 'default.jpeg');
INSERT INTO film(id, title, year_of_release, age_restriction, description, poster_name) VALUES (3, 'gachimuchi', 1997, 18, 'super description of gachimuchi', 'default.jpeg');

INSERT INTO session(id, hall_id, film_id, date_time, cost) VALUES (1, 1, 1, '2022-12-12', 200);
INSERT INTO session(id, hall_id, film_id, date_time, cost) VALUES (2, 1, 2, '2023-01-12', 250);
INSERT INTO session(id, hall_id, film_id, date_time, cost) VALUES (3, 2, 3, '2023-03-12', 300);