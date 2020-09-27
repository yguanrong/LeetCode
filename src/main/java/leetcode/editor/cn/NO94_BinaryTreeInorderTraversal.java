//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 685 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NO94_BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = 
        new NO94_BinaryTreeInorderTraversal().new Solution();
    }

    /**
     * 中序遍历，就是先访问左节点，再访问根节点，最后访问有节点。这里使用递归来遍历，先递归遍历
     *
     */
    
    //leetcode submit region begin(Prohibit modification and deletion)

//  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null){
            return list;
        }
        if (root.left !=null){
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if (root.right !=null){
            inorderTraversal(root.right);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}