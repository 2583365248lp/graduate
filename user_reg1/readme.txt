//����>������>�䳤��
Mysql�ֶ�����ѡ��
1. ���� 
  *���� int 
  *С�� float double
  *�ı� char varchar longtext
  *������ʱ�� date(yyyy-MM-dd) time (HH:mm:ss)  datetime(yyyy-MM-dd HH:mm:ss) year (yyyy) 

create table t_user(
	id int auto_increment primary key,
	name varchar(50),
	sex char(2),
	birthday date,
	reg_time datetime
)

insert into t_user(name,sex,birthday,reg_time)
values('ls','Ů','2008-05-13',now());

select * from t_user;


select * from t_user where id=1;

select * from t_user where  name like '%s%';

update t_user set name ='zss' where id=1;
update t_user set name ='zs',sex='Ů' where id=1;

delete from  t_user where id=1;
delete from  t_user