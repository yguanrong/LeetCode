//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1268 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class NO31_NextPermutation {
	public static void main(String[] args) { 
		new NO31_NextPermutation().new Solution().nextPermutation(new int[]{1,2});
	}

   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
       /**
        * 总体思路就是从尾部往前先找到第一个nums[i]比它前一个nums[i-1]大的，
        * 然后在这个nums[i]以及它的后面找到一个最小的nums[j]>nums[i-1], 将nums[i-1]与nums[j]互换过后再把nums[i]到尾部进行排序
        * @param nums
        */
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int i = 0,minIndex = 0,min = 0;
        for( i = nums.length-1; i > 0 ;i--){
            if(nums[i]>nums[i-1]){
                min = nums[i];
                minIndex = i;
                for(int j = nums.length-1;j >= i;j--){
                    if(nums[j]<min&&nums[j]>nums[i-1]) {
                        min = nums[j];
                        minIndex = j;
                    }
                }
                nums[minIndex] = nums[i-1];
                nums[i-1] = min;
                Arrays.sort(nums,i,nums.length);
                break;
            }
        }
        if(i == 0) Arrays.sort(nums);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}