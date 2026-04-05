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
    id int unsigned primary key auto_increment comment 'ID,主键',
    username varchar(20) not null unique comment '用户名',
    password varchar(32) default '123456' comment '密码',
    name varchar(10) not null comment '姓名',
    gender tinyint unsigned not null comment '性别, 1:男, 2:女',
    phone char(11) not null unique comment '手机号',
    job tinyint unsigned comment '职位, 1 班主任, 2 讲师 , 3 学工主管, 4 教研主管, 5 咨询师',
    salary int unsigned comment '薪资',
    image varchar(255) comment '头像',
    entry_date date comment '入职日期',
    dept_id int unsigned comment '部门ID',
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

insert into emp values(null, 'me', '758258', '666', 1, '12345678989', 1, 10000, '1.jpg', '2026-03-12', null, now(), now());

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
    gender tinyint unsigned not null comment '性别, 1:男, 2:女',
    phone char(11) not null unique comment '手机号',
    job tinyint unsigned comment '职位, 1 班主任, 2 讲师 , 3 学工主管, 4 教研主管, 5 咨询师',
    salary int unsigned comment '薪资',
    image varchar(255) comment '头像',
    entry_date date comment '入职日期',
    dept_id int unsigned comment '部门ID',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间'
) comment '员工表';


-- 与课件一致：头像为 OSS 地址；共 19 条（表含 update_time 时在每条末尾多一列，与课件单列时间同值即可）
insert into emp values
(1,  'shinaian',    '123456', '施耐庵', 1, '13309090001', 4, 15000, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2000-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(2,  'songjiang',   '123456', '宋江',   1, '13309090002', 2,  8600, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2015-01-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(3,  'luyunyi',     '123456', '卢俊义', 1, '13309090003', 2,  8900, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2008-05-01', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(4,  'wuyong',      '123456', '吴用',   1, '13309090004', 2,  9200, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2007-01-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(5,  'gongsunsheng','123456', '公孙胜', 1, '13309090005', 2,  9500, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2012-12-05', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(6,  'huosanniang', '123456', '扈三娘', 2, '13309090006', 3,  6500, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2013-09-05', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(7,  'chaijin',     '123456', '柴进',   1, '13309090007', 1,  4700, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2005-08-01', 5, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(8,  'likui',       '123456', '李逵',   1, '13309090008', 1,  4800, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2014-11-09', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(9,  'wusong',      '123456', '武松',   1, '13309090009', 1,  4900, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2011-03-11', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(10, 'luzhishen',   '123456', '鲁智深', 1, '13309090010', 2,  9600, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2006-03-15', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(11, 'yangzhi',     '123456', '杨志',   1, '13309090011', 2,  8800, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2010-06-01', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(12, 'xuning',      '123456', '徐宁',   1, '13309090012', 2,  9000, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2009-04-10', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(13, 'suochao',     '123456', '索超',   1, '13309090013', 3,  6800, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2011-01-05', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(14, 'daizong',     '123456', '戴宗',   1, '13309090014', 2,  9300, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2007-11-11', 3, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(15, 'liutang',     '123456', '刘唐',   1, '13309090015', 1,  5000, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2012-08-08', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(16, 'liying',      '123456', '李应',   1, '13309090016', 2,  9400, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2005-12-12', 2, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(17, 'shijin',      '123456', '史进',   1, '13309090017', 1,  5100, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2014-02-14', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(18, 'muhong',      '123456', '穆弘',   1, '13309090018', 2,  8200, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2010-09-09', 4, '2023-10-20 16:35:33', '2023-10-20 16:35:33'),
(19, 'leiheng',     '123456', '雷横',   1, '13309090019', 1,  4950, 'https://web-framework.oss-cn-hangzhou.aliyuncs.com/2023/1.jpg', '2013-05-22', 1, '2023-10-20 16:35:33', '2023-10-20 16:35:33');


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



select * from emp,dept where emp.dept_id = dept.id;

-- 笛卡尔积 内连接 隐式
select emp.id, emp.name, dept.name from emp,dept where emp.dept_id = dept.id;

select emp.id, emp.name, dept.name from emp,dept where emp.dept_id = dept.id and gender = 1 and salary > 8000;

-- 内连接 显式
select emp.id, emp.name, dept.name from emp inner join dept on emp.dept_id = dept.id;

select emp.id, emp.name, dept.name from emp inner join dept on emp.dept_id = dept.id where gender = 1 and salary > 8000; 

-- 左外连接
select emp.id, emp.name, dept.name from emp left join dept on emp.dept_id = dept.id;

-- 右外连接
select dept.name, emp.name from emp right join dept on emp.dept_id = dept.id;

--子查询
select min(entry_date) from emp;

select * from emp where entry_date = (select min(entry_date) from emp);

select * from emp where entry_date > (select entry_date from emp where name = '施耐庵');

select * from emp where dept_id in (
    select id from dept where name = '学工部' or name = '教研部'
);

select * from emp where salary = (select salary from emp where name = '施耐庵');

select * from emp where (salary, job) = (select salary, job from emp where name = '施耐庵');

select dept_id, max(salary) from emp group by dept_id;

select * from emp where (dept_id, salary) in (select dept_id, max(salary) from emp group by dept_id);

select * from emp where dept_id = (select id from dept where name = '学工部') and entry_date > '2012-01-01';

select * from emp where gender = 1 and salary < (select avg(salary) from emp);

select dept.name, count(*) from emp, dept where emp.dept_id = dept.id group by dept.name having count(*)>2; 

select * from emp where dept_id = (select id from dept where name = '学工部') and (salary, entry_date) > (5000, '2012-01-01') order by salary desc;


select dept_id,avg(salary) from emp group by dept_id;

select emp.* from emp , (select dept_id,avg(salary) as a_s from emp group by dept_id) as a where emp.dept_id = a.dept_id and salary < a.a_s;

use tlias;

select emp.*, dept.name from emp left join dept on emp.dept_id = dept.id;
