package mmsutils;

import java.sql.*;

public class Postgre {
    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/mmsdb";
    static final String USER = "postgres";
    static final String PASS = "sysdba";

    public static void test() {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            read(connection, "select fio from fio_list");

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }

    public static void read(Connection conn, String sql) throws SQLException
    {
        try
        {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String str = resultSet.getString(1);
                IO.println(str);
            }
        }
        finally{
            conn.close();
        }
    }
}