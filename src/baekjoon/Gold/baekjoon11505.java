package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon11505 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static final int MOD = 1_000_000_007;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        int depth = 0;
        while(Math.pow(2,depth)<n)depth++;
        depth++;
        int treeSize = (int)Math.pow(2,depth);
        int startIndex = (int)Math.pow(2,depth-1);
        long[] segmentTree = new long[treeSize];
        Arrays.fill(segmentTree, -1);
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            segmentTree[startIndex+i] = num;
        }
        for(int i = startIndex-1; i>=1; i--){
            long first = segmentTree[i*2];
            long second = segmentTree[i*2+1];
            if(first == -1 && second == -1){
                segmentTree[i] = -1;
                continue;
            }
            else if(first == -1){
                segmentTree[i] = second;
            }
            else if(second == -1){
                segmentTree[i] = first;
            }
            else{
                segmentTree[i] = (segmentTree[i*2] * segmentTree[i*2+1])%MOD;
            }
        }
        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int order = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(order == 1){
                int targetIndex = first+startIndex-1;
                segmentTree[targetIndex] = second;
                while(targetIndex>=1){
                    targetIndex/=2;
                    long firstValue = segmentTree[targetIndex*2];
                    long secondValue = segmentTree[targetIndex*2+1];
                    if(firstValue == -1 && secondValue == -1){
                        segmentTree[targetIndex] = -1;
                        continue;
                    }
                    else if(firstValue == -1){
                        segmentTree[targetIndex] = second;
                    }
                    else if(secondValue == -1){
                        segmentTree[targetIndex] = first;
                    }
                    else{
                        segmentTree[targetIndex] = (segmentTree[targetIndex*2] * segmentTree[targetIndex*2+1])%MOD;
                    }
                }
            }
            else {
                int start = first+startIndex-1;
                int end = second+startIndex-1;
                long ans=1;
                while(start<=end){
                    if(start%2==1) ans = (ans*segmentTree[start])%MOD;
                    if(end%2==0) ans = (ans*segmentTree[end])%MOD;
                    start = (start+1)/2;
                    end = (end-1)/2;
                }
                sb.append(ans+"\n");
            }
        }
        System.out.print(sb.toString());
    }
}
