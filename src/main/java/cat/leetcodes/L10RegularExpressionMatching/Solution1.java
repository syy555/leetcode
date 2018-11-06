package cat.leetcodes.L10RegularExpressionMatching;

public class Solution1 {
    public boolean isMatch(String text, String pattern) {
        if (pattern == null || pattern.isEmpty())
            return text.isEmpty();
        //判断第一个字符是否匹配
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            //对于pattern前两个是X*的组合，如果第一个字符不匹配，则可能是之前匹配过X*的组合并substring（1）移除了，则确认
            //已经完成对X*的匹配，那么可以直接从pattern里移除X*规则，继续向后匹配。否则认为当前第一个字母完成匹配，继续匹配下一个。
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            //对于pattern前两个不是X*的组合，则确认是一对一匹配，则递归判断两个字符都移除当前已匹配结果后的递归
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

}