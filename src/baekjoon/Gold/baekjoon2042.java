package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2042 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int depth = 0;
        sb = new StringBuilder();
        while(Math.pow(2,depth)<n)depth++;
        depth++;
        int treeSize = (int)Math.pow(2,depth);
        int startIndex = (int)Math.pow(2, depth-1);
        long[]segementTree = new long[treeSize];
        for(int i=0; i<n; i++){
            long num = Long.parseLong(br.readLine());
            segementTree[startIndex+i] = num;
        }
        for(int i = startIndex-1; i>=1; i--){
            segementTree[i] = segementTree[i*2]+segementTree[i*2+1];
        }
        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int order = Integer.parseInt(st.nextToken());
            long first = Long.parseLong(st.nextToken());
            long second = Long.parseLong(st.nextToken());
            if(order == 1){
                int targetIndex = startIndex+(int)first-1;
                segementTree[targetIndex] = second;
                while(targetIndex >= 1){
                    targetIndex/=2;
                    segementTree[targetIndex] = segementTree[targetIndex*2]+segementTree[targetIndex*2+1];
                }
            }
            else{
                int start = (int)first + startIndex-1;
                int end = (int)second + startIndex-1;
                long answer = 0;
                while(start<=end){
                    if(start%2==1) answer+=segementTree[start];
                    if(end%2==0) answer+=segementTree[end];
                    start = (start+1)/2;
                    end = (end-1)/2;
                }
                sb.append(answer+"\n");
            }
        }
        System.out.print(sb.toString());
    }
}
