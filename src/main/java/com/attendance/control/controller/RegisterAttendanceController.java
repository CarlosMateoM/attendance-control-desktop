package com.attendance.control.controller;

import com.attendance.control.model.Employee;
import com.attendance.control.service.AttendanceService;
import com.attendance.control.service.EmployeeService;
import com.attendance.control.util.arduino.ArduinoConnection;
import com.attendance.control.util.arduino.SerialDataListener;
import com.attendance.control.view.MainFrame;
import com.attendance.control.view.components.Message;
import com.attendance.control.view.form.RegisterAttendanceForm;

public class RegisterAttendanceController {

    private Controller controller;
    private final EmployeeService model;
    private final RegisterAttendanceForm view;
    private final AttendanceService attendanceModel;

    private final ArduinoConnection ac = ArduinoConnection.getInstance();
    SerialDataListener serialDataListener = (String data) -> {
        Message msg = new Message(null, true);
        try {
            int id = Integer.parseInt(data);
            register(id);
        } catch (NumberFormatException e) {
            msg.showMessage(data, true);
        }
    };

    public RegisterAttendanceController(RegisterAttendanceForm view) {
        this.model = new EmployeeService();
        this.view = view;

        this.attendanceModel = new AttendanceService();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void initView() {
        initArduino();
        MainFrame.getInstance().setPanel(view);
    }

    public void initController() {
        view.getAdminButton().addActionListener(e -> showAttendanceForm());
    }

    private void initArduino() {
        
        ac.setDataListener(serialDataListener);
        
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    ac.send("1");
                } catch (InterruptedException ex) {
                    System.out.println("error comunicando al arduino modo lectura");
                }
            }
        };

        t.start();

    }

    private void register(int id) {
        Employee employee = model.findByfingerprintId(id);
        if (employee != null) {
            try {
                attendanceModel.registerAttendance(employee);
                showMessage("¡Bienvenido " + employee.getFirstName() + "!", true);
            } catch (RuntimeException e) {
                showMessage(e.getMessage(), true);

            }
        }
    }

    public void showAttendanceForm() {
        if (controller != null) {
            controller.getAttendanceController().initView();
            ac.setDataListener(null);
            ac.send("4");
        }
    }

    private void showMessage(String message, boolean autoClose) {
        Message msg = new Message(null, true);
        msg.showMessage(message, autoClose);

    }

}
