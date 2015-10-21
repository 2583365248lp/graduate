//数字>定长串>变长串
Mysql字段类型选择
1. 数字 
  *整数 int 
  *小数 float double
  *文本 char varchar longtext
  *日期与时间 date(yyyy-MM-dd) time (HH:mm:ss)  datetime(yyyy-MM-dd HH:mm:ss) year (yyyy) 

create table t_user(
	id int auto_increment primary key,
	name varchar(50),
	sex char(2),
	birthday date,
	reg_time datetime
)

insert into t_user(name,sex,birthday,reg_time)
values('ls','女','2008-05-13',now());

select * from t_user;


select * from t_user where id=1;

select * from t_user where  name like '%s%';

update t_user set name ='zss' where id=1;
update t_user set name ='zs',sex='女' where id=1;

delete from  t_user where id=1;
delete from  t_user