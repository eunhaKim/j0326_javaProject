show databases;
show tables;


-- 멤버 테이블

create table member(
	idx int not null auto_increment primary key,
	pic varchar(40) default 'images/member.jpg',
	id varchar(20) not null,
	pwd varchar(20) not null,
	name varchar(20) not null,
	gender char(2) default '여자',
	tel varchar(15) not null,
	addr varchar(20) not null,
	joinDate datetime default now(),
	point int default 0
);
desc member;
drop table member;

alter table member add constraint unique(id);
alter table member add column job varchar(6) default '기타';

insert into member values(default, 'images/member1.jpg', 'admin', '1234', '관리자', default, '010-2622-0194', '청주', default, default);
insert into member values(default, 'images/member2.jpg', 'tester', '1234', '권형준', '남자', '010-1234-5678', '서울', default, default);
insert into member values(default, 'images/member3.jpg', 'tester1', '1234', '권형규', '남자', '010-1234-1234', '부산', default, default);
insert into member values(default, 'images/member4.jpg', 'tester2', '1234', '로사', default, '010-1234-2345', '제주', default, default);
insert into member values(default,'images/member5.jpg', 'tester3', '1234', '가나다', '남자', '010-1234-2345', '서울', default, default);
insert into member values(default,'images/member6.jpg', 'tester4', '1234', '김말숙', default, '010-1234-2345', '청주', default, default);
insert into member values(default,'images/member7.jpg', 'tester5', '1234', '홍길동', '남자', '010-1234-2345', '울산', default, default);
insert into member values(default,'images/member8.jpg', 'tester6', '1234', '로이', '남자', '010-1234-2345', '세종', default, default);
insert into member values(default,'images/member9.jpg', 'tester7', '1234', '은하김', '여자', '010-1234-2345', '청주', default, default);
insert into member values(default,'images/member10.jpg', 'tester8', '1234', '이기자', '남자', '010-1234-2345', '서울', default, default);
insert into member values(default,'images/member11.jpg', 'tester9', '1234', '소나무', '여지', '010-1234-2345', '서울', default, default);
insert into member values(default,'images/member12.jpg', 'tester10', '1234', '남편', '남자', '010-1234-2345', '서울', default, default);

select * from member;
delete from member where name = '홍길동';
update member set name = '김은하' where id = 'admin';

create table product(
	pIdx int not null auto_increment primary key,
	pPic varchar(40) default 'images/member.jpg',
	pName varchar(20) not null,
	pCnt int not null,
	pPrice int not null,
	pInfo text
);
desc product;
drop table product;

insert into product values(default, 'pImages/product.jpg','product1',10,10000,'product1 상세설명 페이지입니다.');
insert into product values(default, 'pImages/product.jpg','product2',10,10000,'product2 상세설명 페이지입니다.');
insert into product values(default, 'pImages/product.jpg','product3',10,10000,'product3 상세설명 페이지입니다.');
insert into product values(default, 'pImages/product.jpg','product4',10,10000,'product4 상세설명 페이지입니다.');
insert into product values(default, 'pImages/product.jpg','product5',10,10000,'product5 상세설명 페이지입니다.');

select * from product;