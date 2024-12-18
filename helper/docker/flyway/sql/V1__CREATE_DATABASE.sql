----- Drop tables -----
DROP TABLE IF EXISTS tb_neurotech_client CASCADE;

---- Create tables ----

CREATE TABLE tb_neurotech_client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    age INTEGER NOT NULL,
    income  DECIMAL(15, 2) NOT NULL,
    version INTEGER NOT NULL
);