//请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 
// Related Topics 数组 哈希表 矩阵 
// 👍 649 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class NO36_ValidSudoku {
	public static void main(String[] args) { 
		new NO36_ValidSudoku().new Solution(); 
	}

   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {

        Map<Character,Integer> rowMap = new HashMap<>(9);
        Map<Character,Integer> rect1Map = new HashMap<>(9);
        Map<Character,Integer> rect2Map = new HashMap<>(9);
        Map<Character,Integer> rect3Map = new HashMap<>(9);

        // 按行遍历
        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (judeContinue(board[i][j], rowMap)){
                    return false;
                }

                if (j<3){
                    // 第一个3*3框
                    if (judeContinue(board[i][j], rect1Map)){
                        return false;
                    }
                }else if (j < 6){
                    // 第二个3*3框
                    if (judeContinue(board[i][j], rect2Map)){
                        return false;
                    }
                }else {
                    // 第二个3*3框
                    if (judeContinue(board[i][j], rect3Map)){
                        return false;
                    }
                }

            }
            //遍历完一行清空map
            rowMap.clear();
            if ((i+1)%3 == 0){
                rect1Map.clear();
                rect2Map.clear();
                rect3Map.clear();
            }
        }

        // 按列遍历
        for (int j = 0; j < 9; j++) {

            for (int i = 0; i < 9; i++) {
                if (judeContinue(board[i][j], rowMap)){
                    return false;
                }
            }
            //遍历完一行清空map
            rowMap.clear();
        }
        return true;
    }

    public boolean judeContinue(char c,Map<Character,Integer> rowMap){
        if (rowMap.get(c) == null){
            rowMap.put(c,1);
            return false;
        }else {
            return c != '.';
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}