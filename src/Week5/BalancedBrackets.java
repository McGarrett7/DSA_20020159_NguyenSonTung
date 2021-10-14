package Week5;

import java.util.Stack;

public class BalancedBrackets {
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                } else {
                    if (x == ')' && stack.pop() != '('){
                        return "NO";
                    }
                    else if (x == '}' && stack.pop() != '{'){
                        return "NO";
                    }
                    else if (x == ']' && stack.pop() != '['){
                        return "NO";
                    }
                }
            }
        }
        if (stack.isEmpty()) return "YES";
        else return "NO";
        //return (stack.isEmpty() ? "YES" : "NO");
    }

    public static void main(String[] args){
        String s = "([{}])";
        System.out.print(isBalanced(s));
    }
}