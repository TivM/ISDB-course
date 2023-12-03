CREATE OR REPLACE PROCEDURE cancel_food_compensation_for_deadline_miss(emp_id int)
    LANGUAGE plpgsql
AS $$
BEGIN
    UPDATE food_compensation fc set payment_amount=0
    where fc.employee_id=emp_id
      and (select min(task.end_date) from task where task.productivity_statistics_id = (select max(id) from productivity_statistics ps where ps.employee_id=emp_id)
                                                 and task.end_date < CURRENT_DATE and task.status != 'Done') < fc.compensation_date;
END;
$$;