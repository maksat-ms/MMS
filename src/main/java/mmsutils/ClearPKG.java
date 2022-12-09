package mmsutils;

import java.io.*;

public class ClearPKG {

    public BufferedReader read(String fileName) throws FileNotFoundException{
        FileReader fileReader = new FileReader(fileName);
        BufferedReader buffReader = new BufferedReader(fileReader);
        return buffReader;
    }

    public void write(BufferedReader buffReader, String fileName) throws IOException{

        String newFileName = fileName.substring(0, fileName.length()-4) + "_new" + fileName.substring(fileName.length()-4);
        FileWriter writer = new FileWriter(newFileName , false);

        String line;
        while ((line = buffReader.readLine()) != null) {
            if (!line.startsWith("--#")) {
                writer.write(line+'\n');
            }
        }
        writer.flush();
    }

    public void start(String fileName) throws IOException {
        BufferedReader buffReader = read(fileName);
        write(buffReader, fileName);
    }

}
