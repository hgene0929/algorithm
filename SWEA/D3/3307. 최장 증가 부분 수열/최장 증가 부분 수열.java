import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// input
			int N = Integer.parseInt(br.readLine());
			int[] nums = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			// solution
			int[] dp = new int[N];
			int res = Integer.MIN_VALUE;
			for(int i=0; i<N; i++) {
				dp[i] = 1;
				for(int j=i-1; j>=0; j--) {
					if(nums[i] > nums[j]) {
						dp[i] = Math.max(dp[i], dp[j]+1);
					}
				}
				res = Math.max(res, dp[i]);
			}

			// output
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}

		System.out.println(sb.toString());
	}
}
