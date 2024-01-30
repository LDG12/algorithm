package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class baekjoon6443 {
	static int[] dx= {1,0,0,-1};
	static int[] dy= {0,1,-1,0};
	static int[] arr;
	static char[] arr2;
	static int direction;
	static int n,m,k;
	static StringTokenizer st;
	static StringBuilder sb;
	static ArrayList<int[]>chicken;
	static ArrayList<int[]>house;
	static Set<String>set;
	static PriorityQueue<String>pq;
	static Stack<Character>stack; 
	static int min;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		//여기에 코드를 작성하세요.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			stack = new Stack<>();
			arr = new int[26];
			arr2 = br.readLine().toCharArray();
			for(int j=0; j<arr2.length; j++) {
				arr[arr2[j]-'a']++;
			}
			dfs(0, "");
		}
		System.out.print(sb.toString());
	}
	static void dfs(int depth, String tmp) {
		if(depth>=arr2.length) {
			System.out.println(tmp);
			return;
		}
		for(int i=0; i<26; i++) {
			if(arr[i]>0) {
				arr[i]--;
				dfs(depth+1, tmp+(char)(i+'a'));
				arr[i]++;
			}
		}
	}
}
