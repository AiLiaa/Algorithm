package Backtracking;

/**
 * 解数独
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 题目数据 保证 输入数独仅有一个解
 *
 */
public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board){
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性
        for (int i = 0; i < 9; i++) {   // 行
            for (int j = 0; j < 9; j++) {   // 列
                if (board[i][j] != '.') continue;   // 跳过数字
                for (char k = '1'; k <= '9'; k++) {
                    //这个位置放k是否合适
                    if (isValid(i,j,k,board)){
                        board[i][j] = k;
                        // 找到合适的一组，返回
                        if (backtracking(board)) return true;
                        board[i][j] = '.';
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
                // 因为如果一行一列确定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    public boolean isValid(int row, int col, char val, char[][] board){

        //行
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }

        //列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val){
                return false;
            }
        }

        //九宫格
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val){
                    return false;
                }
            }
        }

        return true;
    }
}
