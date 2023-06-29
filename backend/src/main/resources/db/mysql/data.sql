insert into todo(content, created_at, updated_at, is_check)
values ('test1', now(), null, false),
       ('test2', now(), null, true),
       ('test3', now(), null, false);

select * from todo;