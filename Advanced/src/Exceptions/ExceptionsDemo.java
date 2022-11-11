package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionsDemo {
    public  static void show() throws IOException {
        try {
            Account.deposit(-1);
        } catch (IOException e) {
            System.out.println("Logging");
            throw e;
        }
    }

}
