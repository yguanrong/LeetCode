//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2654 👎 0


package leetcode.editor.cn;
public class NO5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution =
                new NO5_LongestPalindromicSubstring().new Solution();
    }

    /**
     * 回文串分两种，一种是单个中心的，还有一种是双中心的。双中心的任取其左右一个来分析即可
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        String max = "";
    public String longestPalindrome(String s) {
        for (int i=0; i<s.length();i++){
            char c = s.charAt(i);
            findMax(s, i - 1, i + 1);
            if (i != 0 && c == s.charAt(i-1)){
                findMax(s, i - 2, i + 1);
            }
        }

        return max;
    }

    public void findMax(String s,int i,int j){
        for ( ;i>=0 && j< s.length() && s.charAt(i) == s.charAt(j) ;i--,j++){

        }
        if (max.length() < j- (i+1) ){
            max = s.substring(i+1,j);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}