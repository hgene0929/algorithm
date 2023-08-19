import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int minDist = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int r=0; r<N; r++) {
			String input = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = input.charAt(c) - '0';
			}
		}

		// solution
		BFS();

		// output
		System.out.println(minDist);
	}

	static void BFS() {
		int[][] directions = { {-1,0},{1,0},{0,-1},{0,1} };
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		queue.add(new int[] { 0,0,1 });
		visited[0][0] = true;

		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(now[0] == N-1 && now[1] == M-1) minDist = now[2];
			for(int d=0; d<4; d++) {
				int nr = now[0] + directions[d][0];
				int nc = now[1] + directions[d][1];
				if(!(nr>=0 && nr<N && nc>=0 && nc<M) || visited[nr][nc] || map[nr][nc] != 1) continue;
				queue.add(new int[] { nr,nc,now[2]+1 });
				visited[nr][nc] = true;
			}
		}
	}
}