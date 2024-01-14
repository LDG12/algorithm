package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon10816 {
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++) {
        	int now = Integer.parseInt(st.nextToken());
        	map.put(now, map.getOrDefault(now, 0)+1);
        }
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        while(st.hasMoreTokens()) {
        	int now = Integer.parseInt(st.nextToken());
        	if(map.get(now)==null) {
        		sb.append(0+" ");
        	}else {
        		sb.append(map.get(now)+" ");
        	}
        }
        System.out.println(sb.toString());
        br.close();
        bw.close();
    }
}
