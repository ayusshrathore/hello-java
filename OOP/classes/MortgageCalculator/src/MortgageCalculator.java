// class responsible for calculating the mortgage
public class MortgageCalculator {
    // static fields (variables) because they are accessed by static methods
    private final static byte PERCENT = 100;
    private final static byte MONTHS = 12;

    // encapsulation in action below
    private int principal;
    private float annualInterestRate;
    private byte years;

    // constructor to initialize the private fields
    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float numberOfPayments = getMonthlyInterests();
        float monthlyInterest = getNumberOfPayments();

        double balance = principal * (Math.pow(1 + monthlyInterest, numberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        return balance;
    }

    public double calculateMortgae() {
        float numberOfPayments = getMonthlyInterests();
        float monthlyInterest = getNumberOfPayments();

        double mortgage = Math
                .round(principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        return mortgage;
    }

    public double[] getRemainingBalance() {
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            // month - 1 because array start with index 0
            balances[month - 1] = calculateBalance(month);
        return balances;
    }

    // extracting the duplicate code and storing it in a method
    public float getMonthlyInterests() {
        return annualInterestRate / MortgageCalculator.PERCENT / MortgageCalculator.MONTHS;
    }

    public int getNumberOfPayments() {
        return years * MortgageCalculator.MONTHS;
    }
}
