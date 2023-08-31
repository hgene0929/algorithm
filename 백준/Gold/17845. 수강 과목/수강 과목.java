import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //최대공부시간
		int K = Integer.parseInt(st.nextToken()); //과목수

		int[] cost = new int[K];  //비용
		int[] value = new int[K]; //가치

		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			value[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}

		// solution
		int[] dp = new int[N+1];
		dp[0] = 0;

		for(int i=0; i<K; i++) {
			//뒤에서부터 탐색해야 하는 이유 : 재료의 개수가 1개임 -> 앞에서부터하면 재료의 수가 무한정으로 사용됨
			for(int j=N; j>=1; j--) {
				if(j-cost[i] >= 0) {
					dp[j] = Math.max(dp[j-cost[i]] + value[i], dp[j]);
				}
			}
		}

		// output
		System.out.println(dp[N]);
	}
}
