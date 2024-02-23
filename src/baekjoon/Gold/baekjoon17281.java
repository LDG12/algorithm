package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon17281 {

    static int n, m, k, d;
    static StringTokenizer st;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min;
    static boolean[] visited;
    static StringBuilder sb;
    static int[][] inning;
    static int[] baseballer;
    static int max=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        inning = new int[n][9];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<9; j++){
                inning[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        baseballer = new int[9];
        visited = new boolean[9];
        max = Integer.MIN_VALUE;
        dfs(0);
        System.out.println(max);
        br.close();
        bw.close();
    }

    static int calScore(int ruta, int[] base){
        int score = 0;
        if(ruta == 1){
            for(int i=3; i>0; i--){
                int num = Math.min(4,(i+1));
                if(base[i]==1){
                    base[i] = 0;
                    base[num]++;
                }
            }
            base[1] = 1;
        }
        else if(ruta == 2){
            for(int i=3; i>0; i--){
                int num = Math.min(4,(i+2));
                if(base[i]==1){
                    base[i] = 0;
                    base[num]++;
                }
            }
            base[2] = 1;
        }
        else if(ruta == 3){
            for(int i=3; i>0; i--){
                int num = Math.min(4,(i+3));
                if(base[i]==1){
                    base[i] = 0;
                    base[num]++;
                }
            }
            base[3] = 1;
        }
        else if(ruta == 4){
            score++;
            for(int i=3; i>0; i--){
                if(base[i]!=0){
                    base[4]++;
                    base[i] = 0;
                }
            }
        }
        score+=base[4];
        base[4] = 0;
        return score;
    }
    static void dfs(int depth){
        if(depth==3){
            visited[0] = true;
            baseballer[depth] = 0;
            dfs(depth+1);
        }
        if(depth==9){
            int score = 0;
            int nowLoop = 0;
            int index=0;
            while(nowLoop<n){
                int out = 0;
                int inningScore=0;
                int[] base = new int[5];
                while(out<3){
                    int nowBaseballer = baseballer[index];
                    int nowRuta = inning[nowLoop][nowBaseballer];
                    if(nowRuta == 0){
                        out++;
                    }
                    else{
                        inningScore += calScore(nowRuta, base);
                    }
                    index++;
                    if(index>8)index=0;
                    if(out==3)break;
                }
                score += inningScore;
                nowLoop++;
            }
            if(score>max){
                max= score;
            }
            return;
        }


        for(int i=1; i<9; i++){
            if(!visited[i]){
                visited[i] = true;
                baseballer[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
