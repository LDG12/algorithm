package baekjoon.Silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class baekjoon1463 {
	static int n,m,k;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		for(int i=2; i<=n; i++){
			dp[i] = dp[i-1]+1;
			if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
			if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);
		}
		System.out.println(dp[n]);
	}
}
