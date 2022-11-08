public class Main {
    public static void main(String[] args) {
        // Role of this class is to inject dependency: Constructor injection in action
        var calculator = new TaxCalculator2021(10_000);
        var report = new TaxReport(calculator);
        report.show();

        // illustration for injection using setter
        report.setCalculator(new TaxCalculator2020());
        report.show();

        // method injection
        // report.show(new TaxCalculator2020());
    }
}
