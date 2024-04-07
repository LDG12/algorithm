package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon10868 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        int depth = 0;
        while(Math.pow(2,depth)<n)depth++;
        depth++;
        int treeSize = (int)Math.pow(2,depth);
        int startIndex = (int)Math.pow(2,depth-1);
        int[] segmentTree = new int[treeSize];
        Arrays.fill(segmentTree, Integer.MAX_VALUE);
        for(int i=0; i<n; i++){
            segmentTree[startIndex+i] = Integer.parseInt(br.readLine());
        }
        for(int i = startIndex-1; i>=1; i--){
            segmentTree[i] = Math.min(segmentTree[i*2], segmentTree[i*2+1]);
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int start = a+startIndex-1;
            int end = b+startIndex-1;
            int answer = Integer.MAX_VALUE;
            while(start<=end){
                if(start%2==1) answer = Math.min(answer, segmentTree[start]);
                if(end%2==0) answer= Math.min(answer, segmentTree[end]);
                start = (start+1)/2;
                end = (end-1)/2;
            }
            sb.append(answer+"\n");
        }
        System.out.print(sb.toString());
    }
}
