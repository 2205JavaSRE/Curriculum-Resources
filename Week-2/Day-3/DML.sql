--DML:
-- Data Manipulation Language
-- These are the commands to manipulate the data in the tables. 
-- INSERT 
-- SELECT 
-- UPDATE 
-- DELETE


---- Let's create a example table to manipulate data in it. 

create table fruits(
	fruit_id int primary key,
	fruit_name varchar(20) not null,
	is_berry boolean,
	calories float8 CHECK(calories > 0)
);


-- INSERT 
insert into fruits values (1,'Apple',false,50);

insert into fruits values 
	(2, 'Kiwi', false,60),
	(3, 'Strawberry',true,50),
	(4, 'Banana',false,100);

insert into fruits (fruit_name,fruit_id,calories) values ('blueberry',5,50);
insert into fruits (fruit_name,fruit_id) values ('dragon fruit',6);

insert into fruits values (7, 'Watermelon');
insert into fruits values(8,'Raspberry',null,11); --this will violate the constraints


--UPDATE 
update fruits set is_berry = true;

update fruits set is_berry = true where fruit_name = 'blueberry';

--DELETE
delete from fruits where calories < 60;

-- SELECT 
select * from fruits;
select fruit_name from fruits; --selecting all the fruits, but just returning the names!
select fruit_name, calories from fruits;

select * from fruits where calories > 50;
select * from fruits where calories < 100 and is_berry =true;

select fruit_name from fruits where calories < 100 and is_berry =true;











