import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        long t1 = System.currentTimeMillis();
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(numOfPaths(n,0,dp));
        long t2 = System.currentTimeMillis();
        //System.out.println(t2 - t1);
    }
    
    public static int numOfPaths(int n, int cS, int dp[]){
        if(cS == n){
            return 1;//1 path exists
        }
        if(cS > n){
            return 0;//no path exists
        }
        if(dp[cS] != -1){
            return dp[cS];
        }
        int p1 = numOfPaths(n, cS + 1, dp);
        int p2 = numOfPaths(n, cS + 2, dp);
        int p3 = numOfPaths(n, cS + 3, dp);
        return dp[cS] = p1 + p2 + p3;
    }

}