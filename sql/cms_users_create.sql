CREATE TABLE cms_users
(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  login VARCHAR(40) NOT NULL,
  password VARCHAR(100) NOT NULL,
  first_name VARCHAR(40),
  middle_name VARCHAR(40),
  last_name VARCHAR(40),
  role_id INT NOT NULL,
  active CHAR(1),
  FOREIGN KEY (role_id) REFERENCES cms_roles (id)
);