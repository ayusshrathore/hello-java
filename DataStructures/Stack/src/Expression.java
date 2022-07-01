import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private String inputString;
    private final List<Character> leftBrackets = Arrays.asList('(', '[', '<', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', ']', '>', '}');

    public Expression(String inputString) {
        this.inputString = inputString;
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    public boolean altisBalanced() {
        if (inputString == null || inputString.isEmpty())
            throw new IllegalArgumentException("Input string cannot be null or empty");

        Stack<Character> stack = new Stack<>();
        for (char ch : inputString.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.isEmpty())
                    return false;

                if (!bracketMatch(stack.peek(), ch))
                    return false;
                stack.pop();
            }

        }

        return stack.isEmpty() ? true : false;

    }
}
