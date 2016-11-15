-- 测试用户表
create table t_user(
	id  int(11)  not null auto_increment,
	User_name varchar(255) default null,
	age int(4) default 0,
	sex  varchar(8) default '男' ,
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;



insert into t_user(user_name, age, sex) values ('lisi', 1, '女');

select *  from  t_user;


