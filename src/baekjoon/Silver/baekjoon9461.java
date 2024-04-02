package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon9461 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] result = new long[101];
        result[0] = 0L;
        result[1] = 1L;
        result[2] = 1L;
        result[3] = 1L;
        for(int i=4; i<=100; i++){
            result[i] = result[i-2] + result[i-3];
        }
        sb = new StringBuilder();
        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            sb.append(result[n]+"\n");
        }
        System.out.print(sb.toString());
    }
}
