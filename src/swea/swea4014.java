package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea4014 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m, cnt;
    static int[][] arr;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new int[n][n];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            cnt = 0;
            for(int i=0; i<n; i++){
                if(rowCheck(i,0, new boolean[n])){
                    cnt++;
                }
                if(colCheck(0, i, new boolean[n])){
                    cnt++;
                }
            }
            sb.append("#"+(tc+1)+" "+cnt+"\n");
        }
        System.out.print(sb.toString());
    }
    static boolean colCheck(int x, int y, boolean[] visited){
        int startX = x;
        int startY = y;
        while(startX < n-1){
            int nextX = startX+1;
            int nextY = startY;
            if(arr[nextX][nextY] > arr[startX][startY]+1 || arr[nextX][nextY] < arr[startX][startY]-1){
                return false;
            }
            // left search를 해야죠
            if(arr[nextX][nextY] == arr[startX][startY]+1){
                if(colUpCheck(startX, startY, visited) < m)return false;
            }// right search를 하고 그 장소로 이동해야함.
            else if(arr[nextX][nextY] == arr[startX][startY] -1){
                // 3 3 2 2 2
                if(colDownCheck(nextX,nextY, visited)<m)return false;
                startX+=m;
                continue;
            }
            startX+=1;
        }
        return true;
    }
    static int colDownCheck(int startX, int startY, boolean[] visited){
        if(startX+m-1 > n-1)return 0;
        int cnt = 0;
        // 2에서 시작, 3에서 끝나야함.
        for(int i = startX; i<startX+m; i++){
            if(arr[i][startY] == arr[startX][startY] && !visited[i]){
                visited[i] = true;
                cnt++;
            }
            else break;
        }
        return cnt;
    }
    static int colUpCheck(int startX, int startY, boolean[] visited){
        if(startX-m+1 < 0)return 0;
        int cnt = 0;
        // 2 2 3 3 3
        // 1에서 시작 0까지 돌아야함
        for(int i=startX; i>=startX-m+1; i--){
            if(arr[i][startY] == arr[startX][startY] && !visited[i]){
                visited[i] = true;
                cnt++;
            }
            else break;
        }
        return cnt;
    }
    static boolean rowCheck(int x, int y, boolean[] visited){
        int startX = x;
        int startY = y;
        while(startY < n-1){
            int nextX = startX;
            int nextY = startY+1;
            if(arr[nextX][nextY] > arr[startX][startY]+1 || arr[nextX][nextY] < arr[startX][startY]-1){
                return false;
            }
            // left search를 해야죠
            if(arr[nextX][nextY] == arr[startX][startY]+1){
                if(rowLeftCheck(startX, startY, visited) < m)return false;
            }// right search를 하고 그 장소로 이동해야함.
            else if(arr[nextX][nextY] == arr[startX][startY] -1){
                // 3 3 2 2 2
                if(rowRightCheck(nextX,nextY, visited)<m)return false;
                startY+=m;
                continue;
            }
            startY+=1;
        }
        return true;
    }
    static int rowRightCheck(int startX, int startY, boolean[] visited){
        if(startY+m-1 > n-1)return 0;
        int cnt = 0;
        // 2에서 시작, 3에서 끝나야함.
        for(int i = startY; i<startY+m; i++){
            if(arr[startX][i] == arr[startX][startY] && !visited[i]){
                visited[i] = true;
                cnt++;
            }
            else break;
        }
        return cnt;
    }
    static int rowLeftCheck(int startX, int startY, boolean[] visited){
        if(startY-m+1 < 0)return 0;
        int cnt = 0;
        // 2 2 3 3 3
        // 1에서 시작 0까지 돌아야함
        for(int i=startY; i>=startY-m+1; i--){
            if(arr[startX][i] == arr[startX][startY] && !visited[i]){
                visited[i] = true;
                cnt++;
            }
            else break;
        }
        return cnt;
    }
}
