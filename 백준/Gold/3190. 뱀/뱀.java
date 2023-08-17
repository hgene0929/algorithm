import java.io.*;
import java.util.*;

public class Main {
	static int N, K, L;
	static int[][] map;
	static boolean[][] located;
	static int[][] directions = { {0,1},{1,0},{0,-1},{-1,0} }; //우하좌상:0123
	static String[] rotations = new String[10001];
	static Deque<Snake> snakes = new ArrayDeque<>();
	static int time = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// intput
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		located = new boolean[N][N];

		K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = 1;
		}

		L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			String direction = st.nextToken();
			rotations[time] = direction;
		}

		// solution
		simulation(0, 0, 0); // (1,1)에서 오른쪽 방향으로 시작

		// output
		System.out.println(time);
	}

	static void simulation(int r, int c, int d) {
		snakes.offerLast(new Snake(r, c));
		map[r][c] = 2;

		while(true) {
			/* 시간증가 */
			time++;

			/* 다음위치 정의 */
			int nr = r + directions[d][0];
			int nc = c + directions[d][1];

			/* 다음위치 가능여부 확인 후, 이동 */
			if(!(nr>=0 && nr<N && nc>=0 && nc<N) || map[nr][nc] == 2) break;
			r = nr; c = nc;

			/* 사과먹는지 여부 확인 */
			if(map[r][c] != 1) {
				Snake removal = snakes.pollFirst();
				map[removal.r][removal.c] = 0;
			}
			snakes.offerLast(new Snake(r, c));
			map[r][c] = 2;

			/* 방향 바꾸기 */
			if(rotations[time] != null) {
				if(rotations[time].equals("D")) d = rotateRight(d);
				else d = rotateLeft(d);
			}
		}
	}

	static int rotateRight(int d) {
		return (d + 1) % 4;
	}
	static int rotateLeft(int d) {
		return (d + 3) % 4;
	}
}

class Snake {
	int r, c;

	public Snake(int r, int c) {
		this.r = r;
		this.c = c;
	}
}