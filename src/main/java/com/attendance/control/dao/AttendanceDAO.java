package com.attendance.control.dao;

import com.attendance.control.model.Attendance;
import com.attendance.control.model.Employee;
import java.time.LocalDate;

import javax.persistence.TypedQuery;

public class AttendanceDAO extends AbstractJpaDAO<Attendance, Long> {

    public Attendance findByAttendanceDate(LocalDate attendanceDate) {
        String hql = "FROM Attendance a WHERE a.attendanceDate = :attendanceDate";
        TypedQuery<Attendance> query = entityManager.createQuery(hql, Attendance.class);
        query.setParameter("attendanceDate", attendanceDate);
        return query.getSingleResult();
    }

    public void registerAttendance(Employee employee, Attendance attendance) {

        entityManager.getTransaction().begin();
        attendance.getEmployees().add(employee);
        entityManager.persist(attendance);
        entityManager.getTransaction().commit();

    }
}
