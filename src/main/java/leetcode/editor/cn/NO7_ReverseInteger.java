//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2169 👎 0


package leetcode.editor.cn;


public class NO7_ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new NO7_ReverseInteger().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        long t = x;
        long res = 0;
        StringBuilder builder = new StringBuilder();
        if ( t>=10 ){
            while ( t>0 ){
                builder.append(t%10);
                t = t/10;
            }
            res = Long.valueOf(builder.toString());
            if (res>Integer.MAX_VALUE){
                return 0;
            }
            return (int)res;
        }else if (t <= -10){
            t = Math.abs(t);
            while ( t>0 ){
                builder.append(t%10);
                t = t/10;
            }
            res = -Long.valueOf(builder.toString());
            if (res < Integer.MIN_VALUE){
                return 0;
            }
            return (int)res;
        }else {
            return x;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}