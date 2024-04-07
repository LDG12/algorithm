package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon2357 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception{
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
        int[] segmentTreeMax = new int[treeSize];
        int[] segmentTreeMin = new int[treeSize];
        Arrays.fill(segmentTreeMin, Integer.MAX_VALUE);
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            segmentTreeMax[startIndex+i] = num;
            segmentTreeMin[startIndex+i] = num;
        }
        for(int i=startIndex-1; i>=1; i--){
            segmentTreeMax[i] = Math.max(segmentTreeMax[i*2], segmentTreeMax[i*2+1]);
            segmentTreeMin[i] = Math.min(segmentTreeMin[i*2], segmentTreeMin[i*2+1]);
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int start = a+startIndex-1;
            int end = b+startIndex-1;
            int max = 0;
            int min = Integer.MAX_VALUE;
            while(start<=end){
                if(start%2==1){
                    max = Math.max(max,segmentTreeMax[start]);
                    min = Math.min(min, segmentTreeMin[start]);
                }
                if(end%2==0){
                    max = Math.max(max, segmentTreeMax[end]);
                    min = Math.min(min,segmentTreeMin[end]);
                }
                start = (start+1)/2;
                end = (end-1)/2;
            }
            sb.append(min+" "+max+"\n");
        }
        System.out.print(sb.toString());
    }
}
