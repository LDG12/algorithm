package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea4013 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static int[][] arr;
    static int[] dir;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            arr = new int[4][8];
            for(int i=0; i<4; i++){
                st =new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<8; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dir = new int[4];
            // 돌리는 쪽의 2번 index와
            // 맞닿은 쪽의 6번 index를 비교하면 됨.
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken())-1;
                int d = Integer.parseInt(st.nextToken());
                dir[num] = d;
                setDirLeft(num - 1);
                setDirRight(num + 1);
                moveMagnet();
            }
            int result = 0;
            for(int i=0 ;i<4; i++){
                if(arr[i][0] == 1){
                    result += Math.pow(2, i);
                }
            }
            sb.append("#"+(tc+1)+" "+result+"\n");
        }
        System.out.print(sb.toString());
    }
    private static void moveMagnet() {
        for (int i = 0; i < 4; i++) {
            int d = dir[i];
            if (d == 0)
                continue;
            else if (d == 1) {
                arr = Circle(i, arr);
            } else if (d == -1) {
                arr = ReverseCircle(i, arr);
            }
        }

    }

    private static int[][] ReverseCircle(int num, int[][] magnet) {
        int data[] = copy(magnet[num]);
        for (int i = 0; i < 8; i++) {
            magnet[num][i] = data[(i + 1 + 8) % 8];
        }
        return magnet;

    }

    private static int[][] Circle(int num, int[][] magnet) {
        int data[] = copy(magnet[num]);
        for (int i = 0; i < 8; i++) {
            magnet[num][i] = data[(i - 1 + 8) % 8];
        }
        return magnet;
    }

    private static int[] copy(int[] arr) {
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            tmp[i] = arr[i];
        return tmp;
    }

    private static void setDirLeft(int num) {
        if (num < 0)
            return;
        // num의 2번과 num+1의 6번 비교
        if (dir[num + 1] == 0)
            dir[num] = 0;
        else if (arr[num + 1][6] == arr[num][2])
            dir[num] = 0;
        else
            dir[num] = dir[num + 1] == -1 ? 1 : -1;

        setDirLeft(num - 1);
    }

    private static void setDirRight(int num) {
        if (num >= 4)
            return;
        if (dir[num - 1] == 0)
            dir[num] = 0;
        else if (arr[num - 1][2] == arr[num][6]) {
            dir[num] = 0;
        } else {
            dir[num] = dir[num - 1] == -1 ? 1 : -1;
        }
        setDirRight(num + 1);

    }
}
