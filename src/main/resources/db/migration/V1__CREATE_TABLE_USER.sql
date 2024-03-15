CREATE TABLE IF NOT EXISTS user (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS role (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
    );

INSERT INTO role (name) VALUES
    ('MYRENT'),
    ('BUSINESS'),
    ('LANDLORD'),
    ('TENANT');















