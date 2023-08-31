import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// input
			int N = Integer.parseInt(br.readLine());
			int[] coins =  new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());

			// solution
			int[] dp = new int[M+1];
			dp[0] = 1;
			for(int i=0; i<N; i++) { //재료들을 각각 들여다보며
				for(int j=1; j<=M; j++) { //만들어야하는 값들을 완탐 => DP 테이블은 그 과정에서 중복연산하지 않도록 이전의 값들을 저장하는 역할
					if(j-coins[i] >= 0) {
						dp[j] += dp[j-coins[i]];
					}
				}
			}

			// output
			sb.append(dp[M]).append("\n");
		}

		System.out.println(sb.toString());
	}

}
