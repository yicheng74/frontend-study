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


