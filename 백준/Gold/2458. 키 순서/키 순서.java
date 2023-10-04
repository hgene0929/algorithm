import java.io.*;
import java.util.*;

/**
 * 아이디어 : 내가 현재 몇번째인지 알기위해서? => "나의 진입차수 + 진출차수 = 전체노드수 - 1"
 */
public class Main {
	static int N, M;
	static List<List<Integer>> graph, reverse;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = 1;
		for(int t=1; t<=T; t++) {
			// input
			graph = new ArrayList<>();
			reverse = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<>());
				reverse.add(new ArrayList<>());
			}

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph.get(from).add(to);
				reverse.get(to).add(from);
			}

			// solution
			int res = 0;
			for(int i=1; i<=N; i++) {
				//내가 현재 몇번째인지 알기위해서? => "나의 진입차수 + 진출차수 = 전체노드수 - 1"
				int out = BFS(i);
				int in = BFSRev(i);
				if(out + in == N-1) res++;
			}

			// output
			System.out.println(res);
		}
	}

	static int BFS(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(start);
		visited[start] = true;

		int cnt = 0;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : graph.get(now)) {
				if(visited[next]) continue;
				queue.offer(next);
				visited[next] = true;
				cnt++;
			}
		}
		return cnt;
	}

	static int BFSRev(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		queue.offer(start);
		visited[start] = true;

		int cnt = 0;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int next : reverse.get(now)) {
				if(visited[next]) continue;
				queue.offer(next);
				visited[next] = true;
				cnt++;
			}
		}
		return cnt;
	}
}
