INSERT INTO users (username, enabled, password) VALUES ('admin', TRUE, '$2a$10$/usmqklkr2iQFWg8hKXyf.C8gD6/vZdnSvpSBAvqgXhfC0YIjGJ/C');
INSERT INTO users(username, enabled, password) VALUES ('user',TRUE ,'$2a$10$6VychsX/nuBTvnb0viqypu8ZDjAdE9XXEMhBPIQtmDZiisrbNamQC');
INSERT INTO authorities (authority, username) VALUES ('admin', 'admin');
INSERT INTO authorities (authority, username) VALUES ('user', 'user');
INSERT INTO customers (email,isLocked,password,name) VALUES ('user',FALSE ,'$2a$10$6VychsX/nuBTvnb0viqypu8ZDjAdE9XXEMhBPIQtmDZiisrbNamQC','user');
INSERT INTO products (price, title) VALUES ('0.99', 'Item-1'), ('0.99', 'Item-2'), ('0.99', 'Item-3'), ('0.99', 'Item-4'), ('0.99', 'Item-5'),('0.99', 'Item-6'), ('0.99', 'Item-7'), ('0.99', 'Item-8'), ('0.99', 'Item-9'),('0.99', 'Item-10'), ('0.99', 'Item-11'), ('0.99', 'Item-12');
