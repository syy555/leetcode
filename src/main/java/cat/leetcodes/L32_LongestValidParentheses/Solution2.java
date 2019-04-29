package cat.leetcodes.L32_LongestValidParentheses;


import java.util.Stack;

public class Solution2 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int length[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else if (!stack.isEmpty()) {
                int top = stack.peek();
                length[i] = i - top + 1;
                length[i] += top == 0 ? 0 : length[top - 1];
                stack.pop();
                max = Math.max(max, length[i]);
            }
        }
        return max;
    }
}