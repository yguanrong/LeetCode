//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 示例: 
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
//
// 说明: 
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。 
// Related Topics 字符串 回溯算法 
// 👍 965 👎 0


package leetcode.editor.cn;

import java.util.*;

public class NO17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        new NO17_LetterCombinationsOfAPhoneNumber().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {

        Map<Character,List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList(("a,b,c").split(",")));
        map.put('3', Arrays.asList(("d,e,f").split(",")));
        map.put('4', Arrays.asList(("g,h,i").split(",")));
        map.put('5', Arrays.asList(("j,k,l").split(",")));
        map.put('6', Arrays.asList(("m,n,o").split(",")));
        map.put('7', Arrays.asList(("p,q,r,s").split(",")));
        map.put('8', Arrays.asList(("t,u,v").split(",")));
        map.put('9', Arrays.asList(("w,x,y,z").split(",")));

        if (digits.length()>0){
            List<String> res = map.get(digits.charAt(0));
            int i = 0;
            while ( 1+i< digits.length()){
                List<String>  temp = map.get(digits.charAt(i+1));
                res = getStr(res,temp);
                i++;
            }
            return res;
        }else {
            return new ArrayList<>();
        }

    }
    private List<String> getStr(List<String> res, List<String> det){
        List<String> result = new ArrayList<>();
        for (String re : res) {
            for (String s : det) {
                String temp = re + s;
                result.add(temp);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}