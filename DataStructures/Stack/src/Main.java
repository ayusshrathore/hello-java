import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        // inbuilt stack class
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        var top = stack.pop();
        System.out.println(top);
        System.out.println(stack);
        var tos = stack.peek();
        System.out.println(tos);

        // reverse a string using stack
        Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter String to be reverse: ");
        // String str = scanner.nextLine();

        // // alt method
        // StringReverser stringReverser = new StringReverser();
        // var reversed = stringReverser.reverse(str);
        // var altReversed = stringReverser.altStringReverser(str);

        // System.out.println("Reversed String is: " + reversed);
        // System.out.println("Alt Reversed String is: " + altReversed);

        // Balance string problem
        // System.out.print("Enter String to check if it is balanced: ");
        // String inputString = scanner.nextLine();
        // Expression expression = new Expression(inputString);
        // var isBalanced = expression.altisBalanced();
        // System.out.println(isBalanced ? "String is balanced" : "String is not
        // balanced");
        scanner.close();

        // Custom Stack class
        customStack stack2 = new customStack(4);
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        stack2.push(4);
        System.out.println(stack2.toString());
        top = stack2.pop();
        System.out.println(stack2.toString());
        System.out.println(stack2.peek());

    }
}
