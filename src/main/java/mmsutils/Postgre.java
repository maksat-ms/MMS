package mmsutils;

import java.sql.*;

public class Postgre {
    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/mmsdb";
    static final String USER = "postgres";
    static final String PASS = "sysdba";

    public Connection GetConnection() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return null;
        }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return null;
        }

        return connection;
    }

    public void read(Connection connection, String sql) throws SQLException
    {
        try
        {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String str = resultSet.getString(1);
                IO.println(str);
            }
        }
        finally{
            connection.close();
        }
    }
}