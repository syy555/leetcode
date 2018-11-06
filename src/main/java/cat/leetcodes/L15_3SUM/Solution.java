package cat.leetcodes.L15_3SUM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//该方法没问题，但是实际跑leetcode的时候执行超时，所以需要优化逻辑
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length >= 3) {
            for (int i = 0; i < nums.length; i++) {
                if(i>0 && nums[i] == nums[i-1]){
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if(k>j + 1 && nums[k] == nums[k-1]){
                            continue;
                        }
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            boolean jump = false;
                            List<Integer> temp = new ArrayList();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            for (List a : list) {
                                if (a.equals(temp)) {
                                    jump = true;
                                }
                            }
                            if (!jump) {
                                list.add(temp);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

}