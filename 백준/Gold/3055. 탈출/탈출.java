import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static int[] hedgehog = new int[2];
	static List<int[]> waters = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c);
				if(map[r][c] == '*') {
					waters.add(new int[] {r, c});
				} else if(map[r][c] == 'S') {
					hedgehog[0] = r;
					hedgehog[1] = c;
				}
			}
		}

		// solution
		int res = BFS();

		// output
		System.out.println(res == 0 ? "KAKTUS" : res);
	}

	static int BFS() {
		int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[R][C];
		for(int[] water : waters) {
			queue.offer(new int[] {water[0], water[1]});
		}
		queue.offer(new int[] {hedgehog[0], hedgehog[1], 0});
		visited[hedgehog[0]][hedgehog[1]] = true;

		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			// 종료조건
			if(now.length == 3 && map[now[0]][now[1]] == 'D') {
				return now[2];
			}
			for(int d=0; d<4; d++) {
				int nr = now[0] + directions[d][0];
				int nc = now[1] + directions[d][1];
				if(!(nr>=0 && nr<R && nc>=0 && nc<C) || map[nr][nc] == 'X') continue;
				// 물
				if(now.length == 2 && map[nr][nc] == '.') {
					map[nr][nc] = '*';
					queue.offer(new int[] {nr, nc});
				}
				// 고슴도치
				if(now.length == 3 && (map[nr][nc] != '*' && !visited[nr][nc])) {
					queue.offer(new int[] {nr, nc, now[2]+1});
					visited[nr][nc] = true;
				}
			}
		}
		return 0;
	}
}
