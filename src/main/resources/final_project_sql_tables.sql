DROP DATABASE event_manager;
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
event_id int auto_increment not null,
event_name varchar(50) not null,
dueDate date not null,
location_name varchar (50) not null,
guests_number int not null,
primary key(event_id)
);

CREATE table IF NOT EXISTS event_guest_list( -- customer can see guest list and add/delete/update
guest_id int auto_increment not null,
guest_name varchar (50) not null,
participation boolean,
event_name varchar(50) not null,
event_date date not null,
primary key(guest_id)
);

CREATE table decor_list ( -- owner can add/delete/update
decor_id int auto_increment not null,
decor_name varchar(50) not null, -- can see customer + owner
decor_qwt int not null, -- can see customer + owner
decor_price real, -- can see owner + update
decor_price_vat real AS (decor_price * 1.21), -- can see customer + owner
decor_status varchar (50) not null, -- can see owner + update status
primary key(decor_id)
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

use event_manager;
select * from decor_list;
DELETE FROM decor_list WHERE id = 11;

INSERT INTO decor_list (decor_name, decor_qwt, decor_price, decor_status) VALUES ('weddings Arch round', '5', '300', 'available');
INSERT INTO decor_list (decor_name, decor_qwt, decor_price, decor_status) VALUES ('weddings Arch square', '3', '250.50', 'available');
INSERT INTO decor_list (decor_name, decor_qwt, decor_price, decor_status) VALUES ('chianti chair', '150', '15.00', 'available');
INSERT INTO decor_list (decor_name, decor_qwt, decor_price, decor_status) VALUES ('round table', '10', '170.00', 'available');
INSERT INTO decor_list (decor_name, decor_qwt, decor_price, decor_status) VALUES ('square table', '10', '110.00', 'available');
INSERT INTO decor_list (decor_name, decor_qwt, decor_price, decor_status) VALUES ('ceremony table', '3', '75.00', 'available');
INSERT INTO decor_list (decor_name, decor_qwt, decor_price, decor_status) VALUES ('list box mirror', '3', '20.00', 'available');
INSERT INTO decor_list (decor_name, decor_qwt, decor_price, decor_status) VALUES ('glass candlesticks', '400', '2.50', 'available');
INSERT INTO decor_list (decor_name, decor_qwt, decor_price, decor_status) VALUES ('small vases', '350', '4.50', 'available');
INSERT INTO decor_list (decor_name, decor_qwt, decor_price, decor_status) VALUES ('big vases', '50', '18.00', 'available');