-- SET operators 
-- Add records by columns 
-- UNION 
-- UNION ALL
-- INTERSECT 
-- EXCEPT 


create table TA(
	nums int, 
	chars varchar(10)
);

create table TB(
	other_nums int, 
	other_chars varchar(10)
);

truncate table TB;

insert into TA values(1, 'a');
insert into TA values(2, 'b');
insert into TA values(3, 'c');
insert into TA values(4, 'z');
insert into TA values(5, 'w');
insert into TA values(6, 'q');


insert into TB values(2,'b');
insert into TB values(3,'c');
insert into TB values(4,'d');
insert into TB values(7,'e');
insert into TB values(8,'f');
insert into TB values(9,'g');

select * from TA;
select * from TB;

--UNION 
-- Returns values that exist in both tables, ignoring duplicate values 
select nums, chars from TA union select other_nums, other_chars from TB order by nums;

-- UNION ALL, like union but with duplicate values now.
select * from TA union all select * from TB;

-- INTERSECT: return all the records that exist in both tables 
select * from TA intersect select * from TB;
select nums from TA intersect select other_nums  from TB;
select chars from TA intersect select other_chars  from TB;

-- EXCEPT: returns records that ONLY exist on the left hand side. 
select * from TA except select * from TB;
select * from TB except select * from TA;