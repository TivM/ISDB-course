--liquibase formatted sql

--changeset v.trofimchenko:add-dayoff_request-table
create table if not exists dayoff_request(
    id serial primary key,
    start_date date,
    end_date date,
    is_approved boolean default false,
    employee_id int references employee
);