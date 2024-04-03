package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon2866 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m;
    static char[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine() , " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        for(int i=0; i<n; i++){
            String word = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = word.charAt(j);
            }
        }
        int start = 0;
        int end = n-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(checkSet(mid)){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        System.out.println(start);
    }
    static boolean checkSet(int row){
        Set<String> set = new HashSet<>();
        System.out.println("row = "+row);
        for(int i=0; i<m; i++){
            String result = "";
            for(int j=row+1;j<n;j++){
                result+=arr[j][i];
            }
            if(set.contains(result)){
                return false;
            }
            set.add(result);
            System.out.println("set = "+set);
        }
        return true;
    }
}
