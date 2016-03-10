INSERT INTO users(username, enabled, password) VALUES ('admin',TRUE ,'$2a$10$/usmqklkr2iQFWg8hKXyf.C8gD6/vZdnSvpSBAvqgXhfC0YIjGJ/C');
INSERT INTO users(username, enabled, password) VALUES ('user',TRUE ,'$2a$10$0oYdTjFdnfTzWXmVL7Y4BudV5mw0DvrPhOPKJ4tqi4MkVtX8KIlra');
INSERT INTO authorities(id, authority, username) VALUES ('1','admin','admin');
INSERT INTO authorities(id, authority, username) VALUES ('2','user','user');

