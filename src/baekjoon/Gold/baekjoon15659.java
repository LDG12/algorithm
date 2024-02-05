package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class baekjoon15659 {
	static int[] dx= {1,0,-1,0,1,-1,-1,1};
	static int[] dy= {0,1,0,-1,1,-1,1,-1};
	static int[] arr, oper;
	static int[] selectOper;
	static int direction;
	static int n,m,k, max, min;
	static Stack<Character>operStack;
	static Stack<Integer>intStack; 
	static StringTokenizer st;
	static boolean[] visited;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]= Integer.parseInt(st.nextToken()); 
		}
		oper = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			oper[i]= Integer.parseInt(st.nextToken());  
		}
		selectOper = new int[n-1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(0);
		System.out.println(max);
		System.out.println(min);
	}
	static void dfs(int depth) {
		if(depth==n-1) {
			cal();
			return;
		}
		for(int i=0; i<4; i++) {
			if(oper[i]>0) {
				oper[i]--;
				selectOper[depth] = i;
				dfs(depth+1);
				oper[i]++;
			}	
		}
	}
	static void cal() {
		List<Integer> cmdList=new ArrayList<>();
		List<Integer> numList=new ArrayList<>();
		numList.add(arr[0]);
		for (int i = 0; i < selectOper.length; i++) {
			switch(selectOper[i]) {
			case 0:
			case 1:
				numList.add(arr[i+1]);
				cmdList.add(selectOper[i]);
				break;
			case 2:
				numList.add(numList.remove(numList.size()-1) * arr[i+1]);
				break;
			case 3:
				numList.add(numList.remove(numList.size()-1) / arr[i+1]);
				break;
			}
		}
		int ret=numList.get(0);
		if(!cmdList.isEmpty()) {
			for (int i = 0; i < cmdList.size(); i++) {
				int cmd=cmdList.get(i);
				if(cmd==0) {
					ret+=numList.get(i+1);
				}else {
					ret-=numList.get(i+1);
				}
			}
		}
		max=Math.max(max, ret);
		min=Math.min(min, ret);
	}
	
}
