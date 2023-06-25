package com.attendance.control;

import com.attendance.control.controller.Controller;
import com.attendance.control.util.arduino.ArduinoConnection;
import com.attendance.control.view.components.Message;

public class AttendanceControl {

    static final String JRE_PATH = "jre1.8.0_202";

    public static void main(String[] args) {

        System.setProperty("java.home", JRE_PATH);

        Message msg = new Message(null, false);

        Thread t = new Thread() {
            @Override
            public void run() {
                msg.showMessage("Cargando...", false);
                msg.setVisible(true);

            }
        };
        t.start();
        
        Controller controller = new Controller();
        controller.init();

        msg.setVisible(false);
        
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                ArduinoConnection.getInstance().send("4");
                ArduinoConnection.getInstance().close();
            }
        });
    }
}
