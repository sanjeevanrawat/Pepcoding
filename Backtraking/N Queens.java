import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] chess = new int[n][n];
        printNQueens(chess, "", 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row == chess.length){
            System.out.println(qsf + '.');
            return;
        }
        for(int col = 0; col < chess[0].length; col++){
            if (isValid(chess, row, col)){
                chess[row][col] = 1;
                printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }
    public static boolean isValid(int[][] chess, int row, int col){
        for(int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--){
            if(chess[r][c] == 1){
                return false;
            }
        }
        for(int r = row - 1, c = col + 1; r >= 0 && c < chess[0].length; r--, c++){
            if(chess[r][c] == 1){
                return false;
            }
        }
        for(int r = row - 1, c = col; r >= 0; r--){
            if(chess[r][c] == 1){
                return false;
            }
        }
        return true;
    }
}