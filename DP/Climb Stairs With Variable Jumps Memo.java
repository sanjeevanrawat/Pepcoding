import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(var(n, arr, 0, dp) );
    }
    public static int var(int n , int[] arr, int cS, int dp[]){
        if(cS == n){
            return 1;
        }
        if(cS > n){
            return 0;
        }
        if(dp[cS] != -1){
            return dp[cS];
        }
        int p = 0;
        for(int i = 1; i <= arr[cS]; i++){
            p += var(n, arr, cS + i, dp);
        }
        return dp[cS] = p;
    }

}