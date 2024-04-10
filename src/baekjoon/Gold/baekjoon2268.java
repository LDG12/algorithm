package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2268 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int depth = 0;
        while(Math.pow(2,depth)< n)depth++;
        depth++;
        int treeSize = (int)Math.pow(2,depth);
        int startIndex = (int)Math.pow(2,depth-1);
        long[] segmentTree = new long[treeSize];
        sb = new StringBuilder();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int order = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second =Integer.parseInt(st.nextToken());
            if(order==0){
                int start = 0;
                int end = 0;
                if(first<second){
                    start = first+startIndex-1;
                    end = second+startIndex-1;
                }
                else{
                    start = second+startIndex-1;
                    end = first+startIndex-1;
                }
                long ans = 0;
                while(start<=end){
                    if(start%2==1)ans+=segmentTree[start];
                    if(end%2==0)ans+=segmentTree[end];
                    start = (start+1)/2;
                    end = (end-1)/2;
                }
                sb.append(ans+"\n");
            }
            else{
                int targetIndex = first+startIndex-1;
                segmentTree[targetIndex] = second;
                while(targetIndex>=1){
                    targetIndex/=2;
                    segmentTree[targetIndex] = segmentTree[targetIndex*2] + segmentTree[targetIndex*2+1];
                }
            }
        }
        System.out.print(sb.toString());
    }
}
