package com.tms.homework_40_v2.config;

import com.tms.homework_40_v2.domain.Course;
import com.tms.homework_40_v2.domain.Student;
import com.tms.homework_40_v2.domain.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class DataBaseConfig {

    @Bean
    SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "admin");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");
        properties.put(Environment.SHOW_SQL, "true");

        configuration.addProperties(properties);

        configuration.addAnnotatedClass(Teacher.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Student.class);

        return configuration.buildSessionFactory();
    }

}
