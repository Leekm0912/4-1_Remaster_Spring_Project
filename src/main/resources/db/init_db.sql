# using mysql
drop table if exists 매매;
drop table if exists 전세;
drop table if exists 월세;
drop table if exists 토지;
drop table if exists 주문;
drop table if exists 매물;
drop table if exists 매수자;
drop table if exists 매도자;
#drop table if exists ids;

drop view if exists 상세주문;
drop view if exists 상세매물_매매;
drop view if exists 상세매물_전세;
drop view if exists 상세매물_월세;
drop view if exists 상세매물_토지;

create table 매수자(
	ID VARCHAR(50) PRIMARY KEY,
	PW VARCHAR(50),
	이름 VARCHAR(50),
	전화번호 VARCHAR(20)
);
insert into 매수자 values("admin", '1212', '관리자(매수)', '안알랴줌');

create table 매도자(
	ID VARCHAR(50) PRIMARY KEY,
	PW VARCHAR(50),
	이름 VARCHAR(50),
	전화번호 VARCHAR(20)
);
insert into 매도자 values("admin", '1212', '관리자(매도)', '안알랴줌');

create table 매물(
	등록번호 int PRIMARY KEY,
	주소 VARCHAR(100),
	매도자ID VARCHAR(50) ,
    등록일자 DATETIME default CURRENT_TIMESTAMP,
    foreign key (매도자ID) references 매도자(ID) ON DELETE CASCADE
);


create table 주문(
	주문번호 int PRIMARY KEY,
	매물등록번호 int,
	매도자ID VARCHAR(50) ,
    매수자ID VARCHAR(50) ,
    주문일자 DATETIME default CURRENT_TIMESTAMP,
    foreign key (매도자ID) references 매도자(ID) ON DELETE CASCADE,
    foreign key (매수자ID) references 매수자(ID) ON DELETE CASCADE,
    foreign key (매물등록번호) references 매물(등록번호) ON DELETE CASCADE
);

create table 매매(
	등록번호 int PRIMARY KEY,
	매도자ID VARCHAR(50) ,
    가격 int,
    foreign key (등록번호) references 매물(등록번호) ON DELETE CASCADE,
    foreign key (매도자ID) references 매도자(ID) ON DELETE CASCADE
    
);

create table 월세(
	등록번호 int PRIMARY KEY,
	매도자ID VARCHAR(50) ,
    개약월수 int,
    보증금 int,
    월세 int,
    foreign key (등록번호) references 매물(등록번호) ON DELETE CASCADE,
    foreign key (매도자ID) references 매도자(ID) ON DELETE CASCADE
);

create table 전세(
	등록번호 int PRIMARY KEY,
	매도자ID VARCHAR(50) ,
    계약월수 int,
    가격 int,
    foreign key (등록번호) references 매물(등록번호) ON DELETE CASCADE,
    foreign key (매도자ID) references 매도자(ID) ON DELETE CASCADE
);

create table 토지(
	등록번호 int PRIMARY KEY,
	매도자ID VARCHAR(50) ,
    평수 int,
    평당가격 int,
    foreign key (등록번호) references 매물(등록번호) ON DELETE CASCADE,
    foreign key (매도자ID) references 매도자(ID) ON DELETE CASCADE
);

create view 상세주문 as
select 주문번호, 매수자.이름 as 매수자이름, 매도자.이름 as 매도자이름, 매물.등록번호 as 매물등록번호
from 주문, 매물, 매수자, 매도자
where 주문.매물등록번호 = 매물.등록번호;

create view 상세매물_매매 as
select 매물.등록번호 as 매물등록번호, 매도자.이름 as 매도자이름, 주소, 가격, 등록일자
from 매물, 매도자, 매매
where 매물.등록번호 = 매매.등록번호;

create view 상세매물_월세 as
select 매물.등록번호 as 매물등록번호, 매도자.이름 as 매도자이름, 주소, 보증금, 월세, 등록일자
from 매물, 매도자, 월세
where 매물.등록번호 = 월세.등록번호;

create view 상세매물_전세 as
select 매물.등록번호 as 매물등록번호, 매도자.이름 as 매도자이름, 주소, 가격, 등록일자
from 매물, 매도자, 전세
where 매물.등록번호 = 전세.등록번호;

create view 상세매물_토지 as
select 매물.등록번호 as 매물등록번호, 매도자.이름 as 매도자이름, 주소, 평수, 평당가격, 등록일자
from 매물, 매도자, 토지
where 매물.등록번호 = 토지.등록번호;

# view test data
insert into 매물 values(1, '매매테스트', 'admin', CURRENT_TIMESTAMP);
insert into 매매 values(1, 'admin', 1);
insert into 주문 values(1, 1, 'admin', 'admin',CURRENT_TIMESTAMP);

insert into 매물 values(2, '월세테스트', 'admin', CURRENT_TIMESTAMP);
insert into 월세 values(2, 'admin', 1, 2, 3);
insert into 주문 values(2, 2, 'admin', 'admin',CURRENT_TIMESTAMP);

insert into 매물 values(3, '전세테스트', 'admin', CURRENT_TIMESTAMP);
insert into 전세 values(3, 'admin', 1, 2);
insert into 주문 values(3, 3, 'admin', 'admin',CURRENT_TIMESTAMP);

insert into 매물 values(4, '토지테스트', 'admin', CURRENT_TIMESTAMP);
insert into 토지 values(4, 'admin', 1, 2);
insert into 주문 values(4, 4, 'admin', 'admin',CURRENT_TIMESTAMP);

#create table ids(
#		TABLE_NAME VARCHAR(16) primary key,
#        NEXT_ID VARCHAR(50) NOT NULL
#);
#insert into ids values('SAMPLE', 2);