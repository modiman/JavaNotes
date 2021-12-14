package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ExceptionTest {
    public static void main(String[] args) {
        ExceptionTest et = new ExceptionTest();
        et.readFile("E:\\oneDrive\\桌面\\文章\\TransE.doc");

    }
   public void readFile(String fileName){
        try {
            InputStream in = new FileInputStream(fileName);
            int b;
            while ((b = in.read())!=-1){
                System.out.println(b);
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
   }
}
