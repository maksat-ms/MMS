package mmsutils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try {
            TestClearPKG();
        }
        catch (Exception e)
        {
            IO.println(e.getMessage());
        }
    }

    public static void TestOrcl() throws SQLException {
        Orcl orcl = new Orcl();
        Connection conn = orcl.getConnection("jdbc:oracle:thin:@172.22.25.97:1521:akblast", "ibs", "1239870");
        orcl.read(conn, "select C_NAME from Z#CLIENT where rownum < 10");
    }

    public static void TestClearPKG() throws IOException {
        ClearPKG clearPKG = new ClearPKG();
        clearPKG.start("D:\\tst0.txt");
    }


}
