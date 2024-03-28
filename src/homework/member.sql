show tables;

create table members(
	idx int not null auto_increment primary key,
	id varchar(20) not null,
	pwd varchar(20) not null,
	name varchar(20) not null,
	age int default 20,
	gender char(2) default '여자',
	ipsail datetime default now()
);
desc members;

insert into members values (default,'id1','1234','홍길동',default,default,default);
insert into members values (default,'id2','1234','김말숙',40,default,'2010-03-01');
insert into members values (default,'id3','1234','소나무',23,'남자','2024-04-05');
insert into members values (default,'id4','1234','강감찬',30,'남자','2015-03-01');
insert into members values (default,'id5','1234','이기자',30,'남자','2020-01-01');

select * from members;
drop table members;
delete from members;