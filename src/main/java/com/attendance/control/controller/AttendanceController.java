package com.attendance.control.controller;

import com.attendance.control.model.Attendance;
import com.attendance.control.model.Employee;
import com.attendance.control.service.AttendanceService;
import com.attendance.control.view.MainFrame;
import com.attendance.control.view.components.datechooser.SelectedDate;
import com.attendance.control.view.form.AttendanceForm;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;

public class AttendanceController {

    private Controller controller;
    private final AttendanceForm view;
    private final AttendanceService model;
    private final DefaultTableModel attendanceTable;

    public AttendanceController(AttendanceForm attendanceForm) {
        this.view = attendanceForm;
        model = new AttendanceService();
        attendanceTable = (DefaultTableModel) view.getAttendanceTable().getModel();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    private Controller getController() {
        if (controller != null) {
            return controller;
        } else {
            throw new RuntimeException("controlador principal nulo: " + this.getClass().getName());
        }
    }

    public void initView() {
      
        MainFrame.getInstance().setPanel(view);
        refreshTableAttendance();
    }

    public void initController() {
        view.getCurrentDateBtn().addActionListener(e -> showCurrentDate());
        view.getSearchButton().addActionListener(e -> refreshTableAttendance());
        view.getBackRegistrationForm().addActionListener(e -> showRegistrationForm());
        view.getEmployeeFormButton().addActionListener(e -> showEmployeeForm());

    }

    public void refreshTableAttendance() {

        String date = view.getDateTextField();

        Attendance attendance = model.findByAttendanceDate(
                LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        );

        attendanceTable.setRowCount(0);
        view.setTotalAttendancesLb(attendance.getEmployees().size());

        for (Employee employee : attendance.getEmployees()) {
            attendanceTable.addRow(new String[]{
                "" + employee.getId(),
                employee.getFirstName() + " " + employee.getLastName(),
                employee.getCc()
            });
        }

    }

    private void showRegistrationForm() {
        getController().getRegisterAttendanceController().initView();
    }

    private void showEmployeeForm() {
        getController().getEmployeeController().initView();
    }

    private void showCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        view.getDateAttendances()
                .setSelectedDate(
                        new SelectedDate(
                                currentDate.getDayOfMonth(),
                                currentDate.getMonthValue(),
                                currentDate.getYear()
                        )
                );
        refreshTableAttendance();
    }

}
