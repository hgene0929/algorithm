import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		int N = Integer.parseInt(br.readLine());
		int[] stairs = new int[N+1];
		for(int i=1; i<=N; i++) stairs[i] = Integer.parseInt(br.readLine());

		// solution
		int[] dp = new int[N+1];
		dp[1] = stairs[1];
		if(N >= 2) dp[2] = stairs[2] + stairs[1];
		if(N >= 3) dp[3] = Math.max(stairs[1]+stairs[3], stairs[2]+stairs[3]);

		for(int i=4; i<=N; i++) {
			dp[i] = Math.max(dp[i-3]+stairs[i]+stairs[i-1], dp[i-2]+stairs[i]);
		}

		// output
		System.out.println(dp[N]);
	}
}
