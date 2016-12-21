-- 测试用户表
create table t_user(
	id  int(11)  not null auto_increment,
	user_name varchar(255) default null,
	age int(4) default 0,
	sex  varchar(8) default '男' ,
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;



insert into t_user(user_name, age, sex) values ('lisi', 1, '女');

select *  from  t_user;


-- 测试学生表
create table t_student(
	id  int(11)  not null auto_increment,
	stu_name varchar(255) default null,
	age int(4) default 0,
	sex  varchar(8) default '男' ,
	primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

