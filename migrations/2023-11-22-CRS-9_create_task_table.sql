--liquibase formatted sql

--changeset v.trofimchenko:add-task-table
create table task(
    id serial primary key,
    start_date date,
    end_date date,
    complexity int not null check ( complexity >= 0 ),
    status varchar default 'New',
    productivity_statistics_id int references productivity_statistics
);