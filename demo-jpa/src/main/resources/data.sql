insert into course(id,name,created_date,last_updated_date)
values(10001,'JPA in 50 Steps',current_date(),current_date());
insert into course(id,name,created_date,last_updated_date)
values(10002,'Spring in 50 Steps',current_date(),current_date());
insert into course(id,name,created_date,last_updated_date)
values(10003,'Spring Boot in 50 Steps',current_date(),current_date());
insert into course(id,name,created_date,last_updated_date)
values(10004,'Dummy1',current_date(),current_date());
insert into course(id,name,created_date,last_updated_date)
values(10005,'Dummy2',current_date(),current_date());
insert into course(id,name,created_date,last_updated_date)
values(10006,'Dummy3',current_date(),current_date());
insert into course(id,name,created_date,last_updated_date)
values(10007,'Dummy4',current_date(),current_date());
insert into course(id,name,created_date,last_updated_date)
values(10008,'Dummy5',current_date(),current_date());


insert into passport(id,number)
values(40001,'E12345');
insert into passport(id,number)
values(40002,'L67890');
insert into passport(id,number)
values(40003,'N43289');

insert into student(id,name,passport_id)
values(20001,'Ranga',40001);
insert into student(id,name,passport_id)
values(20002,'Adam',40002);
insert into student(id,name,passport_id)
values(20003,'Jane',40003);





insert into review(id,rating,description,course_id)
values(50001,'5', 'Great Course',10001);
insert into review(id,rating,description,course_id)
values(50002,'4','Wonderful Course',10001);
insert into review(id,rating,description,course_id)
values(50003,'5', 'Awesome Course',10003);


insert into student_course(student_id, course_id)
values(20001, 10001);
insert into student_course(student_id, course_id)
values(20002, 10001);
insert into student_course(student_id, course_id)
values(20003, 10001);
insert into student_course(student_id, course_id)
values(20001, 10003);



