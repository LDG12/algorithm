package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon7662 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int tc=0; tc<T; tc++){
            TreeMap<Integer, Integer> map = new TreeMap<>();
            n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine(), " ");
                char order = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                if(order=='I'){
                    map.put(num, map.getOrDefault(num, 0)+1);
                }
                else{
                    if(map.isEmpty())continue;
                    if(num == 1){
                        if(map.get(map.lastKey())>1){
                            map.put(map.lastKey(), map.get(map.lastKey())-1);
                        }
                        else{
                            map.remove(map.lastKey());
                        }
                    }
                    else{
                        if(map.get(map.firstKey())>1){
                            map.put(map.firstKey(), map.get(map.firstKey())-1);
                        }
                        else{
                            map.remove(map.firstKey());
                        }
                    }
                }
            }
            if(map.isEmpty()){
                sb.append("EMPTY\n");
            }
            else{
                sb.append(map.lastKey()+" "+map.firstKey()+"\n");
            }
        }
        System.out.print(sb.toString());
    }
}
