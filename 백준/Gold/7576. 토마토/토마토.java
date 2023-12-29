import java.io.*;
import java.util.*;

public class Main {
	static int M, N;
	static int[][] map;
	static List<int[]> done = new ArrayList<>();
	static int[] dr = {-1, 1, 0, 0}; // ↑, ↓, ←, →
	static int[] dc = {0, 0, -1, 1}; // ↑, ↓, ←, →
	static int cntYet = 0;
	static int res = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					done.add(new int[] {i, j});
				}
				else if (map[i][j] == 0) {
					cntYet++;
				}
			}
		}

		// solution & output
		if (cntYet == 0) {
			System.out.println(0);
			return;
		}

		BFS();

		System.out.println(cntYet != 0 ? -1 : res);
	}

	static void BFS() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < done.size(); i++) {
			int r = done.get(i)[0], c = done.get(i)[1];
			queue.offer(new int[] {r, c, 0});
			visited[r][c] = true;
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0], c = now[1], cnt = now[2];

			res = Math.max(res, cnt);

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (!(nr >=0 && nr < N && nc >= 0 && nc < M) || visited[nr][nc] || map[nr][nc] != 0) continue;
				map[nr][nc] = 1;
				cntYet--;
				queue.offer(new int[] {nr, nc, cnt+1});
				visited[nr][nc] = true;
			}
		}
	}
}
