CREATE DATABASE IF NOT EXISTS event_manager;
use event_manager;

DROP table user_validation;
CREATE table IF NOT EXISTS user_validation ( -- owner can delete user
id int auto_increment not null,
login_name varchar (50) not null, -- only for login
user_password varchar (50) not null,  -- only for login
user_name varchar (50) not null, -- can see owner
phone real,-- can see owner
email varchar (50),-- can see owner
primary key(id)
);

CREATE table IF NOT EXISTS events (  -- customer or owner can add/delete/update
event_id int auto_increment primary key  not null,
event_name varchar(50) not null,
dueDate date not null,
location varchar (50) not null,
distance_to_location int,
guests_number int not null
);


CREATE table IF NOT EXISTS event_guest_list( -- customer can see guest list and add/delete/update
guest_id int auto_increment not null,
guest_name varchar (50) not null,
participation boolean,
event_name varchar(50) not null,
event_date date not null,
foreign key(guest_id) references events (event_id)
);

CREATE table decor_list ( -- owner can add/delete/update
item_id int auto_increment primary key not null,
item_name varchar(50) not null, -- can see customer + owner
item_qwt int not null, -- can see customer + owner
item_price real, -- can see owner
item_price_vat real AS (item_price * 1.21), -- can see customer + owner
item_status varchar (50) not null -- can see owner
);

CREATE table chosen_decor( -- table for bill
bill_id int auto_increment not null,
event_name varchar (50) not null,
item_id int,
item_name varchar(50) not null,
item_price_vat real,
item_qwt int not null,
total_price real AS (item_qwt * item_price_vat),
foreign key(bill_id) references events (event_id)
);