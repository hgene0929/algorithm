import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] nums, dp, indexes;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

		// solution
		dp = new int[N];
		dp[0] = nums[0];
		indexes = new int[N];
		indexes[0] = 0;

		int len = 1;
		for (int i = 1; i < N; i++) {
			if (nums[i] > dp[len-1]) {
				indexes[i] = len;
				dp[len++] = nums[i];
			}
			else {
				int idx = LOWER_BOUND(0, len-1, nums[i]);
				indexes[i] = idx;
				dp[idx] = nums[i];
			}
		}

		sb.append(len).append("\n");
		BACK_TRACK(len);

		// output
		System.out.println(sb.toString());
	}

	static int LOWER_BOUND(int l, int r, int target) {
		while (l < r) {
			int mid = (l + r) / 2;
			if (dp[mid] >= target) r = mid;
			else l = mid + 1;
		}
		return r;
	}

	static void BACK_TRACK(int len) {
		Stack<Integer> stack = new Stack<>();
		int index = len - 1;
		for (int i = N-1; i >= 0; i--) {
			if (indexes[i] == index) {
				stack.push(nums[i]);
				index--;
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
	}
}
