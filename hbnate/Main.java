package com.company;
import hibernate_test.entity.mms_entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.persistence.Entity;
import java.io.*;
import java.sql.*;
import java.io.PrintStream;


public class Main {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(mms_entity.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();

            mms_entity entity = new mms_entity(1, "asdfasdfasdf", 120000);

            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }


        /*
        try
        {
            db();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        */

        //read();
    }

    static void db() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@172.22.25.97:1521:akblast", "ibs", "1239870");
        Statement st = con.createStatement();
        String sql = "select * from Z#CLIENT where rownum < 10";
        PrintStream printStream = new PrintStream(System.out, true, "utf8");
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            String str = rs.getString("C_NAME");
            printStream.println(str);
        }
        con.close();
    }

    static void write()
    {
        try(FileWriter writer = new FileWriter("D:\\notes3.txt", false))
        {
            String text = "Hello Gold!";
            writer.write(text);
            writer.append('\n');
            writer.append('E');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    static void read()
    {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))){
             PrintStream printStream = new PrintStream(System.out, true, "utf8");

            try(FileWriter writer = new FileWriter("D:\\notes3.txt", false))
            {

                String line;
                while ((line = fileReader.readLine()) != null) {

                    if (!line.startsWith("--#")) {
                        printStream.println(line);
                        writer.write(line+'\n');
                        //writer.append('\n');

                    }
                }
                writer.flush();

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
//D:\фыва 1.bb