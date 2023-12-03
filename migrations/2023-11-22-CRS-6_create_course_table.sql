--liquibase formatted sql

--changeset v.trofimchenko:add-course-table
create table if not exists course(
    id serial primary key,
    name varchar not null,
    description varchar,
    category varchar
);