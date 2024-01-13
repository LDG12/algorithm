package inflearn._4_hashmap_treeset;


import java.util.*;
import java.util.stream.Stream;
import java.io.*;
 
class inflearn4_3{
    static int n,m,k; 
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer>map = new HashMap<>();
        sb = new StringBuilder();
        int start=0;
        for(int i=0; i<m; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        sb.append(map.size()+" ");
        for(int i=m; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            map.put(arr[start], map.get(arr[start])-1);
            if(map.get(arr[start])==0)map.remove(arr[start]);
            start++;
            sb.append(map.size()+" ");
        }
        System.out.println(sb.toString());
        br.close();
        bw.close();
    }
}


