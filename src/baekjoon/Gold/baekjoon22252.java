package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon22252 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long result = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int order = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int amount = Integer.parseInt(st.nextToken());
            if(order == 1){
                if(map.get(name)==null)map.put(name, new PriorityQueue<>(Collections.reverseOrder()));
                for(int j=0; j<amount; j++){
                    int num = Integer.parseInt(st.nextToken());
                    map.get(name).offer(num);
                }
            }
            else{
                if(map.get(name) == null)continue;
                for(int j=0; j<amount; j++){
                    if(map.get(name).isEmpty())break;
                    result += map.get(name).poll();
                }
            }
        }
        System.out.println(result);
    }
}
