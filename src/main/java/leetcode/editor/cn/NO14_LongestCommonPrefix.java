//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1268 👎 0


package leetcode.editor.cn;
public class NO14_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = 
        new NO14_LongestCommonPrefix().new Solution();
    }

    /**
     *因为是前缀，所以可以假定第一个字符串是最长前缀，然后循环比较，不符合就把最后一位去掉
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length ==0){
            return "";
        }
        String temp = strs[0];
        for (int i=1; i<strs.length;i++){
            while (strs[i].indexOf(temp)!=0){
                temp = temp.substring(0,temp.length()-1);
            }
        }
        return temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}