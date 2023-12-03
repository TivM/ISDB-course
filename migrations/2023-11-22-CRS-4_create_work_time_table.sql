--liquibase formatted sql

--changeset v.trofimchenko:add-work_time-table
create table if not exists work_time(
    id serial primary key,
    start_timestamp timestamp not null,
    end_timestamp timestamp,
    employee_id int references employee
);