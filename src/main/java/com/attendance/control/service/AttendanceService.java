package com.attendance.control.service;

import com.attendance.control.dao.AttendanceDAO;
import com.attendance.control.model.Attendance;
import com.attendance.control.model.Employee;
import java.time.LocalDate;
import java.util.Objects;


public class AttendanceService {
    
    
    private final AttendanceDAO attendanceDAO;
   
    public AttendanceService(){
        attendanceDAO = new AttendanceDAO();
    }
    
    public Attendance findByAttendanceDate(LocalDate attendanceDate){
        try {
            return attendanceDAO.findByAttendanceDate(attendanceDate);
        } catch (Exception e) {
            Attendance attendance = new Attendance();
            attendance.setAttendanceDate(attendanceDate);
            return attendanceDAO.save(attendance);
        }
    }
    
    public void registerAttendance(Employee employee){
        Attendance attendance = findByAttendanceDate(LocalDate.now());
        for(Employee temEmployee: attendance.getEmployees()){
            if(Objects.equals(temEmployee.getId(), employee.getId())){
                throw new RuntimeException(" usted ya registro su asistencia el dia de hoy!");
            }
        }
        attendanceDAO.registerAttendance(employee, attendance);
    }
    
   
    
}
