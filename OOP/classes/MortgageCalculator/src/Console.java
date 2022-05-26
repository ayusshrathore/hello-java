import java.util.Scanner;

public class Console {
    // private static scanner field
    private static Scanner scanner = new Scanner(System.in);

    // below method is overloaded where first implementation is for just reading the
    // number & in 2nd implementation we are passing the min and max values too
    public static double readNumber(String prompt) {
        return scanner.nextDouble();
    }

    public static double readNumber(String prompt, double min, double max) {
        double value = 0;

        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Principal must be between" + min + "and" + max);
        }
        return value;

    }
}
