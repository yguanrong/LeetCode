//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9047 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class NO1_TwoSum {
    public static void main(String[] args) {
        Solution solution = new NO1_TwoSum().new Solution();
    }

    /**
     * 思路：
     * 把每一位数的补数放到一个map集合的key中，然后遍历数组，
     * 判断map中是否存在数组中的该值，如果存在，那么将其下标取出返回
     */

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> temp = new HashMap<>();
        Map<Integer,Integer> numsMap = new HashMap<>();
        int[] res = new int[2];
        for (int i =0; i<nums.length; i++){
            numsMap.put(nums[i],i);
            temp.put(target-nums[i],i);
        }

        for (int i =0; i<nums.length; i++){
            if (temp.get(nums[i]) != null){
                if (i == numsMap.get(target-nums[i]))
                {
                    continue;
                }
                res[0] = i;
                res[1] = numsMap.get(target-nums[i]);
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}