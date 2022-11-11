package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExceptionsDemo {
    public  static void show() throws IOException {
        try {
            var account = new Account();
            account.withdraw(1000);
        } catch ( AccountException e) {
            var cause = e.getCause();
            System.out.println(cause.getMessage());
            e.printStackTrace();
        }
    }

}
