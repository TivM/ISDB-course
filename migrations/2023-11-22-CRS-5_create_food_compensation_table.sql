--liquibase formatted sql

--changeset v.trofimchenko:add-food_compensation-table
create table if not exists food_compensation(
    id serial primary key,
    payment_amount int not null check ( payment_amount >= 0 ),
    compensation_date date not null,
    is_breakfast boolean,
    employee_id int references employee
);
