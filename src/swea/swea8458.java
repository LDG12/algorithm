package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea8458 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            int[] dist = new int[n];
            int max = 0;
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine(), " ");
                dist[i] = Math.abs(Integer.parseInt(st.nextToken()))+Math.abs(Integer.parseInt(st.nextToken()));
            }
            for(int i=0; i<n; i++){
                if (i >= 1 && dist[i] % 2 != dist[i - 1] % 2) {
                    max = -1;
                    break;
                } else {
                    max = Math.max(dist[i], max);
                }
            }
            int index = 0;
            if(max!= -1){
                long sum = 0;
                while(true){
                    sum += index;
                    if(sum>=max && (sum-max)%2==0){
                        break;
                    }
                    index++;
                }
            }
            else{
                index = -1;
            }
            sb.append("#"+(tc+1)+" "+index+"\n");
        }
        System.out.print(sb.toString());
    }
}
