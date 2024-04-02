package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon2086 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static final int MOD = 1000000000;
    static final long PISANO = 15*MOD;
    static Map<Long, Long> memory = new HashMap<>();
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        memory.put(1L, 1L);
        memory.put(2L, 1L);
        memory.put(3L, 2L);
        memory.put(4L, 3L);
        memory.put(5L, 5L);



        System.out.println((Fibo(end + 2) - Fibo(start + 1) + MOD) % MOD);
    }
    static long Fibo(long n) {
        if (memory.containsKey(n)) {
            return memory.get(n);
        } else {
            long result;
            if (n % 2 == 1) {
                result = (Fibo(n / 2) * Fibo(n / 2) + Fibo(n / 2 + 1) * Fibo(n / 2 + 1)) % MOD;
            } else {
                result = (Fibo(n + 1) - Fibo(n - 1) + MOD) % MOD;
            }
            memory.put(n, result);
            return result;
        }
    }
}
