package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon17298 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        result[0] = -1;
        int index = 1;
        sb = new StringBuilder();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = arr[n-1];
        stack.push(start);
        for(int i = n-2; i>=0; i--){
            int now = arr[i];
            if(stack.size()>0){
                if(now<stack.peek()){
                    result[index++] = stack.peek();
                }
                else{
                    stack.pop();
                    while(!stack.isEmpty()){
                        if(stack.peek()<=now){
                            stack.pop();
                        }
                        else{
                            result[index++] = stack.peek();
                            break;
                        }
                    }
                    if(stack.isEmpty()){
                        result[index++] = -1;
                    }
                }
            }
            else {
                result[index++] = -1;
            }
            stack.push(now);
        }
        for(int i = result.length-1; i>=0; i--){
            sb.append(result[i]+ " ");
        }
        System.out.println(sb.toString().trim());
    }
}
