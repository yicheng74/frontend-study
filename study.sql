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

