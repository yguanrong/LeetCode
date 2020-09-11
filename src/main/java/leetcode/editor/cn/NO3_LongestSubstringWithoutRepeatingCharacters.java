//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4270 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class NO3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution =
                new NO3_LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    /**
     * 遍历一遍字符串，然后把字符放到一个map集合中，
     * 新建一个数组，大小为字符串长度加一。改数组的下标就是不重复字符的长度。
     * 利用map集合key的唯一性
     * 当下次再遇到该值时说明遇到重复字符了，就把map的大小作为数组下标给数组赋值为1，。然后清空map，指针移到下一个字符开始遍历
     * 最后从下标最大的地方开始遍历数组，如果值等于1，就输出该数组下标
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> map = new HashMap<>();
        int[] value = new int[s.length()+1];
        char[] temp = s.toCharArray();
        for (int i =0; i< temp.length; i++ ){
            for (int j = i; j<temp.length;j++){
                if (map.containsKey(temp[j])){
                    value[map.size()] = 1;
                    map.clear();
                    break;
                }else {
                    map.put(temp[j], 1);
                }
            }
        }

        for (int i =temp.length; i > 0 ; i-- ){
            if (value[i] ==1 ){
                return i;
            }
        }
        if (s.length()>0){
            return 1;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}