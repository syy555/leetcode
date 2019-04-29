package cat.leetcodes.L11_ContainerWithMostWater;

//方法2 由于计算的是面积所以取开始边与结束边，依次往里收缩，每次由短边往里收缩，并记录面积 时间复杂度0(n) 空间复杂度 O(1)
public class Solution2 {
    public int maxArea(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}