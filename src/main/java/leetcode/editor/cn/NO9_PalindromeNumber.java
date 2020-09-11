//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1219 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;

public class NO9_PalindromeNumber {
    public static void main(String[] args) {
        Solution solution =
        new NO9_PalindromeNumber().new Solution();
    }

    /**
     * 思路：不转成字符串的做法：
     * 回文数的特点是从左边读和从右边读是一样的，所以考虑到链表的数据结构：
     *  把x取余，把每一位分别放到链表中，然后遍历链表，每次遍历把链表的头一位和尾一位一起弹出链表，
     *  然后对这两个数做比较，如果不相等,则返回false
     */
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }else if (x< 10){
            return true;
        }else {
            boolean flag = true;
            LinkedList<Integer> llink = new LinkedList<>();
            while (x>0){
                llink.add(x%10);
                x = x/10;
            }
            while (llink.size()>1){
                int a = llink.pollFirst();
                int b = llink.pollLast();
                if (a != b){
                    flag=false;
                    break;
                }
            }
            return flag;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}