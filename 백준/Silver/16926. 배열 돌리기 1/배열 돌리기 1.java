import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// solution
		int[][] directions = { {1,0},{0,1},{-1,0},{0,-1} };

		for(int repeat=0; repeat<R; repeat++) {
			boolean[][] visited = new boolean[N][M];
			Queue<Integer> queue = new LinkedList<>();

			int cntVisited = 0;
			int r = 0; int c = 0; int d = 0;
			int sr = 0; int sc = 0;
			queue.offer(map[r][c]);

			while(true) {
				if(cntVisited == N*M) {
					break;
				}

				int nr = r+directions[d][0];
				int nc = c+directions[d][1];

				if((nr == sr) && (nc == sc)) {
					visited[nr][nc] = true;
					map[nr][nc] = queue.poll();
					r = nr+1; c = nc+1; sr = r; sc = c; d = 0;
					queue.offer(map[r][c]);
					cntVisited++;
					continue;
				}

				if(!(nr>=0 && nr<N && nc>=0 && nc<M) || visited[nr][nc]) {
					d = (d+1) % 4;
					continue;
				}

				visited[nr][nc] = true;
				queue.offer(map[nr][nc]);
				map[nr][nc] = queue.poll();
				r = nr; c = nc;
				cntVisited++;
			}
		}

		// output
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}