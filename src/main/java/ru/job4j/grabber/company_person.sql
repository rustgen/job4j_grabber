create TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

create TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company (id, name) values (1, 'Uniti Group Inc.');
insert into company (id, name) values (2, 'Red Robin Gourmet Burgers, Inc.');
insert into company (id, name) values (3, 'Huntsman Corporation');
insert into company (id, name) values (4, 'ENSCO plc');
insert into company (id, name) values (5, 'Reinsurance Group of America, Incorporated');
insert into company (id, name) values (6, 'Global Partner Acquisition Corp.');
insert into company (id, name) values (7, 'Carter''s, Inc.');
insert into company (id, name) values (8, 'NMI Holdings Inc');
insert into company (id, name) values (9, 'Genius Brands International, Inc.');
insert into company (id, name) values (10, 'Yangtze River Development Limited');
insert into company (id, name) values (11, 'Capstead Mortgage Corporation');
insert into company (id, name) values (12, 'ProShares Ultra Nasdaq Biotechnology');
insert into company (id, name) values (13, 'Capella Education Company');
insert into company (id, name) values (14, 'PDF Solutions, Inc.');
insert into company (id, name) values (15, 'USLIFE Income Fund, Inc.');


insert into person (id, name, company_id) values (1, 'Adrea', 11);
insert into person (id, name, company_id) values (2, 'Haze', 1);
insert into person (id, name, company_id) values (3, 'Patten', 7);
insert into person (id, name, company_id) values (4, 'Modesta', 9);
insert into person (id, name, company_id) values (5, 'Hailee', 15);
insert into person (id, name, company_id) values (6, 'Helaina', 3);
insert into person (id, name, company_id) values (7, 'Skye', 2);
insert into person (id, name, company_id) values (8, 'Risa', 14);
insert into person (id, name, company_id) values (9, 'Felipa', 5);
insert into person (id, name, company_id) values (10, 'Hunfredo', 5);
insert into person (id, name, company_id) values (11, 'Mal', 10);
insert into person (id, name, company_id) values (12, 'Ursala', 13);
insert into person (id, name, company_id) values (13, 'Catlee', 7);
insert into person (id, name, company_id) values (14, 'Yorke', 5);
insert into person (id, name, company_id) values (15, 'Daryl', 3);
insert into person (id, name, company_id) values (16, 'Leroi', 13);
insert into person (id, name, company_id) values (17, 'Zedekiah', 4);
insert into person (id, name, company_id) values (18, 'Sharity', 12);
insert into person (id, name, company_id) values (19, 'Jarib', 3);
insert into person (id, name, company_id) values (20, 'Vonny', 8);
insert into person (id, name, company_id) values (21, 'Bone', 13);
insert into person (id, name, company_id) values (22, 'Marabel', 2);
insert into person (id, name, company_id) values (23, 'Oswell', 9);
insert into person (id, name, company_id) values (24, 'Jim', 11);
insert into person (id, name, company_id) values (25, 'Heriberto', 15);
insert into person (id, name, company_id) values (26, 'Siana', 8);
insert into person (id, name, company_id) values (27, 'Ingelbert', 7);
insert into person (id, name, company_id) values (28, 'Marketa', 14);
insert into person (id, name, company_id) values (29, 'Bernard', 4);
insert into person (id, name, company_id) values (30, 'Jareb', 5);
insert into person (id, name, company_id) values (31, 'Anna-diane', 14);
insert into person (id, name, company_id) values (32, 'Orelle', 10);
insert into person (id, name, company_id) values (33, 'Ingrid', 3);
insert into person (id, name, company_id) values (34, 'Francoise', 1);
insert into person (id, name, company_id) values (35, 'Adina', 4);
insert into person (id, name, company_id) values (36, 'Chad', 14);
insert into person (id, name, company_id) values (37, 'Maure', 10);
insert into person (id, name, company_id) values (38, 'Adoree', 12);
insert into person (id, name, company_id) values (39, 'Thorin', 10);
insert into person (id, name, company_id) values (40, 'Clio', 2);
insert into person (id, name, company_id) values (41, 'Lesli', 7);
insert into person (id, name, company_id) values (42, 'Rochell', 15);
insert into person (id, name, company_id) values (43, 'Audra', 13);
insert into person (id, name, company_id) values (44, 'Isidor', 3);
insert into person (id, name, company_id) values (45, 'Tuckie', 10);
insert into person (id, name, company_id) values (46, 'Maximilien', 2);
insert into person (id, name, company_id) values (47, 'Shani', 1);
insert into person (id, name, company_id) values (48, 'Rubie', 10);
insert into person (id, name, company_id) values (49, 'Tiffi', 11);
insert into person (id, name, company_id) values (50, 'Saree', 2);
insert into person (id, name, company_id) values (51, 'Lennie', 1);
insert into person (id, name, company_id) values (52, 'Orv', 3);
insert into person (id, name, company_id) values (53, 'Dermot', 9);
insert into person (id, name, company_id) values (54, 'Cathi', 7);
insert into person (id, name, company_id) values (55, 'Kerwin', 15);
insert into person (id, name, company_id) values (56, 'Gerladina', 8);
insert into person (id, name, company_id) values (57, 'Patty', 2);
insert into person (id, name, company_id) values (58, 'Kristy', 13);
insert into person (id, name, company_id) values (59, 'Jena', 12);
insert into person (id, name, company_id) values (60, 'Odo', 2);
insert into person (id, name, company_id) values (61, 'Maximilian', 11);
insert into person (id, name, company_id) values (62, 'Morgun', 11);
insert into person (id, name, company_id) values (63, 'Jami', 2);
insert into person (id, name, company_id) values (64, 'Danyette', 8);
insert into person (id, name, company_id) values (65, 'Eudora', 15);
insert into person (id, name, company_id) values (66, 'Syman', 2);
insert into person (id, name, company_id) values (67, 'Horacio', 8);
insert into person (id, name, company_id) values (68, 'Dido', 2);
insert into person (id, name, company_id) values (69, 'Rustie', 12);
insert into person (id, name, company_id) values (70, 'Micah', 4);
insert into person (id, name, company_id) values (71, 'Boony', 5);
insert into person (id, name, company_id) values (72, 'Bell', 6);
insert into person (id, name, company_id) values (73, 'Allx', 13);
insert into person (id, name, company_id) values (74, 'Esmaria', 4);
insert into person (id, name, company_id) values (75, 'Susie', 4);
insert into person (id, name, company_id) values (76, 'Willette', 15);
insert into person (id, name, company_id) values (77, 'Bevvy', 11);
insert into person (id, name, company_id) values (78, 'Holt', 12);
insert into person (id, name, company_id) values (79, 'Alric', 4);
insert into person (id, name, company_id) values (80, 'Rafaellle', 13);
insert into person (id, name, company_id) values (81, 'Emylee', 14);
insert into person (id, name, company_id) values (82, 'Ahmad', 12);
insert into person (id, name, company_id) values (83, 'Henriette', 11);
insert into person (id, name, company_id) values (84, 'Cornie', 15);
insert into person (id, name, company_id) values (85, 'Eddy', 15);
insert into person (id, name, company_id) values (86, 'Putnam', 3);
insert into person (id, name, company_id) values (87, 'Nadine', 14);
insert into person (id, name, company_id) values (88, 'Jackqueline', 3);
insert into person (id, name, company_id) values (89, 'Carey', 4);
insert into person (id, name, company_id) values (90, 'Jorge', 2);
insert into person (id, name, company_id) values (91, 'Daryle', 3);
insert into person (id, name, company_id) values (92, 'Dominga', 6);
insert into person (id, name, company_id) values (93, 'Eddie', 8);
insert into person (id, name, company_id) values (94, 'Modesta', 10);
insert into person (id, name, company_id) values (95, 'Manon', 10);
insert into person (id, name, company_id) values (96, 'Jed', 7);
insert into person (id, name, company_id) values (97, 'Farly', 15);
insert into person (id, name, company_id) values (98, 'Desi', 5);
insert into person (id, name, company_id) values (99, 'Wyn', 1);
insert into person (id, name, company_id) values (100, 'Nana', 9);
insert into person (id, name, company_id) values (101, 'Keriann', 13);
insert into person (id, name, company_id) values (102, 'Elton', 1);
insert into person (id, name, company_id) values (103, 'Marcy', 5);
insert into person (id, name, company_id) values (104, 'Bendick', 12);
insert into person (id, name, company_id) values (105, 'Demetria', 14);
insert into person (id, name, company_id) values (106, 'Lucretia', 8);
insert into person (id, name, company_id) values (107, 'Lucas', 15);
insert into person (id, name, company_id) values (108, 'Claribel', 13);
insert into person (id, name, company_id) values (109, 'Kevina', 3);
insert into person (id, name, company_id) values (110, 'Shirlee', 14);
insert into person (id, name, company_id) values (111, 'Perla', 10);
insert into person (id, name, company_id) values (112, 'Alexio', 4);
insert into person (id, name, company_id) values (113, 'Byrom', 5);
insert into person (id, name, company_id) values (114, 'Charity', 3);
insert into person (id, name, company_id) values (115, 'Tracey', 5);
insert into person (id, name, company_id) values (116, 'Warden', 15);
insert into person (id, name, company_id) values (117, 'Nevil', 3);
insert into person (id, name, company_id) values (118, 'Flori', 1);
insert into person (id, name, company_id) values (119, 'Kennith', 2);
insert into person (id, name, company_id) values (120, 'Calli', 11);
insert into person (id, name, company_id) values (121, 'Pavla', 14);
insert into person (id, name, company_id) values (122, 'Cody', 12);
insert into person (id, name, company_id) values (123, 'Averil', 12);
insert into person (id, name, company_id) values (124, 'Vidovic', 7);
insert into person (id, name, company_id) values (125, 'Tani', 15);
insert into person (id, name, company_id) values (126, 'Trenna', 13);
insert into person (id, name, company_id) values (127, 'Aili', 15);
insert into person (id, name, company_id) values (128, 'Evelina', 10);
insert into person (id, name, company_id) values (129, 'Buck', 13);
insert into person (id, name, company_id) values (130, 'Leila', 8);
insert into person (id, name, company_id) values (131, 'Tiphani', 4);
insert into person (id, name, company_id) values (132, 'Bartholomew', 9);
insert into person (id, name, company_id) values (133, 'Averil', 8);
insert into person (id, name, company_id) values (134, 'Trenton', 10);
insert into person (id, name, company_id) values (135, 'Dasya', 7);
insert into person (id, name, company_id) values (136, 'Jillane', 7);
insert into person (id, name, company_id) values (137, 'Sterling', 6);
insert into person (id, name, company_id) values (138, 'Allix', 13);
insert into person (id, name, company_id) values (139, 'Davidson', 6);
insert into person (id, name, company_id) values (140, 'Gweneth', 9);
insert into person (id, name, company_id) values (141, 'Birgit', 1);
insert into person (id, name, company_id) values (142, 'Cherri', 3);
insert into person (id, name, company_id) values (143, 'Kendrick', 15);
insert into person (id, name, company_id) values (144, 'Gino', 3);
insert into person (id, name, company_id) values (145, 'Doralynne', 8);
insert into person (id, name, company_id) values (146, 'Melody', 10);
insert into person (id, name, company_id) values (147, 'Georgine', 15);
insert into person (id, name, company_id) values (148, 'Meridith', 4);
insert into person (id, name, company_id) values (149, 'Zackariah', 11);
insert into person (id, name, company_id) values (150, 'Michaella', 14);

-- 1. имена всех person, которые не состоят в компании с id = 5
-- название компании для каждого человека
SELECT person.name AS person_name,
company.name AS company
FROM person INNER JOIN Company
ON person.company_id = company.id
WHERE company_id != 5;

-- 2. Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании
-- нужно учесть, что таких компаний может быть несколько, и вывести надо информацию о каждой компании
--SELECT c.name company, COUNT(p.company_id) num
--FROM person p
--JOIN company c ON p.company_id = c.id
--GROUP BY c.name
--ORDER BY num DESC
--   same
--select c.*, (
--select COUNT(p.company_id) from person p
--   where p.company_id = c.id
--) from company c

SELECT c.name company, COUNT(p.company_id) num
FROM person p
JOIN company c ON p.company_id = c.id
GROUP BY c.name
HAVING COUNT(p.company_id) = (
    SELECT COUNT(*) FROM person p
    GROUP BY company_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
)
