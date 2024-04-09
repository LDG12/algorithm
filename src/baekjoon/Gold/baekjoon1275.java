package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1275 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine() , " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int depth = 0 ;
        while(Math.pow(2, depth)< n)depth++;
        depth++;
        int treeSize = (int)Math.pow(2, depth);
        int startIndex = (int)Math.pow(2,depth-1);
        long[] segmentTree = new long[treeSize];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            segmentTree[startIndex+i] = Integer.parseInt(st.nextToken());
        }
        for(int i = startIndex-1; i>=1; i--){
            segmentTree[i] = segmentTree[i*2] + segmentTree[i*2+1];
        }
        sb = new StringBuilder();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = 0;
            if(x< y){
                start = x+startIndex-1;
                end = y+startIndex-1;
            }
            else{
                start = y+startIndex-1;
                end = x+startIndex-1;
            }
            long ans = 0;
            while(start<=end){
                if(start%2==1)ans+=segmentTree[start];
                if(end%2==0)ans+=segmentTree[end];
                start= (start+1)/2;
                end = (end-1)/2;
            }
            sb.append(ans+"\n");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int targetIndex = a+startIndex - 1;
            segmentTree[targetIndex] = b;
            while(targetIndex >= 1){
                targetIndex = targetIndex/2;
                segmentTree[targetIndex] = segmentTree[targetIndex*2] + segmentTree[targetIndex*2+1];
            }
        }
        System.out.print(sb.toString());
    }
}
