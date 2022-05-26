
public class Main {

    // Each class should have a single responsiblity
    // Class 1: to read numbers from console
    // Class 2: to print mortgage report
    // Class 3: to print payment schedule

    public static void main(String[] args) throws Exception {
        int principal = (int) Console.readNumber("Principal", 1000, 1_000_000);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years)", 1, 30);

        // calculator object to access pricipal, annualInterestRate & years
        var calculator = new MortgageCalculator(principal, annualInterestRate, years);

        // report object and pass the calculator to it to be able to use it's methods
        // instead of creating two seperate objects from MortgageReport class
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();

    }

    // whenever we have two methods having same type of parameters, we can apply
    // encapsulation and transform parameters and methods applied on them into
    // single object
    // so instead of passing the same parameters we will be storing them in fields
    // of the class

}
