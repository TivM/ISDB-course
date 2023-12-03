--liquibase formatted sql

--changeset v.trofimchenko:add-enterprise_equipment-table
create table if not exists enterprise_equipment(
    id serial primary key,
    type varchar,
    serial_number int not null check ( serial_number > 0 ),
    description varchar
);