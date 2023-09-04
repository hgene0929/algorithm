import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Integer[] caffeines = new Integer[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) caffeines[i] = Integer.parseInt(st.nextToken());

		// solution
		int[] dp = new int[K+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for(int i=0; i<N; i++) {
			for(int j=K; j>=1; j--) { //재료의 개수가 한정되어 있으므로, dp 테이블의 이전값을 참조할 수 있도록 뒤에서부터 확인
				if(j-caffeines[i] >= 0) {
					if(dp[j-caffeines[i]] == Integer.MAX_VALUE) { //MAX_VALUE + 1결과 쓰레기값이 나오지 않도록 하는 조치
						dp[j] = Math.min(Integer.MAX_VALUE, dp[j]);
					} else {
						dp[j] = Math.min(dp[j-caffeines[i]] + 1, dp[j]);
					}
				}
			}
		}

		// output
		System.out.println(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]);
	}
}
