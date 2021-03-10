
DROP TABLE IF EXISTS product;
create table product (
    prod_id identity primary key,
    copies varchar (10) default 10,
    prod_name varchar(500),
    thumbnail varchar(2000),
    price int,
    availability varchar(100),
    description varchar(3000),
    quantity int default 4
);

DROP TABLE IF EXISTS userr;
create table userr(
    username varchar(100) primary key,
    password varchar(500),
    address varchar(1000),
    is_account_non_expired boolean default false,
    is_account_non_locked boolean default false,
    is_credentials_non_expired boolean default false,
    is_enabled boolean default false

);

DROP TABLE IF EXISTS car_seat;
create table car_seat(
    prod_id identity primary key,
    kg_allowed int,
    color varchar(500),

    foreign key (prod_id) references product
);

DROP TABLE IF EXISTS food;
create table food(
    prod_id identity primary key,
    nutrition varchar(500),

    foreign key (prod_id) references product
);

DROP TABLE IF EXISTS cart;
create table cart(
    cart_id identity primary key
);

create table roles(
    role_id int primary key,
    role_name varchar (100)
);

DROP TABLE IF EXISTS cart;
create table userr_roles(
    role_id int,
    user_id varchar(400),

    foreign key (role_id) references roles(role_id),
    foreign key (user_id) references userr(username)
);

insert into roles(role_id, role_name)
values
(1, 'ADMIN'),
(2, 'USER');

insert into userr(username, password, address, is_account_non_expired, is_account_non_locked, is_credentials_non_expired, is_enabled)
values
('borjan', '123', 'Bul. ASNOM', true,true,true,true),
('martin', '456', 'Bul. VSB',true,true,true,true);

insert into product
values(1, 3,  'Lorem Ipsum - Dolor sit amet', 'https://www.kids-room.com/WebRoot/KidsroomDE/Shops/Kidsroom/5DDD/9D95/8779/7DA2/C3C1/AC1E/0705/EAD3/BILD3_079709-110669/IC_IMAGE/en-chicco-child-car-seat-sirio-012-red-passion-2020-Red-Passion.jpg', 5300, 'Available', 'Lorem Ipsum dolorLorem Ipsum dolorLorem Ipsum dolorLorem Ipsum dolor',1);

insert into car_seat
values(1, 10,'red');

insert into product
values(2, 3, 'Hipp - Baby Food', 'https://www.paket.mk/wp-content/uploads/2018/05/ZMA19434.jpg', 135, 'Available', 'Lorem Ipsum dolor sit amet dolor sit amet dolor sit amet', 2);

insert into food
values(2, 'Carrot, Rice, Veal');


insert into product
values(3, 6, 'test', 'https://assets.sainsburys-groceries.co.uk/gol/7862686/1/640x640.jpg', 120, 'test', 'text', 1);

insert into food
values(3, 'Carrot, Rice, Veal');
