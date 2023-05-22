package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 */
public class SolveNQueens {
    List<List<String>> res = new ArrayList<>();
    char[][] chessboard;

    public List<List<String>> solveNQueens(int n) {
        chessboard = new char[n][n];
        for (char[] c : chessboard ) {
            Arrays.fill(c,'.');
        }
        backtracking(n,0);
        return res;
    }
    public void backtracking(int n,int row){
        if (n == row){
            res.add(ArrayToList(chessboard));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(row,i,n)){
                chessboard[row][i] = 'Q';
                backtracking(n,row  + 1);
                chessboard[row][i] = '.';
            }
        }
    }

    public List<String> ArrayToList(char[][] chessboard){
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard ) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(int row,int col,int n){
        //检查列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q'){
                return false;
            }
        }
        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
