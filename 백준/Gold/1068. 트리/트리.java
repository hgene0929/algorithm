import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] removed;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) graph.add(new ArrayList<>());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent == -1) continue;
			graph.get(parent).add(i);
		}

		// solution
		removed = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			int remove = Integer.parseInt(st.nextToken());
			BFS(remove);
		}

		int res = 0;
		for (int i = 0; i < N; i++) {
			if (count(i) == 0 && !removed[i]) {
				res++;
			}
		}

		// output
		System.out.println(res);
	}

	static int count(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		queue.offer(start);
		visited[start] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : graph.get(now)) {
				if (visited[next] || removed[next]) continue;
				cnt++;
				queue.offer(next);
				visited[next] = true;
			}
		}

		return cnt;
	}

	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		removed[start] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : graph.get(now)) {
				if (removed[next]) continue;
				queue.offer(next);
				removed[next] = true;
			}
		}
	}
}
