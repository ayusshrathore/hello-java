package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionsDemo {
    public  static void show(){
        FileReader reader = null;
        try{
            reader = new FileReader("file.txt");
            var value = reader.read();
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(reader != null ) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

}
