import java.io.*;
import java.util.*;

public class Main {
	static int A, B, C;
	static boolean[][][] memo;
	static Set<Integer> set = new HashSet<>();
	static List<Integer> res = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// solution
		memo = new boolean[A+1][B+1][C+1];
		DFS(0, 0, C);

		StringBuilder sb = new StringBuilder();
		Collections.sort(res);
		for (int r : res) sb.append(r).append(" ");

		// output
		System.out.println(sb);
	}

	static void DFS(int a, int b, int c) {
		if (!set.contains(c) && a == 0) {
			set.add(c);
			res.add(c);
		}

		if (memo[a][b][c]) {
			return;
		}
		memo[a][b][c] = true;

		int nextA, nextB, nextC;

		// 1. a -> b
		nextA = Math.max(a - (B-b), 0);
		nextB = a + b > B ? B : a + b;
		DFS(nextA, nextB, c);

		// 2. a -> c
		nextA = Math.max(a - (C-c), 0);
		nextC = a + c > C ? C : a + c;
		DFS(nextA, b, nextC);

		// 3. b -> a
		nextB = Math.max(b - (A-a), 0);
		nextA = b + a > A ? A : b + a;
		DFS(nextA, nextB, c);

		// 4. b -> c
		nextB = Math.max(b - (C-c), 0);
		nextC = b + c > C ? C : b + c;
		DFS(a, nextB, nextC);

		// 5. c -> a
		nextC = Math.max(c - (A-a), 0);
		nextA = c + a > A ? A : c + a;
		DFS(nextA, b, nextC);

		// 6. c -> b
		nextC = Math.max(c - (B-b), 0);
		nextB = c + b > B ? B : c + b;
		DFS(a, nextB, nextC);
	}
}
