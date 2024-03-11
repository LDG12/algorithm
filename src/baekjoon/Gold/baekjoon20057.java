package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon20057 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k, result;
    static int[][] arr;
    static int[][] tornadoX = {
            {0, 0, 1,-1,1,-1,1,-1,2,-2},
            {1, 2, 1,1,0,0,-1,-1,0,0},
            {0, 0, 1,-1,1,-1,1,-1,2,-2},
            {-1,-2,-1,-1,0,0,1,1,0,0}
    };
    static int[][] tornadoY = {
            {-1,-2,-1,-1,0,0,1,1,0,0},
            {0, 0,-1,1,-1,1,-1,1,-2,2},
            {1, 2, 1, 1,0,0,-1,-1,0,0},
            {0, 0,-1,1,-1,1,-1,1,-2,2}
    };
    static double[] tornadoValue = {0.05,0.1,0.1,0.07,0.07,0.01,0.01,0.02,0.02};
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int startX = n/2;
        int startY = n/2;
        int cnt=1;
        int direction = 0;
        int movement = 1;
        result = 0;
        outer:while(cnt<=n*n){
            int nowMove = movement;
            while(nowMove>0){
                int nextX = startX + dx[direction];
                int nextY = startY + dy[direction];
                if(!rangeCheck(nextX,nextY))break outer;
                if(arr[nextX][nextY]>0){
                    doTornado(nextX,nextY,arr[nextX][nextY], direction);
                }
                arr[nextX][nextY] = 0;
                startX = nextX;
                startY = nextY;
                nowMove--;
            }
            direction = (direction+1)%4;
            if(direction==2 || direction==0)movement++;
        }
        System.out.println(result);
    }
    static void doTornado(int x, int y, int value, int direction){
        int amount = value;
        for(int i=1; i<tornadoX[0].length; i++){
            double percent = tornadoValue[i-1];
            int nextX = x+tornadoX[direction][i];
            int nextY = y+tornadoY[direction][i];
            int cal = (int)(value*percent);
            amount-=cal;
            if(!rangeCheck(nextX,nextY)){
                result+=cal;
            }
            else{
                arr[nextX][nextY]+=cal;
            }
        }
        int nextX = x+dx[direction];
        int nextY = y+dy[direction];
        if(rangeCheck(nextX,nextY)){
            arr[nextX][nextY]+=amount;
        }
        else{
            result+=amount;
        }
    }
    static boolean rangeCheck(int x , int y){
        if(x>=0 && y>=0 && x<n && y<n){
            return true;
        }
        return false;
    }
}
