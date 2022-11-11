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
        } catch ( InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

}
