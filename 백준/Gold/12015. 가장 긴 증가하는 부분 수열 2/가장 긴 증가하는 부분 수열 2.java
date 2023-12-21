import java.io.*;
import java.util.*;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

		// solution
		dp = new int[N];
		dp[0] = nums[0];

		int len = 1;
		for (int i = 1; i < N; i++) {
			if (dp[len-1] < nums[i]) {
				dp[len++] = nums[i];
			}
			else if (dp[len-1] > nums[i]) {
				int upper = UPPER_BOUND(0, len-1, nums[i]);
				dp[upper] = nums[i];
			}
		}
		// output
		System.out.println(len);
	}

	static int UPPER_BOUND(int l, int r, int target) {
		while (l < r) {
			int mid = (l + r) / 2;
			if (dp[mid] < target) l = mid + 1;
			else r = mid;
		}
		return r;
	}
}
