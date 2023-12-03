CREATE OR REPLACE PROCEDURE fire_employee(emp_id int)
    LANGUAGE plpgsql
AS $$
BEGIN
    DELETE FROM equipment_possession ep where ep.employee_id=emp_id;
    DELETE FROM work_time wt where wt.employee_id=emp_id;
    DELETE FROM dayoff_request dr where dr.employee_id = emp_id;
    DELETE FROM course_enrollment ce where ce.employee_id = emp_id;
    DELETE FROM task t where t.productivity_statistics_id = (select ps.id from productivity_statistics ps where ps.employee_id=emp_id);
    DELETE FROM productivity_statistics ps where ps.employee_id = emp_id;
    DELETE FROM employee em where em.id=emp_id;
END;
$$;