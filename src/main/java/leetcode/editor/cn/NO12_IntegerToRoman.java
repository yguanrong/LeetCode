//罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。 
//
// 字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。 
//
// 示例 1: 
//
// 输入: 3
//输出: "III" 
//
// 示例 2: 
//
// 输入: 4
//输出: "IV" 
//
// 示例 3: 
//
// 输入: 9
//输出: "IX" 
//
// 示例 4: 
//
// 输入: 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 输入: 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
// Related Topics 数学 字符串 
// 👍 408 👎 0

// I IV V IX
package leetcode.editor.cn;

import java.util.Stack;

public class NO12_IntegerToRoman {
    public static void main(String[] args) {
        Solution solution =
        new NO12_IntegerToRoman().new Solution();
    }

    /**
     * 这道题暂时想不到更好的解决办法，只能通过枚举来解决了
     */
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int p = 1;
        Stack<String> perNum = new Stack<>();
        while (num >0){
            int temp = num%10;
            String a = toRoman(temp,p);
            perNum.push(a);
            num = num/10;
            p=p*10;
        }
        while (!perNum.empty()){
            stringBuilder.append(perNum.pop());
        }
        return stringBuilder.toString();
    }

    private String toRoman(int x,int p){
        StringBuilder a = new StringBuilder();
        if (p==1){
            switch (x){
                case 1:
                case 2:
                case 3:
                    for (int i =0;i<x;i++){
                        a.append("I");
                    }
                    break;
                case 4:
                    a = new StringBuilder("IV");
                    break;
                case 5:
                    a.append("V");
                    break;
                case 9:
                    a.append("IX");
                    break;
                case 6:
                case 7:
                case 8:
                    a.append("V");
                    for (int i =0;i<x-5;i++){
                        a.append("I");
                    }
                    break;
            }
        }
        if (p==10){
            switch (x){
                case 1:
                case 2:
                case 3:
                    for (int i =0;i<x;i++){
                        a.append("X");
                    }
                    break;
                case 4:
                    a = new StringBuilder("XL");
                    break;
                case 5:
                    a.append("L");
                    break;
                case 9:
                    a.append("XC");
                    break;
                case 6:
                case 7:
                case 8:
                    a.append("L");
                    for (int i =0;i<x-5;i++){
                        a.append("X");
                    }
                    break;
            }
        }
        if (p==100){
            switch (x){
                case 1:
                case 2:
                case 3:
                    for (int i =0;i<x;i++){
                        a.append("C");
                    }
                    break;
                case 4:
                    a = new StringBuilder("CD");
                    break;
                case 5:
                    a.append("D");
                    break;
                case 9:
                    a.append("CM");
                    break;
                case 6:
                case 7:
                case 8:
                    a.append("D");
                    for (int i =0;i<x-5;i++){
                        a.append("C");
                    }
                    break;
            }
        }
        if (p==1000){
            switch (x){
                case 1:
                case 2:
                case 3:
                    for (int i =0;i<x;i++){
                        a.append("M");
                    }
                    break;
            }
        }
        return a.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}