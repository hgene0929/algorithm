import java.io.*;
import java.util.*;

public class Main {
	static int N, M, V;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}

		// solution & output
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs();
	}

	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v+" ");

		for(int i=1; i<=N; i++) {
			if(map[v][i] != 1 || visited[i]) continue;
			dfs(i);
		}
	}

	static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(V);
		visited[V] = true;

		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now+" ");

			for(int i=1; i<=N; i++) {
				if((map[now][i] != 1) || visited[i]) continue;
				queue.offer(i);
				visited[i] = true;
			}
		}
	}
}
