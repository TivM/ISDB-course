CREATE OR REPLACE PROCEDURE give_equipment_to_team(emp_div varchar, equip_id int, pos_start date, pos_end date)
    LANGUAGE plpgsql
AS
$$
BEGIN
    WITH equip_emp AS (
        SELECT equip_id as eq_id, emp.id as em_id, COALESCE(pos_start, CURRENT_DATE) as p_start, pos_end as p_end
        FROM employee emp
        WHERE emp.division = emp_div
    )
    INSERT INTO equipment_possession (equipment_id, employee_id, start_date, end_date)
    SELECT eq_id, em_id, p_start, p_end
    FROM equip_emp;
END;
$$;
