create table users (
user_id serial primary key,
first_name varchar(50) unique not null,
last_name varchar(50) unique not null,
address varchar(50) not null,
address2 varchar(50),
city varchar(50),
state varchar(2),
zip integer,
ssn integer

)

create table user_types (
user_type_id serial primary key,
user_type_name varchar(50)
)

create table user_login (
user_login_id serial primary key,
username varchar(50) unique not null,
password varchar(50) not null,
user_id integer,
constraint user_id
	foreign key(user_id)
		references users(user_id)
user_type_id integer,
constraint user_type_id
	foreign key(user_type_id) 
		references user_types(user_type_id)		
)

create table account_type (
account_type_id serial primary key,
account_type_name varchar(50)
)


create table accounts (
account_id serial primary key,
balance decimal(12,2) not null,
account_type_id integer,
constraint account_type_id
	foreign key(account_type_id)
		references account_type(account_type_id),
approved boolean not null		
)

create table user_accounts_bridge (
user_id integer,
account_id integer,
constraint user_id
	foreign key(user_id)
		references users(user_id),
constraint account_id
	foreign key(account_id)
		references accounts(account_id)
)

create table employee_assignments 
user_id integer,
constraint user_id
	foreign key(user_id)
		references users(user_id),
user_login_id,
constraint user_login_id
	foreign key(user_login_id)
		references user_login(user_login_id)

INSERT INTO users (first_name,last_name ,address,address2,city,state,zip,ssn,email)
VALUES
  ('Aiko','Juarez','9767 Aliquam St.','egestas hendrerit','Neustadt am Rübenberge','WY',857477,585541995,'aliquet.nec@outlook.com'),
  ('Abigail','Steele','P.O. Box 785, 4464 Vitae, Road','ante ipsum','Antártica','TN',23112,71044936,'ultrices.duis.volutpat@yahoo.net'),
  ('Callie','Hopper','560-6335 Mi. Rd.','accumsan sed,','Dublin','IL',15142,601299776,'vehicula.aliquet@google.com'),
  ('Priscilla','Bailey','2819 Nulla St.','amet ultricies sem','Nova Kakhovka','OH',23112,710298924,'fermentum.arcu@hotmail.edu'),
  ('Bree','Cooley','P.O. Box 410, 8449 Enim. Road','tempus scelerisque,','Sabadell','NE',22727,218575729,'mi.lacinia.mattis@protonmail.ca'),
  ('Sharon','Harvey','Ap #430-997 Mollis Ave','gravida sagittis.','Izmail','TN',615354,480462878,'ligula.elit.pretium@icloud.org'),
  ('Len','Michael','Ap #737-9083 In Rd.','arcu. Sed et','Châlons-en-Champagne','OR',36294,568003469,'nibh.sit@icloud.couk'),
  ('Emma','Morgan','P.O. Box 130, 5131 Magna. St.','Proin','Karak','MS',34221,861004497,'fermentum.metus@outlook.ca'),
  ('Paula','Price','P.O. Box 742, 8258 Facilisis Avenue','rutrum. Fusce','Sabanalarga','FL',43221,920719700,'diam.proin@yahoo.edu'),
  ('Maryam','Holt','P.O. Box 171, 6074 Ac Av.','nibh','Mokpo','HI',13221,546465603,'eget@icloud.com');
 
insert into user_types (user_type_name)
values ('Customer', 'Employee', 'Admin');


INSERT INTO user_login (username, password ,user_id,user_type_id)
VALUES
  ('sed,','varius',1,1),
  ('accumsan','eleifend,',4,1),
  ('purus','scelerisque',3,1),
  ('mauris.','lacinia',7,1),
  ('Donec','eros',6,1);
  ('risus.','libero.',6,1),
  ('velit','imperdiet',2,1),
  ('Vivamus','mollis.',4,2),
  ('urna','sit',4,2),
  ('Sed','vel',7,3);
	

 
insert into account_type (account_type_name)
values ('Checking', 'Savings','CD')


INSERT INTO accounts (balance, account_type_id, approved)
values (1000, 1, FALSE),
(1000, 1, TRUE), (1000, 2, TRUE), (1000, 1, TRUE),
(1000, 1, TRUE), (1000, 2, FALSE), (1000, 1, TRUE),
(1000, 3, FALSE), (1000, 3, TRUE), (1000, 1, FALSE)

insert into user_accounts_bridge (user_id, account_id)
values (1,1), (2,2), (3,3), (4,4), (5,5), (6,6), (6,7), (5,8), (4,9);

insert into employee_assignments (user_id, user_login_id) 
vaules (1,7), (2,7), (3,7), (4,7), (5,8), (6,8), (7,9);

