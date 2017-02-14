DROP TABLE IF EXISTS user;
CREATE TABLE user
  (id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
   login CHAR(25) NOT NULL UNIQUE,
   password CHAR(25) NOT NULL);
INSERT INTO user (login, password)
  VALUES ('admin', 'admin');
INSERT INTO user (login, password)
  VALUES ('tree', 'hole');
INSERT INTO user (login, password)
  VALUES ('home', '123');
