package Greedy;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int n = height.length;
        int left = 0, right = n - 1;
        int maxArea = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * (right - left));
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        System.out.println("Maximum area: " + maxArea);
    }
}
