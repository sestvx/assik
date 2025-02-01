CREATE TABLE jobs (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    description TEXT
);

CREATE TABLE freelancers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    skills TEXT
);ALTER TABLE freelancers
ALTER COLUMN email DROP NOT NULL;
