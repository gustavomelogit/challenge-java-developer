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

CREATE TABLE tb_neurotech_client_credit_types (
    client_id BIGINT NOT NULL,
    credit_type VARCHAR(255) NOT NULL,
    PRIMARY KEY (client_id, credit_type),
    CONSTRAINT fk_neurotech_client_credit_types_client_id FOREIGN KEY (client_id) REFERENCES tb_neurotech_client(id)
);