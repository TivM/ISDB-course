--liquibase formatted sql

--changeset v.trofimchenko:add-email-in-admin-table
alter table admin add column email varchar not null unique;