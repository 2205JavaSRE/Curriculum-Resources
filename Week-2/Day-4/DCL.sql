--We want to avoid giving super user access to our database. 
-- Currently, we are the super user (postgres:password)

-- We might like to give limited access to our external programs. (Java)

-- DCL : Database Control Language
-- We use GRANT and REVOKE to provide permissions and restrictions to users. 

create role java_login LOGIN password 'p4ssw0rd';

grant select on table planets to java_login;
grant insert on table planets to java_login;

grant all privileges on sequences to java_login; --this is bad practice but I'm being lazy atm

revoke all privileges on schema public from java_login;