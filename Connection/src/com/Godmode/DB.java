package com.Godmode;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    private final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private final String URL = "jdbc:derby:sampleDB;create=true";
    private final String USERNAME = "";
    private final String PASSWORD = "";

    private Connection connection = null;
    private Statement createStatement = null;

    public DB() {
        try  {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Hiba a kapcsolattal: " + e);
        }

        if (connection != null) {
            try {
                createStatement = connection.createStatement();
            } catch (SQLException e) {
                System.out.println("Nem sikerült létrehozni a kapcsolatot: " + e);
            }
        }

        DatabaseMetaData databaseMetaData = null;
        try {
            databaseMetaData = connection.getMetaData();
        } catch (SQLException e) {
            System.out.println("A DatabaseMetaData nem jött létre: " + e);
        }

        try {
            ResultSet resultSet = databaseMetaData.getTables(null, "APP", "USERS", null);
            if (!resultSet.next()) {
                createStatement.execute("CREATE TABLE users(name varchar(20), address varchar(20))");
            }
        } catch (SQLException e) {
            System.out.println("Az adattáblák nem jöttek létre: " + e);
        }
    }

//    public void simpleAddUser(String name, String address) {
//        try {
//            String sql = "INSERT INTO users VALUES ('" + name + "','" + address + "')";
//            createStatement.execute(sql);
//        } catch (SQLException e) {
//            System.out.println("Az adatok hozzáadása nem sikerült: " + e);
//        }
//    }

    public void preparedAddUser(String name, String address) {
        try {
            String sql = "INSERT INTO users VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Az adatok hozzáadása nem sikerült: " + e);
        }
    }

    public void showAllUsers() {
        String sql = "SELECT * FROM users";
        try {
            ResultSet resultSet = createStatement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                System.out.println(name + " | " + address);
            }
        } catch (SQLException e) {
            System.out.println("Az adatok lekérdezése nem sikerült: " + e);
        }
    }

    public void showUsersMeta() {
        String sql = "SELECT * FROM users";
        ResultSet resultSet = null;
        ResultSetMetaData resultSetMetaData = null;
        try {
            resultSet = createStatement.executeQuery(sql);
            resultSetMetaData = resultSet.getMetaData();
            int coloumnCount = resultSetMetaData.getColumnCount();
            for (int i = 1; i <= coloumnCount; i++) {
                System.out.print(resultSetMetaData.getColumnName(i) + " | ");
            }
            System.out.println("\r");
        } catch (SQLException e) {
            System.out.println("Az oszlopok lekérdezése nem sikerült: " + e);
        }
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = null;
        String sql = "SELECT * FROM users";
        try {
            ResultSet resultSet = createStatement.executeQuery(sql);
            users = new ArrayList<>();

            while (resultSet.next()) {
                User actualUser = new User(resultSet.getString("name"), resultSet.getString("address"));
                users.add(actualUser);
            }
        } catch (SQLException e) {
            System.out.println("Az lekérdezés nem sikerült: " + e);
        }
        return users;
    }

    public void addUser(User user) {
        try {
            String sql = "INSERT INTO users VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Az adatok hozzáadása nem sikerült: " + e);
        }
    }
}
