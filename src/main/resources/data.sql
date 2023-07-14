INSERT INTO Category(cid, cname, description,sub_category, price, status, quantity ) values 
(1, 'Apple', 'Kashmiri Apple', 'Fruit', 200, 'Y', 12),
(2, 'Orange', '', 'Fruit', 100, 'Y', 10) ,
(3, 'Egg', '', 'Non-Veg', 50, 'Y', 12) ,
(4, 'Biscuit', 'K', 'Snack', 10, 'Y', 12) ,
(5, 'Maggie', 'K', 'Snack', 20, 'Y', 12) ,
(6, 'Cucumber', 'Ka', 'Veg', 30, 'Y', 12) ,
(7, 'Tomato', 'K', 'Veg', 200, 'Y', 15) ,
(8, 'Fruity', 'Ka', 'Veg', 20, 'Y', 1) ,
(9, 'Coco cola', 'Ka', 'Drink', 80, 'Y', 2);


Insert into AppUser (userid, uname, mobile, email, def_add) values
(123, 'Ram', '9022869224' 'hajisaima9', 'Mumbra'),
(289, 'Tom', '989256841' 'sdf', 'Thane'),
(335, 'Rock', '966428763' 'fsfc', 'Kalwa');

insert into LoginDetails (lid, user_id, login_name, login_password) values
(123, 1, 'Ram', 'Ram123'),(245, 2, 'Tom', 'Tom123'),(387, 3, 'Rock', 'Rock123');

insert into Address(aid, address, user_id) values
(1, 'Dadar', 1),(1, 'Vashi', 1);
