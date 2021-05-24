import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(numOfPaths(n));
    }
    
    public static int numOfPaths(int n){
        int[] dp = new int[n + 1];
        dp[n] = 1;
        
        for(int i = n - 1; i >= 0 ; i--){
            if(i + 3 <= n){
                dp[i] = dp[i + 1] + dp[i + 2] + dp[i + 3];
            }else if(i + 2 <= n){
                dp[i] = dp[i + 1] + dp[i + 2];
            }else{
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

}