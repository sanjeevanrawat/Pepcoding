import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePaths(0, 0, n - 1, m - 1, "");
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        if(sr > dr || sc > dc){
            return;
        }
        for(int i = 1; i <= dc; i++){
            printMazePaths(sr, sc + i, dr, dc, psf + "h" + i);
        }
        for(int i = 1; i <= dr; i++){
            printMazePaths(sr + i, sc, dr, dc, psf + "v" + i);
        }
        for(int i = 1,j = 1; i <= dc && j <= dr; i++,j++){
            printMazePaths(sr + i, sc + i, dr, dc, psf + "d" + i);
        }
    }

}