-- DDL : Data Definitional Language
--	IT allows to manage our table structures.
-- CREATE
-- ALTER 
-- DROP
-- TRUNCATE 


-- What is a table?
-- 	Columns and Rows 
--	Column defines what we can store, if you have 3 columns, then each "data "
--		can store 3 things about it. 
--	Row/Record will be a "instance" of data 


--Creating a table!
create table basic_table(); 

-- I have no information in the table 
-- BUT I have no columns! So I can't even put any data in. 

--Creating a useful table 
create table useful_table(
	first_column character(4)
	);

drop table if exists fully_fleshed_table;

--Creating a table with data and constraints 
create table fully_fleshed_table(
	first_column varchar(30) not null,
	second_column integer unique not null, 
	third_column integer, --column with no constraints
	CHECK(second_column > 0), --table constraints
	CHECK(third_column > -10),
	CHECK(second_column > third_column)
);

--ALTER table 
-- modified the first column from character to varchar 
alter table useful_table alter first_column set data type varchar;



--Removing a table from the database
drop table useful_table;

--Remove the data from the table but keep the table itself.
truncate table useful_table;
truncate table fruits;

	
--DML commands below: 
--to insert data
insert into useful_table values('ap                   ');

--to view data
select * from uSeFUL_TabLe; --sql is not capital sensitive, hence we use _






