INSERT INTO roles (role)
VALUES ('ADMIN');
INSERT INTO roles (role)
VALUES ('USER');

INSERT INTO users (created_at, email, password, user_name)
VALUES (NOW(), 'email1@email.com', 'pwd1', 'user1');

INSERT INTO users (created_at, email, password, user_name)
VALUES (NOW(), 'email2@email.com', 'pwd2', 'user2');

INSERT INTO users (created_at, email, password, user_name)
VALUES (NOW(), 'email3@email.com', 'pwd3', 'user3');