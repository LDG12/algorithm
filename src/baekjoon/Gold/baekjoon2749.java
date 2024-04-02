package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2749 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static final int MOD = 1000000;
    static final int PISANO = 15 * MOD;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long index = n%PISANO;
        long[] pivo = new long[(int)(index)+1];

        pivo[0] = 0L;
        pivo[1] = 1L;
        for(int i=2; i<pivo.length; i++){
            pivo[i] = (pivo[i-1]+pivo[i-2])%MOD;
        }
        System.out.println(pivo[(int)index]);
    }
}
