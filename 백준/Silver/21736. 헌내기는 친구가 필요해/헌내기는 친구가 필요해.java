import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[][] directions = { {-1,0},{1,0},{0,-1},{0,1} };
	static int res = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		int[] start = new int[2];
		for(int r=0; r<N; r++) {
			String inputs = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = inputs.charAt(c);
				if(map[r][c] == 'I') {
					start[0] = r;
					start[1] = c;
				}
			}
		}

		// solution
		visited = new boolean[N][M];
		DFS(start[0], start[1]);

		// output
		System.out.println(res == 0 ? "TT" : res);
	}

	static void DFS(int r, int c) {
		visited[r][c] = true;
		if(map[r][c] == 'P') res++;

		for(int d=0; d<4; d++) {
			int nr = r + directions[d][0];
			int nc = c + directions[d][1];
			if(!(nr>=0 && nr<N && nc>=0 && nc<M) || visited[nr][nc] || map[r][c] == 'X') continue;
			DFS(nr, nc);
		}
	}
}
