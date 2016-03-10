INSERT INTO users (username, enabled, password)
VALUES ('admin', TRUE, '$2a$10$/usmqklkr2iQFWg8hKXyf.C8gD6/vZdnSvpSBAvqgXhfC0YIjGJ/C');
INSERT INTO users (username, enabled, password)
VALUES ('user', TRUE, '$2a$10$0oYdTjFdnfTzWXmVL7Y4BudV5mw0DvrPhOPKJ4tqi4MkVtX8KIlra');
INSERT INTO authorities (id, authority, username) VALUES ('1', 'admin', 'admin');
INSERT INTO authorities (id, authority, username) VALUES ('2', 'user', 'user');
INSERT INTO products (price, title) VALUES ('0.99', 'Item-1'), ('0.99', 'Item-2'), ('0.99', 'Item-3'), ('0.99', 'Item-4'), ('0.99', 'Item-5'),('0.99', 'Item-6'), ('0.99', 'Item-7'), ('0.99', 'Item-8'), ('0.99', 'Item-9'),('0.99', 'Item-10'), ('0.99', 'Item-11'), ('0.99', 'Item-12');

