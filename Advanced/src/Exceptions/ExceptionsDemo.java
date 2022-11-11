package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionsDemo {
    public  static void show(){
        // try with resources
        try (
                FileReader reader = new FileReader("file.txt");
                var writer = new FileWriter("file2.txt");
        ) {
            var value = reader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
