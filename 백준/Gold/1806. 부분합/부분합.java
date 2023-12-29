import java.io.*;
import java.util.*;

public class Main {
	static int N, S;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());

		// solution & output
		System.out.println(arr[N] < S ? 0 : PARAMETRIC_SEARCH(-1, N));
	}

	static int PARAMETRIC_SEARCH(int l, int r) {
		while (l+1 < r) {
			int m = (l + r) / 2;
			if (check(m)) r = m;
			else l = m;
		}
		return r;
	}

	static boolean check(int len) {
		for (int i = len; i <= N; i++) {
			int sum = arr[i] - arr[i-len];
			if (sum >= S) return true;
		}
		return false;
	}
}
