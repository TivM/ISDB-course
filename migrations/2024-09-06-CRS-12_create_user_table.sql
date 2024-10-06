--liquibase formatted sql

--changeset v.trofimchenko:add-user-table
create table if not exists _user(
    id serial primary key,
    email varchar not null unique,
    password varchar not null,
    role varchar check (role in ('ADMIN','EMPLOYEE'))
);