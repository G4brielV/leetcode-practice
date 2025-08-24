package Easy;

import java.util.*;

public class validParentheses_23082025 {

    //https://leetcode.com/problems/valid-parentheses/description/

    public static void main(String[] args) {
        List<String> inputs = Arrays.asList("]", "()", "()[]{}", "(]", "([])", "([)]");
        List<Boolean> results = inputs.stream()
                        .map(input -> isValid1(input))
                        .toList();
        System.out.println(results);
    }

    public static boolean isValid1(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top== '(') continue;
                else if (c == ']' && top == '[') continue;
                else if (c == '}' && top == '{') continue;
                else return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {

        ArrayDeque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
        HashMap<Character, Character> hashmap= new HashMap<>(map);

        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else {
                if (!stack.isEmpty() && hashmap.get(c) == stack.pop()) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
