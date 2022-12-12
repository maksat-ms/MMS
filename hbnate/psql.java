import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class psql {

    public void connect() throws UnsupportedEncodingException {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sysdba");
        } catch (Exception e) {


            e.printStackTrace();

            PrintStream out = new PrintStream(System.out, true, "UTF-8");
            out.println(e.getClass().getName()+": "+e.getMessage());



        }
        System.out.println("Opened database successfully");
    }


    public void insert() throws UnsupportedEncodingException {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "sysdba");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "insert into tnames(id, fio, descr)values(1, 'Peter', 'driver');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {

            PrintStream out = new PrintStream(System.out, true, "UTF-8");
            out.println(e.getClass().getName()+": "+e.getMessage());



        }
        System.out.println("Records created successfully");
    }


}