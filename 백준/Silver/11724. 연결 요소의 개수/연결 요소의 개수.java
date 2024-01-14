import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static List<List<Integer>> graph = new ArrayList<>();
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N+1];
		for (int i = 1; i <= N; i++) parents[i] = i;

		// solution
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			union(u, v);
		}

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(find(i));
		}

		// output
		System.out.println(set.size());
	}

	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		parents[pa] = pb;
	}

	static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
}
