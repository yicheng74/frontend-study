select database();
use db01;
select database();

create table user(
    id int comment '用户ID',
    username varchar(50) comment '用户名',
    name varchar(10) comment '姓名',
    age int comment '年龄',
    gender char(1) comment '性别'
) comment '用户信息表';

create table user(
    id int primary key comment '用户ID',
    username varchar(50) unique not null comment '用户名',
    name varchar(10) not null comment '姓名',
    age int comment '年龄',
    gender char(1) default'男' comment '性别'
) comment '用户信息表';


create table emp(
    id int unsigned primary key auto_increment comment 'ID',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) default '123456' comment '密码',
    name varchar(10) not null comment '姓名',
    gender tinyint unsigned not null comment '性别 , 1 男 2 女',
    phone char(11) not null unique comment '',
    job tinyint unsigned comment '职位 1 2 3 4 5',
    salary int unsigned comment '薪资',
    entry_date date comment '入职日期',
    image varchar(255) comment '图像',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间'
) comment '员工表';

show tables;

desc emp;

show create table emp;

alter table emp add qq varchar(13) comment 'qq号';

alter table emp modify qq varchar(15);

alter table emp change qq qq_num varchar(15) comment 'qq号';

alter table emp drop column qq_num;

alter table employee rename to emp;

drop table employee;

insert into emp(username, password, name, gender, phone) values('choupi', '5438', '臭屁', 1, '12345678923');

insert into emp values(null, 'me', '758258', '666', 1, '12345678989', 1, 10000, '2026-03-12', '1.jpg', now(), now());

insert into emp(username, password, name, gender, phone) 
values('pichou', '38', '臭屁的屁臭', 1, '12345672323') , ('hello', '543877', '臭屁为老哥', 1, '32145678923');

update emp set username = 'choupihao' , name = '臭屁好' where id = 1;

update emp set entry_date = '2026-03-10';

delete from emp where id = 1;

delete from emp;

select name , entry_date from emp;

select * from emp;

select name as 姓名, entry_date as 入职日期 from emp;

select distinct job from emp;

select * from emp where name = '臭屁好';

select * from emp where salary <= 5000;

select * from emp where job is null;

select * from emp where password != '123456';

select * from emp where entry_date between '2000-01-01' and '2026-03-11';

select * from emp where entry_date between '2000-01-01' and '2026-03-11' && gender = 2;

select * from emp where job = 1 || job = 2;

select * from emp where name like '___';

select * from emp where name like '臭%';

select * from emp where name like '%屁%';

select count(id) from emp;

select count(*) from emp;

select count(1) from emp;

select avg(salary) from emp;

select min(salary) from emp;

select max(salary) from emp;

select sum(salary) from emp;

select gender, count(*) from emp group by gender;

select job, count(*) from emp where entry_date<='2026-03-11' group by job having count(*)>=2;

select * from emp order by entry_date asc; --desc 降

select * from emp order by entry_date , update_time desc;

select * from emp limit 0,3;

select * from emp limit 2,2;

use web01;

create table user(
    id int unsigned primary key auto_increment comment 'ID,主键',
    username varchar(20) comment '用户名',
    password varchar(32) comment '密码',
    name varchar(10) comment '姓名',
    age tinyint unsigned comment '年龄'
) comment '用户表';

insert into user(id, username, password, name, age) values (1, 'daqiao', '123456', '大乔', 22),
                                                          (2, 'xiaoqiao', '123456', '小乔', 18),
                                                          (3, 'diaochan', '123456', '貂蝉', 24),
                                                          (4, 'lvbu', '123456', '吕布', 28),
                                                          (5, 'zhaoyun', '12345678', '赵云', 27);



use tlias;


create table dept(
    id int unsigned primary key auto_increment comment 'ID,主键',
    name varchar(10) not null unique comment '部门名称',
    create_time datetime default null comment '创建时间',
    update_time datetime default null comment '修改时间'
) comment '部门表';

insert into dept values (1, '学工部', '2024-09-25 09:47:40', '2024-09-25 09:47:40'),
                        (2, '教研部', '2024-09-25 09:47:40', '2024-09-09 15:17:04'),
                        (3, '咨询部', '2024-09-25 09:47:40', '2024-09-30 21:26:24'),
                        (4, '就业部', '2024-09-25 09:47:40', '2024-09-25 09:47:40'),
                        (5, '人事部', '2024-09-25 09:47:40', '2024-09-25 09:47:40'),
                        (6, '行政部', '2024-11-30 20:56:37', '2024-09-30 20:56:37');



select id, name, create_time, update_time from dept order by update_time desc;
