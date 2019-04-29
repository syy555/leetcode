package cat.leetcodes.L3_LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

// 思路，方法2思路如下，首先用两个指针，第一个指针遍历string的每一个char，并把每次找到的char的位置记录到map里，
// 若重复则更新。第二个指针用来定位map里相同的char的位置，思路是寻找string里两个相同的char的最大间距，时间复杂度 O(n)

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
