package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon17478 {
	/**
	 * @author 임동길
	 * @date 2024-01-29
	 * @link https://www.acmicpc.net/problem/17478
	 * @keyword_solution  
	 * 재귀함수의 종료 조건, 재귀간 입출력 내용의 변화
	 * @input 
	 * input간 특이사항 없음
	 * @output   
	 * 재귀 종료시, 해당 재귀의 상태에 맞춰 "라고 답변하였지"를 한번 출력하여야함.
	 * @time_complex  
	 * O(n)
	 * @perf 
	 */
	static int n,m,k;
    static StringTokenizer st;
    static StringBuilder sb; 
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        dfs(0, 0);
        System.out.println(sb.toString());
        br.close();
    }
    static void dfs(int index, int num) {
    	String word = "____";
    	String tmp ="";
    	for(int i=0; i<num; i++) {
    		tmp+=word;
    	}
    	sb.append(tmp).append("\"재귀함수가 뭔가요?\"\n");
    	if(index>=n) {
    		sb.append(tmp).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
    		sb.append(tmp).append("라고 답변하였지.\n");
    		return;
    	}
    	else {
    		sb.append(tmp).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
        	sb.append(tmp).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
        	sb.append(tmp).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
    	}
    	dfs(index+1, num+1);
    	sb.append(tmp).append("라고 답변하였지.\n");
    }
}
