package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test7_2 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    static int[] arr;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<m; i++){
            int middle = Integer.parseInt(br.readLine());
            int start = 0;
            int end = n-1;
            int index = -1;
            while(start<end){
                System.out.println("start = "+start+ " // end = "+end);
                int mid = (start+end)/2;
                int value = arr[mid];
                if(value > middle){
                   end = mid-1;
                }
                else if(value < middle){
                    start = mid+1;
                }
                else if(value == middle){
                    index = mid;
                    break;
                }
            }
            if(index == -1){
                sb.append("0\n");
            }
            else{
                int left = index;
                int right = ((n-1)-(index));
                sb.append((left*right)+"\n");
                // 0 1 2 3 4 5
            }
        }
        System.out.print(sb.toString());
    }
}
