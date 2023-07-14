CREATE TABLE IF NOT EXISTS Category (  
cid INT AUTO_INCREMENT NOT NULL PRIMARY KEY ,  
cname VARCHAR(50),
description VARCHAR(100),
sub_category varchar(50),
price int,
status varchar(10),
quantity int 
);  

CREATE TABLE IF NOT EXISTS AppUser(
userid INT auto_increment NOT NULL primary key,
uname varchar(50),
mobile varchar(50),
email varchar(50),
def_add varchar(50)
);

CREATE TABLE IF NOT EXISTS LoginDetails(
lid int auto_increment NOT NULL primary key,
user_id int,
login_name varchar(50),
login_password varchar(50),
foreign key (user_id) references AppUser(userid)
);

CREATE TABLE IF NOT EXISTS Addresses(
aid int auto_increment NOT NULL primary key,
address varchar(50),
user_id int,
foreign key (user_id) references AppUser(userid)
);

CREATE TABLE IF NOT EXISTS Cart(
cartid int auto_increment NOT NULL primary key,
cat_id int,
total int,
quantity int,
foreign key (cat_id) references Category(cid)
);


CREATE TABLE IF NOT EXISTS OrderHistory(
oid int auto_increment NOT NULL primary key,
cat_id int,
user_id int,
total int,
quantity int,
order_date date,
status varchar(20),
address varchar(50),
foreign key (cat_id) references Category(cid),
foreign key (user_id) references AppUser(userid)
);

