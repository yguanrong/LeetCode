//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 
// 👍 608 👎 0


package leetcode.editor.cn;
public class NO16_ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = 
        new NO16_ThreeSumClosest().new Solution();
    }

    /**
     * 暴力解法
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<nums.length; i++){
            for (int j = i+1; j<nums.length; j++){

                for (int k = j+1; k<nums.length; k++){
                    int tsum =  nums[i] + nums[j] + nums[k];
                    int temp = Math.min(Math.abs(target-tsum),min);
                    if (temp != min){
                        min = Math.abs(target-tsum);
                        sum = tsum;
                    }
                }

            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}