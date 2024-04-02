package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon6198 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n;
    static class Node{
        int index,  height;
        Node(int index, int height){
            this.index = index;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", height=" + height +
                    "}\n";
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] result = new int[n];
        Stack<Node> stack = new Stack<>();
        int first = Integer.parseInt(br.readLine());
        stack.push(new Node(0, first));
        for(int i=1; i<n-1; i++){
            int now = Integer.parseInt(br.readLine());
            if(now >= stack.peek().height){
                Node pop = stack.pop();
                result[pop.index] = i-pop.index-1;
                while(!stack.isEmpty()){
                    if(now >= stack.peek().height){
                        Node pop2 = stack.pop();
                        result[pop2.index] = i-pop2.index-1;
                    }
                    else{
                        break;
                    }
                }
            }
            stack.push(new Node(i, now));
        }
        int last = Integer.parseInt(br.readLine());
        int cnt = 0;
        Node prev = new Node(n-1, last);
        while(!stack.isEmpty()){
            Node now = stack.pop();
            if(prev.height >= now.height){
                result[now.index] = prev.index - now.index-1;
            }
            else{
                result[now.index] = (n-1) - now.index;
            }
        }
        long answer = 0;
        for(int i=0; i<n; i++){
            answer+=result[i];
        }
        System.out.println(answer);
    }
}
