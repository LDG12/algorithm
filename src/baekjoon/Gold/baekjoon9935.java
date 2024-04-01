package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon9935 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String target = br.readLine();
        Stack<Character> stack = new Stack<>();
        int size = target.length();
        for(int i=0; i<word.length(); i++){
            char now = word.charAt(i);
            stack.push(now);
            if(stack.size()>=size){
                boolean flag = false;
                for(int j=0; j<size; j++){
                    if(stack.get(stack.size()-size+j) != target.charAt(j)){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    for(int j=0; j<size; j++){
                        stack.pop();
                    }
                }
            }
            System.out.println(stack);
        }
        sb = new StringBuilder();
        if(stack.size()==0){
            sb.append("FRULA");
        }
        else{
            for(Character c : stack){
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
