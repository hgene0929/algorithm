import java.io.*;
import java.util.*;

public class Main {
	static int N, C;
	static int[] positions;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		positions = new int[N];
		for (int i = 0; i < N; i++) positions[i] = Integer.parseInt(br.readLine());

		// solution
		Arrays.sort(positions);
		int res = PARAMETRIC_SEARCH(0, positions[N-1]-positions[0]+1);

		// output
		System.out.println(res);
	}

	static int PARAMETRIC_SEARCH(int l, int r) {
		while (l+1 < r) {
			int m = (l + r) / 2;
			if (check(m)) l = m;
			else r = m;
		}
		return l;
	}

	static boolean check(int distance) {
		int cnt = 1, last = positions[0];
		for (int i = 1; i < N; i++) {
			if (positions[i] - last >= distance) {
				cnt++;
				last = positions[i];
			}
		}
		return cnt >= C;
	}
}
