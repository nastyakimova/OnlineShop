DELETE FROM users
DELETE FROM authorities
INSERT INTO users(username, enabled, password) VALUES ('admin',TRUE ,'admin')
INSERT INTO authorities(id, authority, username) VALUES ('1','admin','admin')