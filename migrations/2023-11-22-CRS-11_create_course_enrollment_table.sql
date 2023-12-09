--liquibase formatted sql

--changeset v.trofimchenko:add-course_enrollment-table
create table if not exists course_enrollment(
    employee_id int not null references employee,
    course_id int not null references course,
    is_finished boolean default false,

    primary key (employee_id, course_id)

);