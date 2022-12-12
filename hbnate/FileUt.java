        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.11.0</version>
        </dependency>


package FileUtils;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class FileUt {
    public static void main(String[] args) {
        File tempDirectory = FileUtils.getTempDirectory();
        System.out.println(tempDirectory.toString());
    }
}