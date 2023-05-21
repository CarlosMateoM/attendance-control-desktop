package com.attendance.control.view.components.table;

import com.attendance.control.model.Employee;

public interface EventAction {
    
    public void view(Employee data);
    
    public void delete(Employee data);
}
