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
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(minMoves(n, moves, 0, dp));
    }
    public static int minMoves(int n, int[] moves, int cs, int dp[]){
        if(cs == n){
            return 0;
        }
        // if(cs > n){
        //     return Integer.MAX_VALUE;
        // }
        if(dp[cs] != -1){
            return dp[cs];
        }
        int mm = Integer.MAX_VALUE;
        int p = 0;
        
        for(int i = 1; i <= moves[cs] && i + cs <= n; i++){
            p = minMoves(n, moves, cs + i, dp);
            mm = Math.min(mm, p);
        }
        if(mm == Integer.MAX_VALUE){
            return dp[cs] = Integer.MAX_VALUE;
        }else{
            return dp[cs] = mm + 1;    
        }
    }

}