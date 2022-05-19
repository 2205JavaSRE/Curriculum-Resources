

--When we are setting up our full stack, we typlically do our DDL commands directly
-- through the terminal or an IDE 
create table planets(
	planet_id serial primary key, --serial is of integer type, but it auto increments!
	planet_name varchar(30) not null, 
	has_rings boolean
);

insert into planets (planet_name,has_rings) values ('fake',false);

insert into planets values (10, 'fakey fake', false);

delete from planets where planet_name = 'fakey fake';

truncate planets;

select * from planets;