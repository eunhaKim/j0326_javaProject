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
desc Member;
drop table member;

alter table member add constraint unique(tel);

insert into member values(default, default, 'admin', '1234', '관리자', default, '010-2622-0194', '청주', default, default);
insert into member values(default, default, 'tester', '1234', '테스터', default, '010-1234-5678', '서울', default, default);
insert into member values(default, default, 'tester1', '1234', '권형규', default, '010-1234-1234', '부산', default, default);
insert into member values(default, default, 'tester2', '1234', '권형준', default, '010-1234-2345', '제주', default, default);

select * from member;

