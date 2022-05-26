import java.text.NumberFormat;

// class responsible for presenting the report
public class MortgageReport {
    private MortgageCalculator calculator;
    private final NumberFormat currency;

    // constructor to initialize the calculator field
    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgae();
        System.out.println();
        System.out.println("MORTAGE");
        System.out.println("-------");
        System.out.println("Monthly Payments: " + currency.format(mortgage));
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("---------------");
        for (double balance : calculator.getRemainingBalance())
            System.out.println(currency.format(balance));
    }
}
