CREATE DATABASE 'projetoorm_persistencia';

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(64) NOT NULL,
    last_access DATETIME,
    active BOOLEAN
);