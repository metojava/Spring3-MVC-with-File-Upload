create table attachments(id int not null auto_increment,accountId int default null,name varchar(200),attachment mediumblob not null,created timestamp default current_timestamp,primary key(id));

<!--size of field name is small , make it bigger-->

alter table attachments modify column name varchar(100);


<!--get size of blob column in mysql table-->

select octet_length(attachment) from attachments where id = 1;

