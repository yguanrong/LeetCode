//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 557 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NO204_CountPrimes {
    public static void main(String[] args) {
//        Solution solution =
        new NO204_CountPrimes().new Solution().countPrimes(4);
    }

    /**
     * 先把0-n之间的数全部放到一个列表里，然后把不是质数的值改成0.例如把所有2的倍数改成0 ，
     * 把所有3的倍数改成0，一直到所有小于
     * N 的质数的倍数都被去掉，剩余的数字就是质数表
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {

        int count = 0;
        if (n<=2){
            return 0;
        }else if (n == 3){
            return 1;
        }else {
            List<Integer> list = new ArrayList<>();
            for (int i =0;i<n;i++){
                if (i == 1){
                    list.add(0);
                }else {
                    list.add(i);
                }

            }

            for (int i = 2; i <list.size() ; i++) {
                if (list.get(i) == 0){
                    continue;
                }
                for (int j = i+i; j < n; j+=i) {
                    list.set(j,0);
                }
            }

            for (int i =0;i<list.size();i++){
                if ( list.get(i) != 0){
                    count++;
                }

            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}