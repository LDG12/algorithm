package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon2504 {
    static StringTokenizer st;
    static StringBuilder sb;
    static int n,m,k;
    public static void main(String[] args)throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;
        for(int i=0; i<word.length(); i++){
            char now = word.charAt(i);
            if(now == '('){
                stack.push(now);
                value*=2;
            }
            else if(now == '['){
                stack.push(now);
                value*=3;
            }
            else if(now == ')'){
                if(stack.isEmpty() || stack.peek() == '['){
                    result = 0;
                    break;
                }
                else if(word.charAt(i-1) == '('){
                    result += value;
                }
                value /= 2;
                stack.pop();
            }
            else if(now == ']'){
                if(stack.isEmpty() || stack.peek() == '('){
                    result = 0;
                    break;
                }
                else if(word.charAt(i-1) == '['){
                    result += value;
                }
                value /= 3;
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            System.out.println(0);
        }
        else{
            System.out.println(result);
        }
    }
}
