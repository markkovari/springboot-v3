package com.example.demov3;

import com.example.demov3.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoV3Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoV3Application.class, args);
    }

    public static Session getCurrentSession() {
        Map<String, Object> settings = new HashMap<>();
        settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
        settings.put("dialect", "org.hibernate.dialect.MySQL8Dialect");
        settings.put("hibernate.connection.url", "jdbc:mysql://localhost/v3demo");
        settings.put("hibernate.connection.username", "root");
        settings.put("hibernate.connection.password", "asdasd");
        settings.put("hibernate.current_session_context_class", "thread");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.format_sql", "true");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(settings).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry).addAnnotatedClass(Person.class);
        Metadata metadata = metadataSources.buildMetadata();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.getCurrentSession();
        return session;
    }


    @Override
    public void run(String... args) throws Exception {
        Session session = getCurrentSession();
        Transaction tx = session.beginTransaction();
        Person firstPerson = session.find(Person.class, 1L);
        System.out.println("id:" + firstPerson.getId() + ", username:" + firstPerson.getName());
        tx.commit();
    }
}
