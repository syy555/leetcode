package cat.leetcodes.L4MedianOfTwoSortedArrays;

//todo 方法二，比较两个数组的中位数，然后取中位数小的后半数组跟中位数大的前半数组合成新数组求中位数
public class Solution2 {
    public  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = nums1.length + nums2.length;
        int[] nums3 = new int[x];
        int p = 0, q = 0, index = 0;
        while (p < nums1.length && q < nums2.length) {
            if (nums1[p] < nums2[q]) {
                nums3[index] = nums1[p];
                p++;
            } else {
                nums3[index] = nums2[q];
                q++;
            }
            index++;
        }
        while (p < nums1.length) {
            nums3[index] = nums1[p];
            p++;
            index++;
        }
        while (q < nums2.length) {
            nums3[index] = nums2[q];
            q++;
            index++;
        }
        if(x ==0){
            return 0.0;
        }
        if (x % 2 == 1) {
            return nums3[x / 2];
        }
        return (nums3[x / 2] + nums3[(x / 2) - 1]) / 2.0;
    }

    public  double  findMedian(int[] nums) {
        int x = nums.length;
        if(x ==0){
            return 0.0;
        }
        if (x % 2 == 1) {
            return nums[x / 2];
        }
        return (nums[x / 2] + nums[(x / 2) - 1]) / 2.0;
    }
}
