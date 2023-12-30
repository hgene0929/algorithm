import java.io.*;
import java.util.*;

public class Main {
	static int n, m, t, s, g, h, targetCost;
	static List<List<Node>> graph;
	static final int MAX = Integer.MAX_VALUE / 2;
	static List<Integer> results;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			// input
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>(n+1);
			for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				graph.get(a).add(new Node(b, cost));
				graph.get(b).add(new Node(a, cost));
				if ((a == g && b == h) || (a == h && b == g)) targetCost = cost;
			}

			// solution & output
			results = new ArrayList<>();
			for (int i = 0; i < t; i++) {
				int dest = Integer.parseInt(br.readLine());

				int[] distances = DIJKSTRA(dest);
				if (distances[s] >= MAX) continue;
				int total = distances[s];

				int[] distancesG = DIJKSTRA(g);
				int[] distancesH = DIJKSTRA(h);

				int distG = 0, distH = 0;
				if (distancesG[dest] + distancesH[s] < distancesG[s] + distancesH[dest]) {
					distG = distancesG[dest];
					distH = distancesH[s];
				}
				else {
					distG = distancesG[s];
					distH = distancesH[dest];
				}

				if (total == distG + distH + targetCost) {
					results.add(dest);
				}
			}

			Collections.sort(results);
			for (int result : results) sb.append(result).append(" ");
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static int[] DIJKSTRA(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		int[] distances = new int[n+1];
		Arrays.fill(distances, MAX);
		pq.offer(new Node(start, 0));
		distances[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.cost > distances[now.idx]) continue;

			for (Node next : graph.get(now.idx)) {
				if (distances[now.idx] + next.cost < distances[next.idx]) {
					pq.offer(new Node(next.idx, distances[now.idx] + next.cost));
					distances[next.idx] = distances[now.idx] + next.cost;
				}
			}
		}

		return distances;
	}

	static class Node {
		int idx, cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}
