package cat.leetcodes.L5_LongestPalindromicSubstring;

//方法，遍历每一个char，先以当前char为中心，像两边遍历，再以当前char跟当前char的下一个char为节点像两边遍历，每次把最长的字符记下，最后输出。
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);//判断奇数位的
            int len2 = expandAroundCenter(s, i, i + 1);//判断偶数位的
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}