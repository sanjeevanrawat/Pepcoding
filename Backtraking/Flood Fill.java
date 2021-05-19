import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean[][] travelled = new boolean[n][m];
        floodfill(arr, 0, 0, "", travelled);
    }
    
    // asf -> answer so far
    public static void floodfill(int[][] maze, int sr, int sc, String asf, boolean[][] travelled) {
        if(sr == maze.length - 1 && sc == maze[0].length - 1){
            System.out.println(asf);
            return;
        }
        if(sr == maze.length || sc == maze[0].length || sr < 0 || sc < 0 || maze[sr][sc] == 1 || travelled[sr][sc] == true){
            return;
        }
        
        travelled[sr][sc] = true;
        floodfill(maze, sr - 1 , sc, asf + 't', travelled);
        floodfill(maze, sr , sc - 1, asf + 'l', travelled);
        floodfill(maze, sr + 1, sc, asf + 'd', travelled);
        floodfill(maze, sr , sc + 1, asf + 'r', travelled);
        travelled[sr][sc] = false;
    }
}

