package com.attendance.control;

import com.attendance.control.controller.Controller;
import com.attendance.control.util.arduino.ArduinoConnection;

public class AttendanceControl {

    public static void main(String[] args) {
        
        Controller controller = new Controller();
        controller.init();
        
         Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                ArduinoConnection.getInstance().send("4");
                ArduinoConnection.getInstance().close();
            }
        });
    }
}
