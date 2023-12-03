--liquibase formatted sql

--changeset v.trofimchenko:add-employee-table
create table if not exists employee(
    id serial primary key,
    name varchar not null,
    age int not null,
    division varchar,
    admin_id int references admin
);