package com.attendance.control.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerProvider {

    private final EntityManager em;
    private static EntityManagerProvider instance = null;
    private static final String PERSISTENCE_UNIT_NAME = "attendanceControlPersistence";

    private EntityManagerProvider() {
        em = Persistence
                .createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
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
