import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		Red red = new Red(0, 0);
		Blue blue = new Blue(0, 0);

		for(int r=0; r<N; r++) {
			String input = br.readLine();
			for(int c=0; c<M; c++) {
				map[r][c] = input.charAt(c);
				if(map[r][c] == 'R') {
					red.r = r;
					red.c = c;
				}
				else if(map[r][c] == 'B') {
					blue.r = r;
					blue.c = c;
				}
			}
		}

		// solution
		bfs(red, blue, 0);

		// output
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void bfs(Red startRed, Blue startBlue, int cnt) { // 최단거리 구해야해서 bfs 탐색시도
		int[][] directions = { {-1,0},{1,0},{0,-1},{0,1} };
		Queue<Pair> queue = new ArrayDeque<>();
		queue.offer(new Pair(startRed, startBlue, cnt));
		visited[startRed.r][startRed.c][startBlue.r][startBlue.c] = true;

		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			if(pair.cnt >= 10) return; // 기울임횟수가 10 초과이면 그냥 -1 출력

			Red red = pair.red;
			Blue blue = pair.blue;
			int curCnt = pair.cnt;

			for(int d=0; d<4; d++) {
				/* 구슬이동 */
				Red nextRed = new Red(red.r, red.c);
				Blue nextBlue = new Blue(blue.r, blue.c);
				while(map[nextRed.r+directions[d][0]][nextRed.c+directions[d][1]] != '#') { // 빨간구슬 이동(벽이 아닐때까지 반복) 어차피 가장자리는 모두 벽(범위 확인X)
					nextRed.r += directions[d][0];
					nextRed.c += directions[d][1];
					if(map[nextRed.r][nextRed.c] == 'O') break; // 빨간구슬 구멍에 들어가면 기울임중단
				}
				while(map[nextBlue.r+directions[d][0]][nextBlue.c+directions[d][1]] != '#') { // 파란구슬 이동(벽이 아닐때까지 반복) 어차피 가장자리는 모두 벽(범위 확인X)
					nextBlue.r += directions[d][0];
					nextBlue.c += directions[d][1];
					if(map[nextBlue.r][nextBlue.c] == 'O') break; // 파란구슬 구멍에 들어가면 기울임중단
				}

				/* 성공여부 확인 */
				if(map[nextBlue.r][nextBlue.c] == 'O') continue; // 파란구슬이 구멍에 들어가면 해당 경우의 수는 실패처리(꼭 얘를 먼저 확인해야함)
				if(map[nextRed.r][nextRed.c] == 'O') {
					min = Math.min(min, curCnt+1); // 빨간구슬이 구멍에 들어가면 해당 경우의 수는 성공처리(거리 비교해서 더작은 걸로 갱신)
					return;
				}

				/* 빨간구슬과 파란구슬이 겹친경우 처리 */
				if(nextRed.r == nextBlue.r && nextRed.c == nextBlue.c && map[nextRed.r][nextRed.c] != 'O') {
					int redDist = Math.abs(red.r - nextRed.r) + Math.abs(red.c - nextRed.c);
					int blueDist = Math.abs(blue.r - nextBlue.r) + Math.abs(blue.c - nextBlue.c);
					if(blueDist < redDist) { // 파란공이 먼저 도착한 경우(뒤늦게 도착한 빨간공을 한칸 뒤로 배치)
						nextRed.r -= directions[d][0];
						nextRed.c -= directions[d][1];
					} else { // 빨간공이 먼저 도착한 경우(뒤늦게 도착한 파란공을 한칸 뒤로 배치) 동시에 도착한다면 빨간공을 우선순위로
						nextBlue.r -= directions[d][0];
						nextBlue.c -= directions[d][1];
					}
				}

				/* 방문여부 처리 */
				if(!visited[nextRed.r][nextRed.c][nextBlue.r][nextBlue.c]) {
					visited[nextRed.r][nextRed.c][nextBlue.r][nextBlue.c] = true;
					queue.offer(new Pair(nextRed, nextBlue, curCnt+1));
				}
			}
		}
	}
}

class Red {
	int r, c;

	public Red(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Blue {
	int r, c;

	public Blue(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Pair {
	Red red;
	Blue blue;
	int cnt;

	public Pair(Red red, Blue blue, int cnt) {
		this.red = red;
		this.blue = blue;
		this.cnt = cnt;
	}
}