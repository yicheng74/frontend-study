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



--表
use db02;

-- 部门表
create table dept(
    id int unsigned PRIMARY KEY AUTO_INCREMENT COMMENT 'ID,主键',
    name varchar(10) NOT NULL UNIQUE COMMENT '部门名称',
    create_time datetime DEFAULT NULL COMMENT '创建时间',
    update_time datetime DEFAULT NULL COMMENT '修改时间'
) comment '部门表';

insert into dept values (1, '学工部', '2023-09-25 09:47:40', '2023-09-25 09:47:40'),
                        (2, '教研部', '2023-09-25 09:47:40', '2023-10-09 15:17:04'),
                        (3, '咨询部2', '2023-09-25 09:47:40', '2023-11-30 21:26:24'),
                        (4, '就业部', '2023-09-25 09:47:40', '2023-09-29 09:47:40'),
                        (5, '人事部', '2023-09-25 09:47:40', '2023-09-25 09:47:40'),
                        (15, '行政部', '2023-11-30 20:56:37', '2023-11-30 20:56:37');

-- 员工表
create table emp(
    id int unsigned primary key auto_increment comment 'ID,主键',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) default '123456' comment '密码',
    name varchar(10) not null comment '姓名',
    gender tinyint unsigned not null comment '性别,1男, 2女',
    phone char(11) not null unique comment '手机号',
    job tinyint unsigned comment '职位 1 2 3 4 5',
    salary int unsigned comment '薪资',
    image varchar(255) comment '图像',
    entry_date date comment '入职日期',
    dept_id int unsigned comment '部门ID',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间'
) comment '员工表';


insert into emp values
(1,  'shinaian',   '123456', '施耐庵', 1, '13309090001', 4, 15000, '5.png',  '2000-01-01', 2, '2023-10-20 16:35:33', '2023-11-16 16:11:26'),
(2,  'songjiang',  '123456', '宋江',   1, '13309090002', 2,  8600, '01.png', '2015-01-01', 4, '2023-10-20 16:35:33', '2023-10-20 16:35:37'),
(3,  'luyunyi',    '123456', '卢俊义', 1, '13309090003', 2,  8900, '01.png', '2008-05-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:39'),
(4,  'wuyong',     '123456', '吴用',   1, '13309090004', 2,  9200, '01.png', '2007-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:41'),
(5,  'gongsunsheng','123456','公孙胜', 1, '13309090005', 2,  9500, '01.png', '2012-12-05', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:43'),
(6,  'huosanning', '123456', '晁盖',   1, '13309090006', 3,  6500, '01.png', '2013-09-05', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:45'),
(7,  'chaijin',    '123456', '柴进',   1, '13309090007', 1,  4700, '01.png', '2005-08-01', 5, '2023-10-20 16:35:33', '2023-10-20 16:35:47'),
(8,  'likui',      '123456', '李逵',   1, '13309090008', 1,  4800, '01.png', '2014-11-09', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:49'),
(9,  'wusong',     '123456', '武松',   1, '13309090009', 1,  4900, '01.png', '2011-03-11', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:51');


alter table emp add constraint fk_emo_dept_id foreign key (dept_id) references dept(id);



-- 学生、课程、选课中间表示例（与截图同款）
create table tb_student(
    id int auto_increment primary key comment '主键ID',
    name varchar(10) comment '姓名',
    no varchar(10) comment '学号'
) comment '学生表';

insert into tb_student(name, no) values ('黛绮丝', '2000100101'),
                                       ('谢逊', '2000100102'),
                                       ('张无忌', '2000100103'),
                                       ('韦一笑', '2000100104');

create table tb_course(
    id int auto_increment primary key comment '主键ID',
    name varchar(10) comment '课程名称'
) comment '课程表';

insert into tb_course(name) values ('Java'),
                                   ('PHP'),
                                   ('MySQL'),
                                   ('Hadoop');

create table tb_student_course(
    id int auto_increment primary key comment '主键',
    student_id int not null comment '学生ID',
    course_id int not null comment '课程ID',
    constraint fk_courseid foreign key (course_id) references tb_course(id),
    constraint fk_studentid foreign key (student_id) references tb_student(id)
) comment '学生课程中间表';

insert into tb_student_course(student_id, course_id) values (1, 1),(1,2),(1,3),(2,2),(2,3),(3,4);


--案例
create table emp_experience(
    id int unsigned auto_increment primary key comment '主键ID',
    emp_id int  unsigned not null comment '员工ID',
    start_date date comment '开始日期',
    end_date date comment '结束日期',
    company varchar(50) comment '公司名称',
    job varchar(50) comment '职位',
    constraint fk_empid foreign key (emp_id) references emp(id)
) comment '工作经历表';