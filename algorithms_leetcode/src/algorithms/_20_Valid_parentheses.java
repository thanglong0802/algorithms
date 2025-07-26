package algorithms;

import java.util.Stack;

public class _20_Valid_parentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(){}["));
    }

    public static boolean isValid(String s) {
        int length = s.length();

        if (s.length() % 2 != 0) {
            System.out.println("Dấu mở đóng phải là 1 đôi");
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
                if (stack.empty()) {
                    return false;
                }
                char topChar = stack.pop();
                if ((currentChar == ')' && topChar != '(') || (currentChar == '}' && topChar != '{') || (currentChar == ']' && topChar != '[')) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}
