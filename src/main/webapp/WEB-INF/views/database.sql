CREATE TABLE categorydb(
category_id varchar(5) PRIMARY KEY,
category_name varchar(20),
is_active tinyint(5)
);
CREATE TABLE itemsdb(
item_id VARCHAR(10) PRIMARY KEY,
item_name VARCHAR(30),
item_price FLOAT(7,2),
category_id VARCHAR(5)REFERENCES categorydb);


insert into categorydb values (1, 'Mobile',1);
insert into categorydb values (2, 'Laptop',1);
insert into categorydb values (3, 'Speaker',1);

insert into itemsdb values (1, 'Oneplus X',30012.40,1);