import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

		// solution
		dp = new int[N];
		dp[0] = arr[0];
		int len = 1;

		for (int i = 1; i < N; i++) {
			if (dp[len-1] < arr[i]) {
				dp[len++] = arr[i];
			}
			else if (dp[len-1] > arr[i]) {
				int idx = LOWER_BOUND(0, len - 1, arr[i]);
				dp[idx] = arr[i];
			}
		}

		// output
		System.out.println(N - len);
	}

	static int LOWER_BOUND(int l, int r, int target) {
		while (l < r) {
			int mid = (l + r) / 2;
			if (dp[mid] >= target) r = mid;
			else l = mid + 1;
		}
		return r;
	}
}
