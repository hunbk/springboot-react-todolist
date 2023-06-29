drop table if exists todo;

create table todo
(
    id         bigint auto_increment,
    content    varchar(50) not null,
    created_at timestamp   not null default now(),
    updated_at timestamp,
    is_check   boolean     not null default false,
    primary key (id)
);

