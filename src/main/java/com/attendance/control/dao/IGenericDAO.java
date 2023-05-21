package com.attendance.control.dao;

import java.util.List;


public interface IGenericDAO<T, PK>{
    public T save(T entity);
    public void update(T entity);
    public void delete(T id);
    public T findById(PK id);
    public List<T> findAll();
    
}
