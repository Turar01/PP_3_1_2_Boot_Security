/*CREATE TABLE roles (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL
);

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       age INT,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE users_roles (
                             user_id INT,
                             role_id INT,
                             PRIMARY KEY (user_id, role_id),
                             FOREIGN KEY (user_id) REFERENCES users(id),
                             FOREIGN KEY (role_id) REFERENCES roles(id)
);*/

INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');

INSERT INTO users (username, age, password) VALUES ('admin', 30, '$2a$10$fdW3PN2lANRUILHnuO9Qvuvp62f9nmykStbe3meGNf58g3K5zmdWG');
INSERT INTO users (username, age, password) VALUES ('user', 25, '$2a$10$82lOWwxJ2cE9E5Y5KalC1.LvtL23VblLAbNuME5XArZrscU7Os/M.');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);

