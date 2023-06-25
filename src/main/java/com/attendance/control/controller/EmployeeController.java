package com.attendance.control.controller;

import com.attendance.control.model.Attendance;
import com.attendance.control.model.Employee;
import com.attendance.control.service.EmployeeService;
import com.attendance.control.util.arduino.ArduinoConnection;
import com.attendance.control.util.arduino.SerialDataListener;
import com.attendance.control.view.MainFrame;
import com.attendance.control.view.components.Message;
import com.attendance.control.view.components.table.EventAction;
import com.attendance.control.view.form.EmployeeForm;
import com.attendance.control.view.form.RegisterEmployeeForm;
import com.attendance.control.view.form.ShowEmployeeForm;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class EmployeeController {

    private Controller controller;
    private Employee employeeToSave;
    private final EmployeeForm view;
    private final EmployeeService model;
    private final DefaultListModel<String> logArduinoList;
    private final DefaultTableModel employeeTable;
    private RegisterEmployeeForm registerEmployeeForm;

    private final ArduinoConnection ac = ArduinoConnection.getInstance();

    private final EventAction eventAction = new EventAction() {
        @Override
        public void delete(Employee employee) {

            if (view.getEmployeeTable().isEditing()) {
                view.getEmployeeTable().getCellEditor().stopCellEditing();
            }

            if (showMessage("¿Desea borrar el empleado con id " + employee.getId() + "?")) {

                model.delete(employee);
                deleteFingerprintId(employee.getFingerprintId());
                updateEmployeeTable();
            } else {
                showMessage("¡Operacion cancelada!");
            }
        }

        @Override
        public void view(Employee employee) {
            if (view.getEmployeeTable().isEditing()) {
                view.getEmployeeTable().getCellEditor().stopCellEditing();
            }
            showEmployeeForm(model.findById(employee.getId()));
        }
    };

    public EmployeeController(EmployeeForm view) {
        this.view = view;
        model = new EmployeeService();
        employeeTable = (DefaultTableModel) view.getEmployeeTableModel();
        logArduinoList = new DefaultListModel();
    }

    public void setController(Controller controller) {
        this.controller = controller;

    }

    public void initView() {
        updateEmployeeTable();
        MainFrame.getInstance().setPanel(view);
    }

    public void initController() {
        view.getAttendanceFormButton().addActionListener(e -> showAttendanceForm());
        view.getRegistrationFormButton().addActionListener(e -> showRegistrationFrom());
        view.getNewEmployeeBtn().addActionListener(e -> showRegisterEmployeeForm());
        view.getRefreshTableBtn().addActionListener(e -> updateEmployeeTable());
        addSearchTxTListener();
    }

    private Controller getController() {
        if (controller != null) {
            return controller;
        } else {
            throw new RuntimeException("controlador principal nulo: " + this.getClass().getName());
        }
    }

    private void showAttendanceForm() {
        getController().getAttendanceController().initView();
    }

    private void showRegistrationFrom() {
        getController().getRegisterAttendanceController().initView();
    }

    public void updateEmployeeTable() {
        List<Employee> employees = model.findAll();

        employeeTable.setRowCount(0);
        view.getSearchEmployeeTxt().clearItemSuggestion();

        view.setTotalEmployeesLb(employees.size());

        for (Employee employee : employees) {
            employeeTable.addRow(employee.toRowTable(eventAction));
            view.getSearchEmployeeTxt().addItemSuggestion(
                    employee.getFirstName() + " " + employee.getLastName()
            );
        }

    }

    private void addSearchTxTListener() {
        view.getSearchEmployeeTxt().getDocument()
                .addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent de) {
                        searchEmployee();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent de) {
                        searchEmployee();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent de) {
                        searchEmployee();
                    }
                });
    }

    private void searchEmployee() {

        String searchTerm = view.getSearchEmployeeTxt().getText();

        List<Employee> employees = model.findByName(searchTerm);

        employeeTable.setRowCount(0);

        for (Employee employee : employees) {
            employeeTable.addRow(employee.toRowTable(eventAction));
        }

    }

    private void showRegisterEmployeeForm() {
        employeeToSave = new Employee();
        logArduinoList.clear();
        initArduino();
        registerEmployeeForm = new RegisterEmployeeForm(null, true);

        registerEmployeeForm.getSaveEmployeeBtn().addActionListener(e -> saveEmployee());
        registerEmployeeForm.getRegisterFingerprintBtn().addActionListener(e -> registerFingerprint());
        registerEmployeeForm.getCloseBtn().addActionListener(e -> hiddenRegisterEmployeeForm());

        registerEmployeeForm.getLogArduinoList(logArduinoList);
        registerEmployeeForm.showDialog();
    }

    private void saveEmployee() {

        String cc = registerEmployeeForm.getCc();
        String firstName = registerEmployeeForm.getFirstName();
        String lastName = registerEmployeeForm.getLastName();

        if (cc.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            showMessage("¡Por favor, llene todo el formulario!");
            return;
        }

        if (model.findByCC(cc) != null) {
            showMessage("¡La C.C. ya esta registrada!");
            return;
        }

        if (employeeToSave.getFingerprintId() <= 0) {
            showMessage("¡Registre su huella para continuar!");
            return;
        }

        employeeToSave.setCc(cc);
        employeeToSave.setFirstName(firstName);
        employeeToSave.setLastName(lastName);

        model.save(employeeToSave);
        registerEmployeeForm.closeMenu();
        updateEmployeeTable();
        ac.send("4");
    }

    private void registerFingerprint() {
        if (employeeToSave != null
                && employeeToSave.getFingerprintId() > 0) {
            showMessage("¡Usted ya registro su huella!");
            return;
        }

        ac.send("2");
    }

    private Boolean showMessage(String message) {
        Message msg = new Message(null, true);
        msg.showMessage(message, false);
        return msg.isOk();
    }

    private void initArduino() {
        SerialDataListener serialDataListener = (String data) -> {
            try {
                int id = Integer.parseInt(data);
                employeeToSave.setFingerprintId(id);
                showMessage("¡Huella registra exitosamente con id #" + data + "!");
                ac.send("1");
            } catch (NumberFormatException e) {
                logArduinoList.add(0, data);
            }
        };
        ac.setDataListener(serialDataListener);
    }

    private void hiddenRegisterEmployeeForm() {
        if (employeeToSave.getFingerprintId() > 0) {
            deleteFingerprintId(employeeToSave.getFingerprintId());
        }
        registerEmployeeForm.closeMenu();

    }

    private void deleteFingerprintId(int id) {
        String idToDelete = String.valueOf(id);
        ac.send("3");
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ac.send(idToDelete);
                    Thread.sleep(5000);
                    ac.send("4");
                } catch (InterruptedException ex) {
                    System.out.println("Ocurrio un error al intentar eliminar la huella cancelada en el registro de un nuevo empleado");
                }
            }
        };
        t.start();
    }

    private void showEmployeeForm(Employee employee) {

        ShowEmployeeForm viewEmployee = new ShowEmployeeForm(null, true);
        DefaultListModel<String> attendanceEmployeeList = new DefaultListModel();

        viewEmployee.getEmployeeNameLb().setText(
                employee.getFirstName() + " " + employee.getLastName()
        );
        viewEmployee.getEmployeeCCLb().setText(employee.getCc());
        viewEmployee.setAttendanceListModel(attendanceEmployeeList);

        for (Attendance attendance : employee.getAttendances()) {
            LocalDate attendanceDate = attendance.getAttendanceDate();
            attendanceEmployeeList.addElement(
                    getDayOfWeekSpanish(attendanceDate.getDayOfWeek())
                    + " - "
                    + attendanceDate.toString()
            );
        }
        viewEmployee.showDialog();
    }

    private String getDayOfWeekSpanish(DayOfWeek dayOfWeek) {
        Locale spanishLocale = new Locale("es", "ES");
        TextStyle spanishDayOfWeekStyle = TextStyle.FULL;
        return dayOfWeek.getDisplayName(spanishDayOfWeekStyle, spanishLocale).toLowerCase();
    }

}
