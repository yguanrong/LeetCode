//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串 
// 👍 823 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NO6_ZigzagConversion {
    public static void main(String[] args) {
//        Solution solution =
                new NO6_ZigzagConversion().new Solution().convert("AB",1);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {

        List<Character>[] lists = new ArrayList[numRows+1];
        int index = 0;
        boolean flag = false;
        if (numRows >= 2){
            for (int i = 0;i<s.length();i++){
                char c = s.charAt(i);
                if (flag){
                    index --;
                    if (index<1){
                        index = 1+1;
                        flag = false;
                    }
                }else {
                    index++;
                    if (index > numRows){
                        index = numRows-1;
                        flag = true;
                    }
                }
                if (lists[index] == null){
                    lists[index] = new ArrayList<>();
                }
                lists[index].add(c);
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 1; i<=numRows; i++){
                if (lists[i] !=null){
                    for (int j=0; j<lists[i].size();j++){
                        builder.append(lists[i].get(j));
                    }
                }

            }
            return builder.toString();
        }else {
            return s;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}