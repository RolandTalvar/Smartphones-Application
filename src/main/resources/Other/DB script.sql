DROP TABLE IF EXISTS smartphone;
DROP DATABASE IF EXISTS smartphones;
DROP ROLE IF EXISTS smartphonemanager;

CREATE ROLE smartphonemanager LOGIN PASSWORD 'smartphonepassword';
CREATE DATABASE smartphones WITH OWNER = smartphonemanager;

CREATE TABLE smartphone (
   ID		SERIAL 		PRIMARY KEY,
   name		TEXT		NOT NULL,
   price	INT      	NOT NULL,
   description	TEXT		NOT NULL
);

GRANT ALL PRIVILEGES ON TABLE smartphone TO smartphonemanager;

INSERT INTO smartphone (name, price, description) VALUES ('iPhone SE', 399, 'The most powerful 4-inch smartphone yet.');
INSERT INTO smartphone (name, price, description) VALUES ('Samsung Galaxy S7', 719, 'The fast, powerful, beautiful Galaxy S7 phone is 2016s all-around phone to beat.');
INSERT INTO smartphone (name, price, description) VALUES ('iPhone 6s', 699, 'Next Generation of Multi-Touch Arrives in The Most Advanced iPhones Ever.');
INSERT INTO smartphone (name, price, description) VALUES ('iPhone 6s Plus', 799, 'Next Generation of Multi-Touch Arrives in The Most Advanced iPhones Ever');
INSERT INTO smartphone (name, price, description) VALUES ('Samsung Galaxy S7 Edge', 819, 'The handset comes with a Super AMOLED display of 5.5 inches and, of course, what makes it unique are the curved lateral edges.');