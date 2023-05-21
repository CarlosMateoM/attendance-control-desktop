package com.attendance.control.dao;

import com.attendance.control.util.EntityManagerProvider;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

public abstract class AbstractJpaDAO<T, PK> implements IGenericDAO<T, PK> {

    protected Class<T> entityClass;
    protected EntityManager entityManager;

    public AbstractJpaDAO() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
        entityManager = EntityManagerProvider.getInstance().getEntityManager();
    }

    @Override
    public T save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.refresh(entity);
        return entity;
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.getTransaction().begin();
        T managedEntity = entityManager.merge(entity);
        entityManager.remove(managedEntity);
        entityManager.getTransaction().commit();
    }

    @Override
    public T findById(PK id) {
        entityManager.getTransaction().begin();
        T t = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return t;
    }

    @Override
    public List<T> findAll() {
        entityManager.getTransaction().begin();
        List<T> listT = entityManager.createQuery("FROM " + entityClass.getName(), entityClass).getResultList();
        entityManager.getTransaction().commit();
        return listT;
    }

}
