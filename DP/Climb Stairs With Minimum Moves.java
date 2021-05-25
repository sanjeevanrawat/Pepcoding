import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] moves = new int[n];
        for(int i = 0; i < n; i++){
            moves[i] = scn.nextInt();
        }
        System.out.println(minMoves(n, moves));
    }
    public static int minMoves(int n, int[] moves){
        int dp[] = new int[n + 1];
        dp[n] = 0;//base case , moves required to reach nth stair
        
        for(int i = n - 1; i >= 0; i--){
            if(moves[i] == 0){
                dp[i] = Integer.MAX_VALUE;
            }else{
                int min = Integer.MAX_VALUE;
                for(int j = 1; j <= moves[i] && i + j <= n; j++){
                    min = Math.min(min, dp[i + j]);
                }
                if(min != Integer.MAX_VALUE){
                    dp[i] = min + 1;
                }else{
                    dp[i] = Integer.MAX_VALUE;
                }
            }
        }
        return dp[0];
    }

}