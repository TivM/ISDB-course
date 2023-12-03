--liquibase formatted sql

--changeset v.trofimchenko:add-equipment_possession-table
create table if not exists equipment_possession(
    id serial primary key,
    equipment_id int not null references enterprise_equipment,
    employee_id int not null references employee,
    start_date date not null,
    end_date date
);
