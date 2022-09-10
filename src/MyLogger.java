import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MyLogger {
    File file = new File("output.txt");
    int ok = 1;

    public MyLogger() {
    }

    public void myLog(String text) {
        if (ok == 0) {
            System.out.println(text);
        } else {
            try {
                Writer writer = new FileWriter(file);
                writer.write(text);
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
