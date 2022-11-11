package Exceptions;

import java.io.IOException;

public class Account {
    private float balance;

    public void deposit(float value) throws IOException {
        // Defensive programming preventing rest of the code from being executed
        // Adding this validation logic add some bit of noise to our code it makes it much longer
        // & verbose it is better to use this type of programming while taking input from user
        // or building a library or framework for others to use, don't pollute the every application
        // with data validation
        if(value <=0) throw new IOException();
    }
    public void withdraw(float value) throws AccountException {
        if (value > balance) {
            var fundsException = new InsufficientFundsException();
            var accountException =  new AccountException();
            accountException.initCause(fundsException);
            throw accountException;
        }
    }
}
