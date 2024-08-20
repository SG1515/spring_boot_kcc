insert into users(id, name, join_date, password, ssn) values (9001,'kim', now(), 'pass1', '708080-1122331')
insert into users(id, name, join_date, password, ssn) values (9002,'park', now(), 'pass1', '108080-1122331')
insert into users(id, name, join_date, password, ssn) values (9003,'min', now(), 'pass1', '508080-1122331')

insert into post(title, content, user_id) values ('글 1번', '하하하', 9001)
insert into post(title, content, user_id) values ('글 2번', '하하하', 9001)