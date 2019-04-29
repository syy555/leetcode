package cat.leetcodes.L3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

//传统方法，遍历string里任意一个string 判断是否包含重复字符，如果没有则记录其长度，取最大值。需要循环3次，时间复杂度O(n3)
public class Solution1 {
    public  int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }
}
