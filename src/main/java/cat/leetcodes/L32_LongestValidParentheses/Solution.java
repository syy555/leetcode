package cat.leetcodes.L32_LongestValidParentheses;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int result = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i+2;j<=s.length();j+=2){
                String s1 = s.substring(i,j);
                if(s1.length()<=result){
                    continue;
                }
                if(isStringValid(s1)){
                    result = Math.max(result,j-i);
                }

            }
        }
        return result;
    }

    private boolean isStringValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            Character c = chars[i];
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.empty() || stack.pop() != c) {
                        return false;
                    }
            }
        }
        return stack.empty();
    }
}