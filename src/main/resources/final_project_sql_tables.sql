CREATE DATABASE IF NOT EXISTS event_manager;
use event_manager;

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
location_name varchar (50) not null,
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
decor_id int auto_increment primary key not null,
decor_name varchar(50) not null, -- can see customer + owner
decor_qwt int not null, -- can see customer + owner
decor_price real, -- can see owner + update
decor_price_vat real AS (decor_price * 1.21), -- can see customer + owner
decor_status varchar (50) not null -- can see owner + update status
);

CREATE table bill ( -- table for bill will be completed from customer inputs
bill_id int auto_increment not null,
event_name varchar (50) not null,
chosen_decor_id int,
chosen_decor_name varchar(50) not null,
chosen_decor_price_vat real,
chosen_decor_qwt int not null,
total_decor_price real AS (chosen_decor_qwt * chosen_decor_price_vat),
transportation_costs real AS (total_decor_price * 1.15),
total_bill real AS (total_decor_price + transportation_costs),
foreign key(bill_id) references events (event_id)
);