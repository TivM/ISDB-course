CREATE OR REPLACE PROCEDURE assign_course_to_team(emp_div varchar, course_id int)
    LANGUAGE plpgsql
AS $$
BEGIN
    WITH course_emp AS (
        SELECT course_id as c_id, emp.id as em_id
        FROM employee emp
        WHERE emp.division = emp_div
    )
    INSERT INTO course_enrollment (employee_id, course_id)
    SELECT em_id, c_id
    FROM course_emp;
END;
$$;