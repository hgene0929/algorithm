import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static List<List<Integer>> graph = new ArrayList<>();
	static int[] inBounds;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		inBounds = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			inBounds[b]++;
		}

		// solution
		solution();

		// output
		System.out.println(sb);
	}

	static void solution() {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (inBounds[i] != 0 || visited[i]) continue;
			q.offer(i);
			visited[i] = true;
		}

		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			for (int next : graph.get(curr)) {
				inBounds[next]--;
				if (inBounds[next] != 0 || visited[next]) continue;
				q.offer(next);
				visited[next] = true;
			}
		}
	}
}
