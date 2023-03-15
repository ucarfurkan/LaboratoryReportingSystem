package com.ucarfurkan.LaboratoryReportingSystem.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerProvider {

    private static final EntityManagerFactory emFactory =
            Persistence.createEntityManagerFactory("my-persistence-unit");

    private static final EntityManager em = emFactory.createEntityManager();

    private EntityManagerProvider() {}

    public static EntityManager getEntityManager() {
        return em;
    }

    public static void closeEntityManager() {
        em.close();
        emFactory.close();
    }
}
