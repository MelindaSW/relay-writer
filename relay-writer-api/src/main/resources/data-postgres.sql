INSERT INTO roles (role, description)
VALUES ('ADMIN', 'User with administrative rights and access to all of the api.');

INSERT INTO roles (role, description)
VALUES ('USER', 'User with limited access to the api.');

INSERT INTO users (created_at, email, password, user_name)
VALUES (NOW(), 'admin@email.com', 'admin', 'Administrator');

INSERT INTO users (created_at, email, password, user_name)
VALUES (NOW(), 'email2@email.com', 'pwd2', 'user2');

INSERT INTO users (created_at, email, password, user_name)
VALUES (NOW(), 'email3@email.com', 'pwd3', 'user3');

INSERT INTO users_roles (users_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (users_id, roles_id)
VALUES (2, 2);

INSERT INTO stories (created_at, description, title, user_id)
VALUES (NOW(), 'A short description of the story', 'Awesome story title', 1);

INSERT INTO stories (created_at, description, title, user_id)
VALUES (NOW(), 'A short description of the story', 'Awesome story title', 2);

INSERT INTO snippets (author, created_at, snippet, story_id)
VALUES ('User1', NOW(), 'Lorem ipsum dolor sit amet and so on...', 1);

INSERT INTO snippets (author, created_at, snippet, story_id)
VALUES ('User2', NOW(), 'Lorem ipsum dolor sit amet and so on...', 2);

INSERT INTO snippets (author, created_at, snippet, story_id)
VALUES ('User2', NOW(), 'Lorem ipsum dolor sit amet and so on...', 1);

INSERT INTO snippets (author, created_at, snippet, story_id)
VALUES ('User1', NOW(), 'Lorem ipsum dolor sit amet and so on...', 2);