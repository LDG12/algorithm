package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2239 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static int[][] sudoku;
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Point> list;
    static int[][] arr;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        arr = new int[9][9];
        int cnt = 0;
        for(int i=0; i<9; i++){
            String tmp = br.readLine();
            for(int j=0; j<9; j++){
                arr[i][j] = tmp.charAt(j)-'0';
                if(arr[i][j] == 0){
                    list.add(new Point(i,j));
                }
                else{
                    cnt++;
                }
            }
        }
        dfs(0);
    }
    static void dfs(int cnt){
        if(cnt == list.size()){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        Point now = list.get(cnt);
        for(int i=1; i<=9; i++){
            arr[now.x][now.y] = i;
            if(rowCheck(now.x, now.y) && colCheck(now.x, now.y) && squareCheck(now.x, now.y)){
                dfs(cnt+1);
            }
            arr[now.x][now.y] = 0;
        }

    }
    static boolean rowCheck(int x, int y){
        for(int i=0; i<9; i++){
            if(i != y){
                if(arr[x][i] == arr[x][y])return false;
            }
        }
        return true;
    }
    static boolean colCheck(int x, int y){
        for(int i=0; i<9; i++){
            if(i!=x){
                if(arr[i][y] == arr[x][y]) return false;
            }
        }
        return true;
    }
    static boolean squareCheck(int x,int y){
        int row = (x/3)*3;
        int col = (y/3)*3;
        for(int i=0; i<=2; i++){
            for(int j=0; j<=2; j++){
                if(x != row+i || y!= col+j){
                    if(arr[row+i][col+j] == arr[x][y])return false;
                }
            }
        }
        return true;
    }
}
