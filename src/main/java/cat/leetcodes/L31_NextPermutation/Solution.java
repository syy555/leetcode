package cat.leetcodes.L31_NextPermutation;

public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }
        Integer temp = null;
        int index = 0;
        int targetIndex = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (temp != null && temp > nums[i]) {
                temp = nums[i];
                index = i;
                break;
            }
            temp =nums[i];
        }
        if (index == 0 && nums[0]>nums[1]) {
            reverse(nums,0);
        } else {
            Integer target = null;
            for (int i = index; i < nums.length; i++) {
                if (nums[i] > temp && (target == null || target >= nums[i])) {
                    target = nums[i];
                    targetIndex = i;
                }
            }
            nums[index] = target;
            nums[targetIndex] = temp;
            reverse(nums,index+1);
        }
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}