import java.io.*;
import java.util.*;

public class Solution {
	static int N, W, H;
	static int[][] map, copiedMap;
	static int[] orders;
	static int[][] directions = { {-1,0},{1,0},{0,-1},{0,1} };
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// input
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			for(int r=0; r<H; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int c=0; c<W; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// solution
			res = Integer.MAX_VALUE;
			orders = new int[N];
			permutations(0);

			// output
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}

		System.out.println(sb);
	}

	static void permutations(int cnt) {
		if(cnt == N) {
			simulation();
			return;
		}
		for(int i=0; i<W; i++) {
			orders[cnt] = i;
			permutations(cnt+1);
		}
	}

	static void simulation() {
		copyMap();

		int sr = 0, sc = 0;
		for(int order : orders) {
			for(int r=0; r<H; r++) {
				if(copiedMap[r][order] != 0) {
					sr = r; sc = order;
					break;
				}
			}
			BFS(sr, sc);
			placeAnOrder();
		}

		res = Math.min(res, countBlocks());
	}

	static void BFS(int sr, int sc) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { sr, sc, copiedMap[sr][sc] });
		copiedMap[sr][sc] = 0;

		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for(int d=0; d<4; d++) {
				int nr = now[0];
				int nc = now[1];
				for(int i=0; i<now[2]-1; i++) {
					nr += directions[d][0];
					nc += directions[d][1];
					if(!(nr>=0 && nr<H && nc>=0 && nc<W)) break;
					if(copiedMap[nr][nc] != 0) queue.offer(new int[] { nr, nc, copiedMap[nr][nc] });
					copiedMap[nr][nc] = 0;
				}
			}
		}
	}

	static void placeAnOrder() {
		Stack<Integer> stack = new Stack<>();
		for(int c=0; c<W; c++) {
			for(int r=0; r<H; r++) {
				if(copiedMap[r][c] != 0) stack.push(copiedMap[r][c]);
			}
			for(int r=H-1; r>=0; r--) {
				if(stack.isEmpty()) copiedMap[r][c] = 0;
				else copiedMap[r][c] = stack.pop();
			}
		}
	}

	static void copyMap() {
		copiedMap = new int[H][W];
		for(int r=0; r<H; r++) {
			for(int c=0; c<W; c++) {
				copiedMap[r][c] = map[r][c];
			}
		}
	}

	static int countBlocks() {
		int cnt = 0;
		for(int r=0; r<H; r++) {
			for(int c=0; c<W; c++) {
				if(copiedMap[r][c] != 0) cnt++;
			}
		}
		return cnt;
	}
}
