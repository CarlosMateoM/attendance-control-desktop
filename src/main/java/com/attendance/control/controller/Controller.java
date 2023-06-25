package com.attendance.control.controller;

import com.attendance.control.util.arduino.ArduinoConnection;
import com.attendance.control.view.MainFrame;
import com.attendance.control.view.components.Message;
import com.attendance.control.view.form.AttendanceForm;
import com.attendance.control.view.form.EmployeeForm;
import com.attendance.control.view.form.RegisterAttendanceForm;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void init() {
        
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

        Thread t = new Thread() {
            @Override
            public void run() {
                arduino.initialize();
            }
        };
        
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
