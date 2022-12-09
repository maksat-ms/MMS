package mmsutils;

import java.nio.charset.StandardCharsets;
import java.io.PrintStream;

public class IO {

    public static void println(String text)
    {
        try {
            PrintStream printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8);
            printStream.println(text);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
