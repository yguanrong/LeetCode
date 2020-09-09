//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4849 👎 0


package leetcode.editor.cn;

import java.math.BigInteger;

public class NO2_AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2);
//        l1.next = new ListNode(4);
//        l1.next.next = new ListNode(3);
//        ListNode l2 = new ListNode(5);
////        ListNode next = new ListNode(0);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

//        1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1
//        for (int i = 0;i< 29;i++){
//            next.next = new ListNode(0);
//            next = next.next;
//        }
//        next.next = new ListNode(1);
        Solution solution=
                new NO2_AddTwoNumbers().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
//
//      Definition for singly-linked list.

       public static class ListNode {
           int val;
           ListNode next;
           ListNode(int x) { val = x; }
       }


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum1 = new BigInteger("0");
        BigInteger sum2 =new BigInteger("0");
        BigInteger sum;
        BigInteger ten = new BigInteger("10");
        int x = 0;
        while (l1 !=null){
            StringBuilder builder = new StringBuilder(l1.val+"");
            for (int t=0; t<x; t++){
                builder.append(0);
            }
            String string = builder.toString();
            sum1 = sum1.add(new BigInteger(string));
            l1 = l1.next;
            x++;
        }
        x=0;
        while (l2 !=null){
            StringBuilder builder = new StringBuilder(l2.val+"");
            for (int t=0; t<x; t++){
                builder.append(0);
            }
            String string = builder.toString();
            sum2 = sum2.add(new BigInteger(string));
            l2 = l2.next;
            x++;
        }
        sum = sum1.add(sum2);
        ListNode listNode = new ListNode(0);
        ListNode nextNode = new ListNode(0);
        listNode.next = nextNode;
        while (sum.compareTo(new BigInteger("0"))>0){
            int n = (sum.mod(ten)).intValue();
            nextNode.next = new ListNode(n);
            sum = sum.divide(ten);
            nextNode = nextNode.next;
        }
        if (listNode.next.next ==null){
            return new ListNode(0);
        }else {
            return listNode.next.next;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}