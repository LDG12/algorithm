package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class baekjoon5430 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder resultSB = new StringBuilder();
        int T= Integer.parseInt(br.readLine());
        for(int tc= 0; tc<T; tc++){
            sb = new StringBuilder();
            String oper = br.readLine();
            n = Integer.parseInt(br.readLine());
            Deque<Integer> q = new ArrayDeque<>();
            String tmp = br.readLine();
            tmp = tmp.substring(1, tmp.length()-1);
            st = new StringTokenizer(tmp, ",");
            for(int i=0; i<n; i++){
                q.offer(Integer.parseInt(st.nextToken()));
            }
            boolean isEmpty = false;
            boolean flag = false;
            // flag가 false면 정방향, true면 역방향
            for(int i=0; i<oper.length(); i++){
                char order = oper.charAt(i);
                if(order=='R'){
                    if(flag)flag=false;
                    else flag=true;
                }
                else{
                    if(q.isEmpty()){
                        isEmpty = true;
                        break;
                    }
                    else{
                        if(flag){
                            q.removeLast();
                        }
                        else{
                            q.removeFirst();
                        }
                    }
                }
            }
            if(isEmpty) {
                sb.append("error");
                resultSB.append(sb.toString()+"\n");
                continue;
            }
            else{
                sb.append("[");
                if(q.size() == 0){
                    sb.append("]");
                    resultSB.append(sb.toString()+"\n");
                    continue;
                }
                if(flag){
                    while(!q.isEmpty()){
                        sb.append(q.pollLast()+",");
                    }
                }
                else{
                    while(!q.isEmpty()){
                        sb.append(q.pollFirst()+",");
                    }
                }
                String result = sb.toString();
                result = result.substring(0, result.length()-1);
                resultSB.append(result+"]\n");
            }
        }
        System.out.println(resultSB.toString());
    }
}
