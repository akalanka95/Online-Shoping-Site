CREATE TABLE Category(

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(150),
	image_url VARCHAR(150),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY(id)

);


INSERT INTO Category(name,description,image_url,is_active) VALUES('DRUMS','THIS IS ALL ABOUT DRUMS','rum.png',true);
INSERT INTO Category(name,description,image_url,is_active) VALUES('PIANO','THIS IS ALL ABOUT DRUMS','rum.png',true);
INSERT INTO Category(name,description,image_url,is_active) VALUES('GUITAR','THIS IS ALL ABOUT DRUMS','rum.png',true);

CREATE TABLE user_detail(

	id IDENTITY,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(150),
	contactnumber Varchar(50),
	CONSTRAINT pk_user_detail_id PRIMARY KEY(id)

);


INSERT INTO user_detail
(firstname,lastname,role,enabled,password,email,contactnumber) 
VALUES('Akalanka','gamage','ADMIN',true,'admin','akalankamaduka95@gmail.com','07676767');

INSERT INTO user_detail
(firstname,lastname,role,enabled,password,email,contactnumber) 
VALUES('vimukthi','gaamage','SUPPLIER',true,'sup','akalankaaamaduka95@gmail.com','0763376767');

INSERT INTO user_detail
(firstname,lastname,role,enabled,password,email,contactnumber) 
VALUES('Dilan','Chathuranga','SUPPLIER',true,'sup','akalankaaamaduka95@gmail.com','0763376767');



CREATE TABLE products(

	id IDENTITY,
	code VARCHAR(50),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(150),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY(id),
	CONSTRAINT fk_product_category_id FOREIGN KEY(category_id) REFERENCES Category(id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY(supplier_id) REFERENCES user_detail(id)
);


INSERT INTO products
(code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id) 
VALUES('PDX123456','Drum2','Roland','best drum', 123.34,5,true,2,2);


