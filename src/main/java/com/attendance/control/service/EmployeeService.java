package com.attendance.control.service;

import com.attendance.control.dao.EmployeeDAO;
import com.attendance.control.model.Employee;
import java.util.List;

public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
    }
    
    public Employee findById(Long id){
        return employeeDAO.findById(id);
    }
    
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
    
    public void save(Employee employee){
        employeeDAO.save(employee);
    }
    
    public void update(Employee employee){
        employeeDAO.update(employee);
    }
    
    public void delete(Employee employee){
        employeeDAO.delete(employee);
    }

    public Employee findByCC(String cc){
        try {
            return employeeDAO.findByCC(cc);
        } catch (Exception e) {
            return null;
        }
    }
    
    public Employee findByfingerprintId(int fingerprintId) {
        try {
            return employeeDAO.findByfingerprintId(fingerprintId);
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Employee> findByName(String searchTerm){
        try {
            return employeeDAO.findByName(searchTerm);
        } catch (Exception e) {
            return null;
        }
    }

}
