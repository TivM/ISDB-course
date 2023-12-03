CREATE OR REPLACE PROCEDURE hire_employee(emp_name varchar, emp_division varchar, emp_age int, emp_adm_id int)
    LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO employee (name, age, division, admin_id) values (emp_name, emp_age, COALESCE(emp_division, 'Standard'), COALESCE(emp_adm_id, (select max(id) from admin)));
END
$$;
