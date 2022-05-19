create table planets(
	planet_id serial primary key, --serial is of integer type, but it auto increments!
	planet_name varchar(30) not null, 
	has_rings boolean
);