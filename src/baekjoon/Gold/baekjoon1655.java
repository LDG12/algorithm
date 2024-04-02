package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1655 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();
        sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int now = Integer.parseInt(br.readLine());
            if(i==0){
                min.offer(now);
                sb.append(now+"\n");
            }
            else if(i==1){
                if(now >= min.peek()){
                    max.offer(min.poll());
                    min.offer(now);
                }
                else{
                    max.offer(now);
                }
                sb.append(max.peek()+"\n");
            }
            else{
                if(max.size() == min.size()){
                    if(min.peek() == now){
                        max.offer(now);
                    }
                    else if(min.peek() > now){
                        max.offer(now);
                    }
                    else{
                        max.offer(min.poll());
                        min.offer(now);
                    }
                }
                else{
                    if(max.size() > min.size()){
                        if(max.peek() <= now){
                            min.offer(now);
                        }
                        else if(max.peek() > now){
                            min.offer(max.poll());
                            max.offer(now);
                        }
                    }
                    else if(max.size() < min.size()){
                        if(min.peek() >= now){
                            max.offer(now);
                        }
                        else{
                            max.offer(min.poll());
                            min.offer(now);
                        }
                    }
                }
                sb.append(max.peek()+"\n");
            }
        }
        System.out.print(sb.toString());
    }
}
