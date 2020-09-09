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