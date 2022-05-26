import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    // static fields (variables) because they are accessed by static methods
    final static byte MONTHS = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) throws Exception {
        int principal = (int) readNumber("Principal", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Annual Interest Rate", 1, 30);
        byte years = (byte) readNumber("Period (Years)", 1, 30);

        printMortgage(principal, annualInterestRate, years);
        printPaymentSchedule(principal, annualInterestRate, years);

    }

    private static void printMortgage(int principal, float annualInterestRate, byte years) {
        double mortgage = calculateMortgae(principal, annualInterestRate, years);
        System.out.println();
        System.out.println("MORTAGE");
        System.out.println("-------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    private static void printPaymentSchedule(int principal, float annualInterestRate, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("---------------");
        for (short month = 1; month <= years * MONTHS; month++) {
            double balance = calculateBalance(principal, annualInterestRate, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value = 0;

        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextFloat();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Principal must be between" + min + "and" + max);
        }
        return value;

    }

    public static double calculateBalance(int principal, float annualInterestRate, byte years,
            short numberOfPaymentsMade) {
        short numberOfPayments = (short) (years * MONTHS);
        float monthlyInterest = annualInterestRate / PERCENT / MONTHS;

        double balance = principal * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public static double calculateMortgae(int principal, float annualInterestRate, byte years) {

        short numberOfPayments = (short) (years * MONTHS);
        float monthlyInterest = annualInterestRate / PERCENT / MONTHS;

        double mortgage = Math
                .round(principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        return mortgage;
    }
}
