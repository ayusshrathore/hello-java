package Exceptions;

// Checked -> Exception
// Unchecked (runtime) -> RuntimeException
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(){
        super("Insufficient funds in you account.");
    }
    public InsufficientFundsException(String message){
        super(message);
    }
}
