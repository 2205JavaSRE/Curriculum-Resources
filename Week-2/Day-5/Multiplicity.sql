drop table planets;
drop table moons;
drop table features;
drop table planets_features;
-- Multiplicity 

-- Relationships that entities have with each other. 

-- One to Many 
-- Many to One 
-- One to One 
-- Many to Many 


---- CREATING a Many-To-One/One-To-Many relationship

create table planets(
	planet_id serial primary key, 
	planet_name varchar(30) not null unique, 
	atmosphere boolean not null, 
);

create table moons(
	moon_id serial primary key, 
	moon_name varchar(30) not null unique,
	my_planet_id int references planets(planet_id)
);


insert into planets (planet_name, atmosphere) values
	('Mercury',false),
	('Venus',true),
	('Earth',true),
	('Mars',false),
	('Jupiter',true);

select * from planets;

delete from planets where planet_name = 'Mercury';

select * from moons;
truncate moons;

insert into moons (moon_name, my_planet_id) values 
	('The Moon', 3),
	('Deimos', (select planet_id from planets where planet_name = 'Mars')),
	('Phobus', (select planet_id from planets where planet_name = 'Mars'));


-- Deleting all the moons associated with Earth before deleting Earth itself.






-- One to One 
-- One to one relationship is not common. 
-- We use the many to one relationship, but add in a unique constraint!

create table planets(
	planet_id serial primary key, 
	planet_name varchar(30) not null unique, 
	atmosphere boolean not null, 
);

create table moons(
	moon_id serial primary key, 
	moon_name varchar(30) not null unique,
	my_planet_id int unique references planets(planet_id)
);


--Referential Integrity
-- We can't have orphan records in our tables. 
-- When a record points to another record, we should not remove the other record 
--	otherwise we'll have records that point no where. 

delete from moons where moon_id = 
	(select moon_id from moons where my_planet_id = 
		(select planet_id from planets where planet_name = 'Earth'))
		
delete from planets where planet_name = 'Earth';



-- Many to Many relationship 

create table planets(
	planet_id serial primary key, 
	planet_name varchar(30) unique not null
);


insert into planets (planet_name) values 
	('Mercury'),('Venus'),('Earth'),('Mars');


create table features(
	feature_id serial primary key, 
	feature_name varchar(30) unique not null
); 

insert into features (feature_name) values 
	('Mountains'),('Deserts'),('Oceans'),('Valleys');

--We create a Junction table or a join table lto connect the 2

create table planets_features(
	fk_planet_id int references planets(planet_id),
	fk_feature_id int references features(feature_id)
);

select * from planets_features;

insert into planets_features values 
	((select planet_id from planets where planet_name = 'Earth'),
	(select feature_id from features where feature_name = 'Mountains')),
	((select planet_id from planets where planet_name = 'Earth'),
	(select feature_id from features where feature_name = 'Deserts')),
	((select planet_id from planets where planet_name = 'Earth'),
	(select feature_id from features where feature_name = 'Oceans'));


--A query to find all the features in the planet Earth!
select feature_name from features where feature_id in 
	(select fk_feature_id from planets_features where fk_planet_id = 
		(select planet_id from planets where planet_name = 'Earth'));




