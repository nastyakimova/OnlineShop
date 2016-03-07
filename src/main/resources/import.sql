DELETE FROM users;
DELETE FROM authorities;
DELETE FROM products;
INSERT INTO users(username, enabled, password) VALUES ('admin',TRUE ,'admin');
INSERT INTO authorities(id, authority, username) VALUES ('1','admin','admin');
INSERT INTO products(product_id,price,title) VALUES ('1','0.99','1'),('2','0.99','2'),('3','0.99','3'),('4','0.99','4'),
('5','0.99','5'),('6','0.99','6'),('7','0.99','7'),('8','0.99','8'),('9','0.99','9'),('10','0.99','10'),
('11','0.99','11'),('12','0.99','12');