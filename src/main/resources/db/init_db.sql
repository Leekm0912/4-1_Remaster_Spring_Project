# using mysql
drop table if exists trading;
drop table if exists monthlyRent;
drop table if exists charter;
drop table if exists land;
drop table if exists orderList;
drop table if exists item;
drop table if exists buyer;
drop table if exists seller;
#drop table if exists ids;

drop view if exists detailOrder;
drop view if exists detailItem_trading;
drop view if exists detailItem_monthlyRent;
drop view if exists detailItem_charter;
drop view if exists detailItem_land;

create table buyer(
	ID VARCHAR(50) PRIMARY KEY not null,
	PW VARCHAR(50) not null,
	name VARCHAR(50) not null,
	phoneNumber VARCHAR(20) not null
);
insert into buyer values("admin", '1212', '관리자(매수)', '안알랴줌');

create table seller(
	ID VARCHAR(50) PRIMARY KEY not null,
	PW VARCHAR(50) not null,
	name VARCHAR(50) not null,
	phoneNumber VARCHAR(20) not null
);
insert into seller values("admin", '1212', '관리자(매도)', '안알랴줌');

create table item(
	itemNumber int PRIMARY KEY not null,
	address VARCHAR(100) not null,
	sellerID VARCHAR(50) not null,
    itemAddDate DATETIME default CURRENT_TIMESTAMP not null,
    foreign key (sellerID) references seller(ID) ON DELETE CASCADE
);


create table orderList(
	orderNumber int PRIMARY KEY not null,
	itemNumber int not null,
	sellerID VARCHAR(50) not null,
   	buyerID VARCHAR(50) not null,
    주문일자 DATETIME default CURRENT_TIMESTAMP not null,
    foreign key (sellerID) references seller(ID) ON DELETE CASCADE,
    foreign key (buyerID) references buyer(ID) ON DELETE CASCADE,
    foreign key (itemNumber) references item(itemNumber) ON DELETE CASCADE
);

create table trading(
	itemNumber int PRIMARY KEY not null,
	sellerID VARCHAR(50) not null,
    price int not null,
    foreign key (itemNumber) references item(itemNumber) ON DELETE CASCADE,
    foreign key (sellerID) references seller(ID) ON DELETE CASCADE
    
);

create table monthlyRent(
	itemNumber int PRIMARY KEY not null,
	sellerID VARCHAR(50) not null,
    contractMonth int not null,
    deposit int not null,
    monthlyRentPrice int not null,
    foreign key (itemNumber) references item(itemNumber) ON DELETE CASCADE,
    foreign key (sellerID) references seller(ID) ON DELETE CASCADE
);

create table charter(
	itemNumber int PRIMARY KEY not null,
	sellerID VARCHAR(50) not null,
    contractMonth int not null,
    price int not null,
    foreign key (itemNumber) references item(itemNumber) ON DELETE CASCADE,
    foreign key (sellerID) references seller(ID) ON DELETE CASCADE
);

create table land(
	itemNumber int PRIMARY KEY not null,
	sellerID VARCHAR(50) not null,
    SQM int not null,
    pricePerSQM int not null,
    foreign key (itemNumber) references item(itemNumber) ON DELETE CASCADE,
    foreign key (sellerID) references seller(ID) ON DELETE CASCADE
);

create view detailOrder as
select orderNumber, buyer.name as buyerName, seller.name as sellerName, item.itemNumber as itemNumber
from orderList, item, buyer, seller
where orderList.orderNumber = item.itemNumber;

create view detailItem_trading as
select item.itemNumber as itemNumber, seller.name as sellerName, address, price, itemAddDate
from item, seller, trading
where item.itemNumber = trading.itemNumber;

create view detailItem_monthlyRent as
select item.itemNumber as itemNumber, seller.name as sellerName, address, contractMonth, deposit, monthlyRentPrice, itemAddDate
from item, seller, monthlyRent
where item.itemNumber = monthlyRent.itemNumber;

create view detailItem_charter as
select item.itemNumber as itemNumber, seller.name as sellerName, address, contractMonth, price, itemAddDate
from item, seller, charter
where item.itemNumber = charter.itemNumber;

create view detailItem_land as
select item.itemNumber as itemNumber, seller.name as sellerName, address, SQM, pricePerSQM, itemAddDate
from item, seller, land
where item.itemNumber = land.itemNumber;

# view test data
insert into item values(1, '매매테스트', 'admin', CURRENT_TIMESTAMP);
insert into trading values(1, 'admin', 1);
insert into orderList values(1, 1, 'admin', 'admin',CURRENT_TIMESTAMP);

insert into item values(2, '월세테스트', 'admin', CURRENT_TIMESTAMP);
insert into monthlyRent values(2, 'admin', 1, 2, 3);
insert into orderList values(2, 2, 'admin', 'admin',CURRENT_TIMESTAMP);

insert into item values(3, '전세테스트', 'admin', CURRENT_TIMESTAMP);
insert into charter values(3, 'admin', 1, 2);
insert into orderList values(3, 3, 'admin', 'admin',CURRENT_TIMESTAMP);

insert into item values(4, '토지테스트', 'admin', CURRENT_TIMESTAMP);
insert into land values(4, 'admin', 1, 2);
insert into orderList values(4, 4, 'admin', 'admin',CURRENT_TIMESTAMP);

#create table ids(
#		TABLE_NAME VARCHAR(16) primary key,
#        NEXT_ID VARCHAR(50) NOT NULL
#);
#insert into ids values('SAMPLE', 2);