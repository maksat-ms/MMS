package mmsutils;

import java.sql.*;

public class Orcl {

    public Connection getConnection(String url, String user, String pass ) throws SQLException
    {
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        //Class.forName("oracle.jdbc.OracleDriver");
        Connection conn;
        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    public void read(Connection conn, String sql) throws SQLException
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
