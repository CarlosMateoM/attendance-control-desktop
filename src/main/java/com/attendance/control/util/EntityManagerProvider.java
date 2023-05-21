package com.attendance.control.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private EntityManager em;
    private static EntityManagerProvider instance = null;

    private EntityManagerProvider() {
        em = Persistence
                .createEntityManagerFactory("attendanceControlPersistence")
                .createEntityManager();
    }

    public static EntityManagerProvider getInstance() {
        if (instance == null) {
            instance = new EntityManagerProvider();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
