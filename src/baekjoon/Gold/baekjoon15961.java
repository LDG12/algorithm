package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon15961 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] arr;
    static int[] selectOper;
    static int direction;
    static int n, m, k, d, c, max, min;
    static Set<Integer> set;
    static Stack<Integer> intStack;
    static PriorityQueue<Integer> pq;
    static StringTokenizer st;
    static boolean[] visited;
    static StringBuilder sb;
    static int[][] result, dp;

    public static void main(String[] args) throws Exception {
        //여기에 코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n * 2];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arr[i + n] = arr[i];
        }
        int[] eat = new int[d + 1];
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (eat[arr[i]] == 0) {
                cnt++;
            }
            eat[arr[i]]++;
        }
        int max = cnt;
        for (int i = 1; i < arr.length / 2; i++) {
            if (eat[c] == 0) {
                max = Math.max(max, cnt + 1);
            } else {
                max = Math.max(max, cnt);
            }
            eat[arr[i - 1]]--;
            if (eat[arr[i - 1]] == 0) cnt--;
            if (eat[arr[i + k - 1]] == 0) cnt++;
            eat[arr[i + k - 1]]++;
        }
        if(eat[c] == 0)cnt++;
        max = Math.max(max,cnt);
        System.out.println(max);
    }
}
