package cat.leetcodes.L15_3SUM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //先给num排序
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // 结果相同则跳过
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            //用两个指针分别从前后像中间遍历，左边移动时总和增加，右边移动时总和减少
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  //总和小于目标值，左边增加一位 结果相同则跳过
                    while (j < k && nums[k] == nums[k + 1]) k--;  // 总和大于目标值，右边减少一位 结果相同则跳过
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

}