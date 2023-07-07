import java.util.Arrays;

/**
 * @author huangxuewei
 * @since 2023/7/7
 */
public class Solution20230707 {

    public int maxArea(int[] height) {
        int ret = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int length = r - l;
            int width = Math.min(height[l], height[r]);
            int area = length * width;
            if (area > ret) {
                ret = area;
            }
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution20230707 solution = new Solution20230707();

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("height: " + Arrays.toString(height) + ", Result is: " + solution.maxArea(height));

        height = new int[]{1, 1};
        System.out.println("height: " + Arrays.toString(height) + ", Result is: " + solution.maxArea(height));
    }
}
