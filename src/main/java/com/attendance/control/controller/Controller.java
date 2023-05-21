package com.attendance.control.controller;

import com.attendance.control.util.arduino.ArduinoConnection;
import com.attendance.control.view.MainFrame;
import com.attendance.control.view.form.AttendanceForm;
import com.attendance.control.view.form.EmployeeForm;
import com.attendance.control.view.form.RegisterAttendanceForm;

public class Controller {

    
    private final EmployeeForm employeeForm;
    private final AttendanceForm attendanceForm;
    private final RegisterAttendanceForm registerAttendanceForm;

    
    private final EmployeeController employeeController;
    private final AttendanceController attendanceController;
    private final RegisterAttendanceController registerAttendanceController;
    
    private final ArduinoConnection arduino = ArduinoConnection.getInstance();


    public Controller() {
        initArduino();
        
        employeeForm = new EmployeeForm();
        attendanceForm = new AttendanceForm();
        registerAttendanceForm = new RegisterAttendanceForm();
        
        employeeController = new EmployeeController(employeeForm);
        attendanceController = new AttendanceController(attendanceForm);
        registerAttendanceController = new RegisterAttendanceController(
                registerAttendanceForm
        );
    }
    
    public void init(){
        
        MainFrame.getInstance().setVisible(true);
        registerAttendanceController.initView();
        
        
        employeeController.initController();
        attendanceController.initController();
        registerAttendanceController.initController();
        
        employeeController.setController(this);
        attendanceController.setController(this);
        registerAttendanceController.setController(this);
    }

    public AttendanceController getAttendanceController() {
        return attendanceController;
    }

    public RegisterAttendanceController getRegisterAttendanceController() {
        return registerAttendanceController;
    }

    public EmployeeController getEmployeeController() {
        return employeeController;
    }

    private void initArduino() {
        
        arduino.initialize();
        
        Thread t = new Thread() {
            public void run() {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ie) {
                }
            }
        };
        
        t.start();
    }  

}
