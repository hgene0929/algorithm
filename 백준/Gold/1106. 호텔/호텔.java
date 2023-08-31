import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] cost = new int[N];  //비용
		int[] value = new int[N]; //고객수
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		// solution
		int[] dp = new int[C+101];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for(int i=0; i<N; i++) {
			for(int j=1; j<C+101; j++) {
				if(j-value[i] >= 0) {
					if(dp[j-value[i]] != Integer.MAX_VALUE) { //Integer.MAX_VALUE일때 값을 누적하면 쓰레기값이 생김
						dp[j] = Math.min(dp[j], dp[j-value[i]] + cost[i]);
					}
				}
			}
		}

		int res = Integer.MAX_VALUE;
		for(int i=C; i<C+101; i++) {
			res = res > dp[i] ? dp[i] : res;
		}

		// output
		System.out.println(res);
	}
}
