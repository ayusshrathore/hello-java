import java.util.Stack;

public class StringReverser {

    // costly way to reverse a string
    public String altStringReverser(String inputString) {
        if (inputString == null)
            throw new IllegalArgumentException("Input string cannot be null");

        Stack<Character> stack = new Stack<>();
        for (int index = 0; index < inputString.length(); index++)
            stack.push(inputString.charAt(index));

        String newString = "";
        while (!stack.isEmpty())
            newString += stack.pop(); // since strings are immutable, on each iteration new string is created with new
                                      // memory so if input size is large, it will take more memory

        return newString;
    }

    // solution to above problem making use of StringBuffer
    public String reverse(String inputString) {
        if (inputString == null)
            throw new IllegalArgumentException("Input string cannot be null");

        Stack<Character> stack = new Stack<>();
        for (char ch : inputString.toCharArray())
            stack.push(ch);

        StringBuffer reversedString = new StringBuffer();
        while (!stack.isEmpty())
            reversedString.append(stack.pop());
        return reversedString.toString();
    }
}
