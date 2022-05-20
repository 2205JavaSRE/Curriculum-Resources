-- Joins
-- Userful to comibne tables that reference other tables 
-- combines both tables to get information from both in a single view. 

-- Types of joins 
-- Inner joins 
-- Left outer joins 
-- Right outer joins 
-- Full outer joins 
-- Self join 
-- Cross join

-- Why do we have multiple table in the first place?
-- Why not just keep it in the same table. 
-- Normalization! It's a byproduct of it so that we can reduce data redundancy. 

select * from album;
select * from artist;

select count(*) from album;
select count(*) from artist;

select name from artist where artist_id = 
	(select artist_id from album where title = 'Restless and Wild');


---- INNER JOIN (only return matching values)
-- the "on" condition will return columns that match it! 
-- typically we join tables based on a foreign key relationship, but any columns 
-- of matching data types can be joined together. 

select * from artist a  inner join album a2 on a.artist_id = a2.artist_id;
select * from album a  inner join artist a2 on a.artist_id = a2.artist_id;

select * from artist a, album a2 where a.artist_id = a2.artist_id order by a.artist_id ;

-- Below is nonsense:
select * from artist a2  inner join album a on a.album_id  = a2.artist_id;
select * from album a inner join employee e on a.album_id = e.employee_id ;


-- LEFT OUTER JOIN and RIGHT OUTER JOIN 
-- We return all the rows that are matching or on the left or right depnding on when 
-- the join is a left outer or right outer. 

--left will return matching values and the records from the left table 
select count(*) from artist a left outer join album a2 on a.artist_id = a2.artist_id ;
select * from artist a left outer join album a2 on a.artist_id = a2.artist_id ;

select * from album a left outer join artist a2 on a.artist_id = a2.artist_id ;

--right will return matching values and the records from the right table. 
select count(*) from artist a right outer join album a2 on a.artist_id = a2.artist_id ;
select * from artist a right outer join album a2 on a.artist_id = a2.artist_id ;


-- FULL OUTER JOIN 

select a.name, a2.title from artist a full outer join album a2 on a.artist_id = a2.artist_id ;


-- CROSS JOIN 
select * from artist a cross join album a2;


-- SELF JOIN 
 -- Inner join onto itself!
select * from album a  inner join album a2 on a.artist_id = a2.album_id ;

