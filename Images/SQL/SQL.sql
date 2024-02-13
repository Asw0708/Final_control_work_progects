-- создадим базу данных по заданию
DROP DATABASE IF EXISTS HumanFriends;
CREATE DATABASE IF NOT EXISTS HumanFriends;

-- выберем созданную базу данных
USE HumanFriends;

-- создадим таблицу 
DROP TABLE IF EXISTS Category;
CREATE TABLE IF NOT EXISTS Category(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(45)
);

-- заполним таблицу соответствующими классами
INSERT INTO Category(name)
VALUES
    ('Pets'),
    ('Pack Animals');

-- выведем все значения таблицы с классами
SELECT * FROM HumanFriends.Category;

-- создадим таблицу Types и сделаем связь с таблицей Category
DROP TABLE IF EXISTS Types;
CREATE TABLE IF NOT EXISTS Types(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(45),
    category_id INT,
    CONSTRAINT fk_category FOREIGN KEY(category_id) REFERENCES Category(id)
);

-- заполним таблицу Types
INSERT INTO Types(name, category_id)
VALUES
    ('Пёс', 1),
    ('Кот', 1),
    ('Суслик', 1),
    ('Лошадь', 2),
    ('Верблюд', 2),
    ('Осёл', 2);  
    
-- выведем все значения таблицы Types
SELECT * FROM HumanFriends.Types;

-- создадим таблицу Animals и сделаем связь с таблицей Types
DROP TABLE IF EXISTS Animals;
CREATE TABLE IF NOT EXISTS Animals(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(45),
    type_id int,
    birthday DATE,
    CONSTRAINT fk_type Foreign Key (type_id) REFERENCES Types(id)
);

-- заполним таблицу Animals
INSERT INTO Animals(name, type_id, birthday)
VALUES
	('Fido', 1, '2020-01-01'),
    ('Whiskers', 2, '2019-05-15'),
    ('Hammy', 3, '2021-03-10'),
    ('Buddy', 1, '2018-12-10'),
    ('Smudge', 2, '2020-02-20'),
    ('Peanut', 3, '2021-08-01'),
    ('Bella', 1, '2019-11-11'),
    ('Oliver', 2, '2020-06-30'),
    ('Thunder', 4, '2015-07-21'),
    ('Sandy', 5, '2016-11-03'),
    ('Eeyore', 6, '2017-09-18'),
    ('Storm', 4, '2014-05-05'),
    ('Dune', 5, '2018-12-12'),
    ('Burro', 6, '2019-01-23'),
    ('Blaze', 4, '2016-02-29'),
    ('Sahara', 5, '2015-08-14');

-- выведем все значения таблицы Animals
SELECT * FROM HumanFriends.Animals;

-- создадим таблицу Commands и сделаем связь с таблицей Animals
DROP TABLE IF EXISTS Commands;
CREATE TABLE IF NOT EXISTS Commands(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(45),
    animal_id int,
    CONSTRAINT fk_animal Foreign Key (animal_id) REFERENCES Animals(id)
);

-- заполним таблицу Commands
INSERT INTO Commands(name, animal_id)
VALUES 
    ('Сидеть', 1), ('Место', 1), ('Аппорт', 1),
    ('Сидеть', 2), ('Наброситься', 2),
    ('Свернуть', 3), ('Спрятаться', 3),
    ('Сидеть', 4), ('Дать лапу', 4), ('Голос', 4),
    ('Сидеть', 5), ('Наброситься', 5), ('Царапаться', 5),
    ('Катиться', 6), ('Крутиться', 6),
    ('Сидеть', 7), ('Стоять', 7), ('Свернуть', 7),
    ('Мяукать', 8), ('Царапаться', 8), ('Прыгать', 8),
	('Рысь', 9), ('Лёгкий галоп', 9), ('Галоп', 9),
    ('Ходить', 10), ('Нести груз', 10),
    ('Ходить', 11), ('Нести  груз', 11), ('Подавать голос', 11),
    ('Рысь', 12), ('Лёгкий галоп', 12),
    ('Ходить', 13), ('Сидеть', 13),
    ('Ходить', 14), ('Подавать голос', 14), ('Лягаться', 14),
    ('Рысь', 15), ('Прыжок', 15), ('Галоп', 15),
    ('Ходить', 16), ('Бежать', 16);
    
-- выведем все значения таблицы Commands
SELECT * FROM HumanFriends.Commands;

-- создадим виртуальную таблицу, которая объединяет таблицы Category, Types, Animals, Commands и выбирает только лошадей и ослов
CREATE VIEW CompoundAnimalsWithCommands AS
SELECT 
    a.id,
    a.name,
    a.birthday,
    t.name AS animal_type,
    c.name AS category,
    GROUP_CONCAT(c.name ORDER BY c.name ASC SEPARATOR ', ') AS concatenated_commands
FROM Animals AS a
LEFT JOIN Types AS t ON t.id = a.type_id
JOIN Category AS c ON t.category_id = c.id
LEFT JOIN Commands AS cm ON cm.animal_id = a.id
WHERE c.name = 'Pack Animals' AND (t.name = 'Лошадь' OR t.name = 'Верблюд')
GROUP BY a.id, a.name, a.birthday, t.name, c.name;

-- выполним команду CompoundAnimalsWithCommands
SELECT * FROM compoundanimalswithcommands;

-- создадим виртуальную таблицу, которая объединяет таблицы Types, Animals, Category и выберет возраст животных от 1 до 3 лет
CREATE VIEW AnimalsWithAgeFrom1To3 AS
SELECT
    a.name,
    a.birthday,
    t.name AS animal_type,
    c.name AS category,
    CONCAT(
        TIMESTAMPDIFF(YEAR, a.birthday, CURDATE()),
        ' years ',
        TIMESTAMPDIFF(MONTH, a.birthday, CURDATE()) % 12,
        ' months'
    ) AS age
FROM Animals as a
LEFT JOIN Types AS t ON t.id = a.type_id
JOIN Category AS c ON t.category_id = c.id
WHERE TIMESTAMPDIFF(YEAR, a.birthday, CURDATE()) BETWEEN 1 AND 3;

-- выполним команду CompoundAnimalsWithCommands
SELECT * FROM humanfriends.AnimalsWithAgeFrom1To3;

-- выведем объединённую таблицу
SELECT 
    a.id,
    a.name,
    CONCAT(
        TIMESTAMPDIFF(YEAR, a.birthday, CURDATE()),
        ' years ',
        TIMESTAMPDIFF(MONTH, a.birthday, CURDATE()) % 12,
        ' months'
    ) AS age,
    t.name AS animal_type,
    c.name AS category,
    GROUP_CONCAT(c.name ORDER BY c.name ASC SEPARATOR ', ') AS concatenated_commands
FROM Animals AS a
LEFT JOIN Types AS t ON t.id = a.type_id
JOIN Category AS c ON t.category_id = c.id
LEFT JOIN Commands AS cm ON cm.animal_id = a.id
GROUP BY a.id, a.name, a.birthday, t.name, c.name
ORDER BY age;