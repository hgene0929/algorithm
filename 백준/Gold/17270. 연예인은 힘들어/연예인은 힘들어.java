import java.util.*;
import java.io.*;

public class Main {

	static class Node {
		int idx, cost;
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	static int V, M;
	static List<List<Node>> graph = new ArrayList<>();
	static int J, S;
	static final int INF = Integer.MAX_VALUE / 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine(), " ");
		J = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		// solution
		int[] fromJ = DIJKSTRA(J);
		int[] fromS = DIJKSTRA(S);

		int minTotal = INF;
		for (int i = 1; i <= V; i++) {
			if (i == J || i == S) continue;
			minTotal = Math.min(minTotal, fromS[i]+fromJ[i]);
		}
		int res = -1, minJ = INF;

		for (int i = 1; i <= V; i++) {
			// 1st 조건
			if (i == S || i == J) continue;
			// 2nd 조건
			if (minTotal != fromS[i] + fromJ[i]) continue;
			// 3rd 조건
			if (fromS[i] >= fromJ[i]) {
				if (fromJ[i] < minJ) {
					res = i;
					minJ = fromJ[i];
				}
			}
		}

		// output
		System.out.println(res);
	}

	static int[] DIJKSTRA(int from) {
		PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		int[] dist = new int[V+1];
		Arrays.fill(dist, INF);
		queue.offer(new Node(from, 0));
		dist[from] = 0;

		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (now.cost < dist[now.idx]) {
				continue;
			}
			for (Node next : graph.get(now.idx)) {
				if (now.cost + next.cost < dist[next.idx]) {
					dist[next.idx] = now.cost + next.cost;
					queue.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}

		return dist;
	}
}
