package cat.leetcodes.L11ContainerWithMostWater;

//方法1 .遍历所有两个边并计算面积取最大值 时间复杂度0(n2) 空间复杂度 O(1)
public class Solution1 {
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }
}