package com.util.factory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryUtil {

    private static final SessionFactory sf = buildSessionFactory();

    private SessionFactoryUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        return new MetadataSources(reg)
                .buildMetadata()
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }

}
