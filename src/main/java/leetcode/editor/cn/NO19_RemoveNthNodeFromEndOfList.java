//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1329 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class NO19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
//        [1,2,3,4,5]
        h.next=new ListNode(2);
//        h.next.next=new ListNode(3);
//        h.next.next.next.next=new ListNode(4);
//        h.next.next.next.next.next=new ListNode(5);

        new NO19_RemoveNthNodeFromEndOfList().new Solution().removeNthFromEnd(h,2);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/**使用map来记录每一个节往后的链表，然后分情况处理临界值，
 * 当n=1时（删除最后一个），
 * 当n=size时（删除第一个）
 * 其他
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;
        Map<Integer,ListNode> m = new HashMap<Integer,ListNode>();
        int index=1;
        while(temp!=null){
            m.put(index++,temp);
            temp = temp.next;
        }
        int size = m.size();
        if(size == 1)
            return null;
        if(n == 1){
            m.get(size-1).next = null;
        }else if(n == size){
            head = head.next;
        }else{
            m.get(size-n).next = m.get(size-n+2);
        }
        return head;
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