import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] aArr, bArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		aArr = new int[N];
		bArr = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			aArr[i] = Integer.parseInt(st.nextToken());
			bArr[i] = Integer.parseInt(st.nextToken());
		}

		// solution
		int[][] dp = new int[K + 1][5001];
		for (int i = 0; i < K; i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[0][1] = 0; // 1초, 1s

		for (int i = 0; i < K; i++) { // 시간
			for (int j = 0; j <= 5000; j++) { // s
				if (dp[i][j] == -1) continue;
				dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + j);
				for (int k = 0; k < N; k++) { // aArr, bArr
					int a = aArr[k];
					int b = bArr[k];
					if (dp[i][j] - a < 0 || j + b > 5000) continue;
					dp[i + 1][j + b] = Math.max(dp[i + 1][j + b], dp[i][j] - a);
				}
			}
		}

		int res = 0;
		for (int i = 0; i <= 5000; i++) {
			res = Math.max(res, dp[K][i]);
		}

		// output
		System.out.println(res);
	}
}
