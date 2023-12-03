--liquibase formatted sql

--changeset v.trofimchenko:add-productivity_statistics-table
create table if not exists productivity_statistics(
    id serial primary key,
    date date not null,
    manager_review varchar,
    employee_id int not null references employee,
    admin_id int not null references admin
);
