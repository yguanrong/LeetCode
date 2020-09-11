//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
// 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1813 👎 0


package leetcode.editor.cn;
public class NO11_ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = 
        new NO11_ContainerWithMostWater().new Solution();
    }

    /**
     * 贪心算法，一开始从最左边和最右边为界限开始算起。
     * 宽x=数组长度减一
     * 长y=两个下标中对应的值比较小的那个
     *
     * 然后判断一下左右指针所对应的值，移动值小的那一边。一直循环到left=right结束
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {

        int left  = 0;
        int right = height.length-1;
        int x = height.length-1;
        int y = Math.min(height[left],height[right]);

        int max = x*y;
        while (left<right){
            if (height[left] <= height[right]){
                left++;
            }else {
                right--;
            }
            x = right-left;
            y = Math.min(height[left],height[right]);
            int temp = x * y;
            if (max<temp){
                max = temp;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}