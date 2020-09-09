//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 472 👎 0


package leetcode.editor.cn;

import java.util.*;

public class NO347_TopKFrequentElements {
    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,3};
        new NO347_TopKFrequentElements().new Solution().topKFrequent(a,2);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<nums.length;i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        List[] bluct = new List[nums.length+1];

        for (Map.Entry<Integer,Integer> m: map.entrySet()){
            Integer value = m.getValue();
            if (bluct[value] ==null){
                bluct[value] = new ArrayList();
            }
            bluct[value].add(m.getKey());
        }
        int x=0;
        for (int i=bluct.length-1; i > -1 && x<k ;i--){
            if (bluct[i]!= null){

                for (int j = 0; j<bluct[i].size();j++) {
                    res[x]=(int)bluct[i].get(j);
                    x++;
                }

            }

        }


        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}