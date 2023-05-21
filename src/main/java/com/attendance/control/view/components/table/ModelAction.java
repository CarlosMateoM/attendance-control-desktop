package com.attendance.control.view.components.table;

import com.attendance.control.model.Employee;

public class ModelAction {
    
    private EventAction event;
    private Employee employee;

    public ModelAction(EventAction event, Employee employee) {
        this.event = event;
        this.employee = employee;
    }

    public EventAction getEvent() {
        return event;
    }

    public void setEvent(EventAction event) {
        this.event = event;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
