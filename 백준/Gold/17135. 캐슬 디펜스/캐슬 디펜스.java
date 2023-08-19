import java.io.*;
import java.util.*;

public class Main {
	static int N, M, D;
	static int[][] map;
	static int[] archers = new int[3];
	static int cntEnemies = 0;
	static int maxCnt = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 1) cntEnemies++;
			}
		}

		// solution
		setArchers(0, 0);

		// output
		System.out.println(maxCnt);
	}

	static void setArchers(int cnt, int start) {
		if(cnt == 3) {
			simulation();
			return;
		}
		for(int i=start; i<M; i++) {
			archers[cnt] = i;
			setArchers(cnt+1, i+1);
		}
	}

	static void simulation() {
		int tempCntEnemies = cntEnemies;
		int cntKill = 0;
		int[][] copied = copy();
		while(tempCntEnemies > 0) {
			int minDist = Integer.MAX_VALUE;
			int[] minEnemyRow = { -1, -1, -1 };
			int[] minEnemyCol = { -1, -1, -1 };
			for(int i=0; i<3; i++) {
				// attack
				for(int r=0; r<N; r++) {
					for(int c=0; c<M; c++) {
						if(copied[r][c] != 1) continue;
						int dist = getDistance(N, archers[i], r, c);
						if(dist <= D) {
							if(dist < minDist) {
								minEnemyRow[i] = r;
								minEnemyCol[i] = c;
								minDist = dist;
							} else if(dist == minDist && c < minEnemyCol[i]) {
								minEnemyRow[i] = r;
								minEnemyCol[i] = c;
								minDist = dist;
							}
						}
					}
				}
				minDist = Integer.MAX_VALUE;
			}

			// remove
			for(int i=0; i<3; i++) {
				if(minEnemyRow[i] != -1) {
					if(copied[minEnemyRow[i]][minEnemyCol[i]] == 1) {
						copied[minEnemyRow[i]][minEnemyCol[i]] = 0;
						tempCntEnemies--;
						cntKill++;
					}
				}
			}

			// move
			for(int r=N-1; r>=0; r--) { // 이부분 뒤에서부터 안해주면 애써바꾼거 다시 갱신됨
				for(int c=0; c<M; c++) {
					if(copied[r][c] != 1) continue;
					int nr = r+1;
					if(nr >= N) {
						copied[r][c] = 0;
						tempCntEnemies--;
					} else {
						copied[r][c] = 0;
						copied[nr][c] = 1;
					}
				}
			}
		}

		maxCnt = maxCnt < cntKill ? cntKill : maxCnt;
	}

	static int[][] copy() {
		int[][] copied = new int[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				copied[r][c] = map[r][c];
			}
		}
		return copied;
	}

	static int getDistance(int ar, int ac, int er, int ec) {
		return Math.abs(ar - er) + Math.abs(ac - ec);
	}
}
