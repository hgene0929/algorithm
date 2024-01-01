import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr, combi;
	static boolean[] selected;
	static Set<Integer> set = new HashSet<>();
	static int res = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

		// solution
		if (N == 2) {
			System.out.println(0);
			return;
		}

		selected = new boolean[N];
		combi = new int[2];
		Arrays.sort(arr);
		COMBINATIONS(0, 0);

		// output
		System.out.println(res);
	}

	static void COMBINATIONS(int depth, int start) {
		if (depth == 2) {
			int target = combi[0] + combi[1];
			if (set.contains(target)) return;
			int cnt = UPPER_BOUND(0, N, target) - LOWER_BOUND(0, N, target);
			if ((combi[0] == 0 || combi[1] == 0) && cnt <= 1) return;
			else if (combi[0] == 0 && combi[1] == 0 && cnt <= 2) return;
			set.add(target);
			res += cnt;
			return;
		}

		for (int i = start; i < N; i++) {
			if (selected[i]) continue;
			selected[i] = true;
			combi[depth] = arr[i];
			COMBINATIONS(depth+1, i+1);
			selected[i] = false;
		}
	}

	static int UPPER_BOUND(int l, int r, int target) {
		while (l < r) {
			int mid = (l + r) / 2;
			if (arr[mid] > target) r = mid;
			else l = mid + 1;
		}
		return r;
	}

	static int LOWER_BOUND(int l, int r, int target) {
		while (l < r) {
			int mid = (l + r) / 2;
			if (arr[mid] < target) l = mid + 1;
			else r = mid;
		}
		return l;
	}
}
