DROP TABLE IF EXISTS tree;

CREATE TABLE tree (
    id INT IDENTITY(1, 1) PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

INSERT INTO tree (name) VALUES
    ('Angry'),
    ('Light'),
    ('Dark'),
    ('Small');