//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1743 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NO22_GenerateParentheses {
    public static void main(String[] args) {
        new NO22_GenerateParentheses().new Solution().generateParenthesis(4);
    }

    /**
     * 回溯法解决问题：
     * 类似于深度优先的问题。先向下去查找符合要求的答案，指导不满足之后才退回上一步采取第二种方式。
     * 类似二叉树的深度遍历，先查看左子树的深度，如果左子树为空了就返回父节点，向右子树遍历
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);

        return res;
    }
        //count1统计“(”的个数，count2统计“)”的个数
        public void generate(List<String> res , String ans, int count1, int count2, int n){

            if(count1 > n || count2 > n) return;

            if(count1 == n && count2 == n)  res.add(ans);


            if(count1 >= count2){
                String ans1 = new String(ans);
                generate(res, ans+"(", count1+1, count2, n);
                generate(res, ans1+")", count1, count2+1, n);

            }
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}