package com.attendance.control;

import com.attendance.control.controller.Controller;
import com.attendance.control.util.arduino.ArduinoConnection;

/*
import com.attendance.control.controller.AttendanceJpaController;
import com.attendance.control.controller.EmployeeJpaController;
import com.attendance.control.model.Attendance;
import com.attendance.control.model.Employee;
import java.util.List;
 */
public class AttendanceControl {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        
        Controller controller = new Controller();
        
         Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                ArduinoConnection.getInstance().send("4");
                ArduinoConnection.getInstance().close();
            }
        });
        
        
        
        
        
        //EntityManagerProvider.getInstance().getEntityManager();
        
        /*
        AttendanceDAO attendanceDAO = new AttendanceDAO();
        Attendance currentAttendance = new Attendance();
        currentAttendance.setAttendanceDate(LocalDate.now());
        attendanceDAO.save(currentAttendance);
        for (Attendance attendance : attendanceDAO.findAll()) {
        System.out.println(attendance.toString());
        }
        System.out.println();
        EmployeeDAO EmployeeDAO = new EmployeeDAO();
        List<Employee> employees = EmployeeDAO.findAll();
        System.out.println();
        for(Employee employee: employees){
        System.out.println("\n\n"+employee.toString());
        for(Attendance attendance: employee.getAttendances()){
        System.out.println(attendance.toString());
        }
        }
         */
        /*
        EntityManagerFactory emf = null;
        emf = Persistence
        .createEntityManagerFactory("attendanceControlPersistence");
        EntityManager em = emf.createEntityManager();
        List<Employee> employees;
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Employee.class));
        Query q = em.createQuery(cq);
        employees = q.getResultList();
        for (Employee employee : employees) {
        System.out.println("\n\n" + employee.toString());
        //if (employee.getAttendances() != null) {
        //    employee.getAttendances().size();
        //}
        for(Attendance employeA : employee.getAttendances()){
        System.out.println(employeA.toString());
        }
        }
        em.close();
        emf.close();
        /*
        EmployeeJpaController ec = new EmployeeJpaController();
        AttendanceJpaController ac = new AttendanceJpaController();
        List<Attendance> attendances = ac.findAttendanceEntities();
        attendances.size();
        List<Employee> employees = ec.findEmployeeEntities();
        employees.size();
        attendances.get(0).getEmployees().add(employees.get(0));
        employees.get(0).getAttendances().add(attendances.get(0));
        try {
        ac.edit(attendances.get(0));
        ec.edit(employees.get(0));
        } catch (Exception ex) {
        System.out.println(ex.getMessage());
        }
        for (Employee e : employees) {
        System.out.println("\n\n" + e.toString());
        System.out.println(e.getAttendances());
        }
        for (Attendance a : attendances) {
        System.out.println("\n\n" + a.toString());
        }
        Employee employee = new Employee();
        employee.setFirstName("Carlos Mateo");
        employee.setLastName("Martinez Guerra");
        employee.setCc("1005570893");
        ec.create(employee);
         */
    }
}
