//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 895 👎 0


package leetcode.editor.cn;
public class NO24_SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        h1.next=new ListNode(2);
        h1.next.next=new ListNode(3);
        h1.next.next.next=new ListNode(4);
        new NO24_SwapNodesInPairs().new Solution().swapPairs(h1);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode temp = null;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode res = head.next;

        while(cur.next != null && cur.next.next != null){
            temp = cur.next;
            pre.next = temp.next;
            cur.next = pre;
            pre = temp;
            cur = temp.next;
        }
        //最后的节点需要额外处理，感觉不舒服
        pre.next = cur.next;
        cur.next = pre;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}