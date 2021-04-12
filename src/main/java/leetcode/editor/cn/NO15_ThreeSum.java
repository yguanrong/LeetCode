//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在
// 三个元素 a，b，c ，使得 a + b + c = 0 ？
// 请你找出所有满足条件且不重复
//的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2796 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class NO15_ThreeSum {
    public static void main(String[] args) throws InterruptedException {
        int[] num = {0,0,0,0};
//        Solution solution =
        new NO15_ThreeSum().new Solution().threeSum(num);

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 首先对数组进行排序，排序后固定一个数 nums[i]，
         * 再使用左右指针指向 nums[i]后面的两端，数字分别为 nums[L] 和 nums[R]，
         * 计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
         * 如果 nums[i[大于 0，则三数之和必然无法等于 0，结束循环
         * 如果 nums[i] == nums[i-1]，则说明该数字重复，会导致结果重复，所以应该跳过
         * 当 sum==0 时，nums[L] == nums[L+1]则会导致结果重复，应该跳过，L++
         * 当 sum== 00 时，nums[R] == nums[R-1] 则会导致结果重复，应该跳过，R--
         *
         * @param nums
         * @return
         */
    public List<List<Integer>> threeSum(int[] nums) {
        //结果链表
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        //先进行排序
        Arrays.sort(nums);
        for(int i = 0;i < len-2; i ++){
            //大于0提前结束
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    //数字一样跳过 防止重复
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<right&&nums[left]==nums[left+1])
                        left++;
                    while(left<right&&nums[right]==nums[right-1])
                        right--;
                    left ++;
                    right --;
                }
                //小 右移
                else if(sum <0) left++;
                    //大 左移
                else  if(sum>0) right--;
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}