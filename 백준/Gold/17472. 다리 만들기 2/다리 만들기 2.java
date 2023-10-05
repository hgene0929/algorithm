import java.io.*;
import java.util.*;

/**
 * 아이디어 :
 * (1) 섬에 번호 붙이기
 * (2) 간선 구하기
 * (3) MST 크루스칼 알고리즘 적용
 */
public class Main {
	static int N, M;
	static int[][] map;
	static int[][] directions = { {-1,0},{1,0},{0,-1},{0,1} };
	static List<int[]> edges = new ArrayList<>();
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// solution
		// (1) 섬에 번호 매기기
		int num = 2;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] == 1) {
					numbering(r, c, num++);
				}
			}
		}

		// (2) 간선구하기
		// (2-1) 수평 간선 구하기
		for(int r=0; r<N; r++) horizontal(r);
		// (2-2) 수직 간선 구하기
		for(int c=0; c<M; c++) vertical(c);

		// (3) MST 구하기(크루스칼)
		// (3-1) 간선 sort
		Collections.sort(edges, (a,b) -> a[2] - b[2]);
		// (3-2) 각 섬의 루트 배열 생성
		parents = new int[num];
		for(int i=2; i<num; i++) parents[i] = i;
		// (3-3) 크루스칼 적용
		int res = kruskal();
		// (3-4) 모든 섬의 루트를 확인해서 다같은지 확인
		boolean same = true;
		int std = find(2);
		for(int i=2; i<num; i++) {
			if(std != find(i)) same = false;
		}

		// output
		System.out.println(same ? res : -1);
	}

	static void numbering(int sr, int sc, int num) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		queue.add(new int[] {sr, sc});
		visited[sr][sc] = true;

		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0], c = now[1];
			map[r][c] = num;
			for(int d=0; d<4; d++) {
				int nr = r + directions[d][0];
				int nc = c + directions[d][1];
				if(!(nr>=0 && nr<N && nc>=0 && nc<M) || visited[nr][nc] || map[nr][nc] == 0) continue;
				queue.offer(new int[] {nr, nc});
				visited[nr][nc] = true;
			}
		}
	}

	static void horizontal(int r) {
		boolean isFirst = true;
		int start = 0, end = 0, len = 1;
		for(int c=0; c<M; c++) {
			if(map[r][c] != 0 && isFirst && c+1 < M && map[r][c+1] == 0) {
				start = map[r][c];
				isFirst = false;
			}
			else if(map[r][c] == 0 && !isFirst && c+1 < M && map[r][c+1] != 0) {
				end = map[r][c+1];
				isFirst = true;
				if(len >= 2) {
					edges.add(new int[] {start, end, len});
					len = 1;
				}
			}
			else if(map[r][c] == 0 && !isFirst) {
				len++;
			}
		}
	}

	static void vertical(int c) {
		boolean isFirst = true;
		int start = 0, end = 0, len = 1;
		for(int r=0; r<N; r++) {
			if(map[r][c] != 0 && isFirst && r+1 < N && map[r+1][c] == 0) {
				start = map[r][c];
				isFirst = false;
			}
			else if(map[r][c] == 0 && !isFirst && r+1 < N && map[r+1][c] != 0) {
				end = map[r+1][c];
                isFirst = true;
				if(len >= 2) {
					edges.add(new int[] {start, end, len});
					len = 1;
				}
			}
			else if(map[r][c] == 0 && !isFirst) {
				len++;
			}
		}
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return false;
		parents[a] = b;
		return true;
	}

	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

	static int kruskal() {
		int cost = 0;
		for(int[] edge : edges) {
			int a = edge[0], b = edge[1], len = edge[2];
			boolean possible = union(a, b);
			if(possible) cost += len;
		}
		return cost;
	}
}