package homework.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionConfig {

    public void initialization() {
        try {
            Class.forName("org.postgresql.Driver");
            getConnection().createStatement().execute("drop table if exists cars");
            getConnection().createStatement().execute("create table cars" +
                    "(" +
                    " id int primary key, " +
                    " brand varchar, " +
                    " model varchar, " +
                    " cost int" +
                    ")"
            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException();
        }

        System.out.println("Таблица пересоздана");
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/cars", "postgres", "admin");
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}