package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1715 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        long result=0;
        while(pq.size()>1){
            int sum = pq.poll() + pq.poll();
            result += sum;
            pq.offer(sum);
        }
        System.out.println(result);
    }
}
