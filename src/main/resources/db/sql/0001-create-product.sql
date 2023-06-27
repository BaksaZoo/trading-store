-- liquibase formatted sql

-- changeset liquibase:1
CREATE TABLE product (
  id SERIAL PRIMARY KEY,
  title VARCHAR(30) NOT NULL,
  description VARCHAR(255) NULL,
  image_url VARCHAR(150),
  price NUMERIC(12, 3)
);