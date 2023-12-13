CREATE OR REPLACE PROCEDURE get_compensation_sum(IN comp_start_date date, IN comp_end_date date, IN emp_id int, OUT result int)
    LANGUAGE plpgsql
AS
$$
BEGIN
    select sum(fc.payment_amount) into result from food_compensation fc
    where (select count(*) from dayoff_request df
           where df.start_date <= fc.compensation_date and df.end_date >= fc.compensation_date and df.is_approved=true
           and df.employee_id = emp_id) = 0
      and comp_start_date <= fc.compensation_date and comp_end_date >= fc.compensation_date and fc.employee_id=emp_id;
END;
$$;
