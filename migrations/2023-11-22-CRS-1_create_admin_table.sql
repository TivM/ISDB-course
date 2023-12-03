--liquibase formatted sql

--changeset v.trofimchenko:add-admin-table
create table if not exists admin(
    id serial primary key,
    name varchar not null,
    age int not null,
    division varchar
);