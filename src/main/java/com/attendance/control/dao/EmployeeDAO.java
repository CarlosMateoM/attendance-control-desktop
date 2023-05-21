package com.attendance.control.dao;

import com.attendance.control.model.Employee;
import java.util.List;
import javax.persistence.TypedQuery;

public class EmployeeDAO extends AbstractJpaDAO<Employee, Long> {

    public List<Employee> findByName(String searchTerm) {
        String hql = "FROM Employee WHERE firstName LIKE :searchTerm OR lastName LIKE :searchTerm OR CONCAT(firstName, ' ', lastName) = :name";

        TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
        query.setParameter("searchTerm", "%" + searchTerm + "%");
        query.setParameter("name",searchTerm);
        return query.getResultList();
    }

    public Employee findByfingerprintId(int fingerprintId) {
        String hql = "FROM Employee e WHERE e.fingerprintId = :fingerprintId";
        TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
        query.setParameter("fingerprintId", fingerprintId);
        return query.getSingleResult();
    }

    public Employee findByCC(String CC) {
        String hql = "FROM Employee e WHERE e.cc = :cc";
        TypedQuery<Employee> query = entityManager.createQuery(hql, Employee.class);
        query.setParameter("cc", CC);
        return query.getSingleResult();
    }
}
