import java.util.Stack;

public class Main {

    public static boolean validate(String input) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input1 = "()";
        String input2 = "(()()((())))";
        String input3 = "(((())()";
        System.out.println(validate(input1)); // true
        System.out.println(validate(input2)); // true
        System.out.println(validate(input3)); // false
    }
}
