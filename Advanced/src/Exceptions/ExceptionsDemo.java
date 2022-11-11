package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionsDemo {
    public  static void show(){
        try {
            Account.deposit(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
