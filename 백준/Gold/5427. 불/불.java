import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			char[][] map = new char[h][w];
			int[][] visited = new int[h][w];
			Queue<int[]> queue = new LinkedList<>();
			Queue<int[]> fireQueue = new LinkedList<>();

			for(int r=0; r<h; r++) {
				String input = br.readLine();
				for(int c=0; c<w; c++) {
					map[r][c] = input.charAt(c);
					if(input.charAt(c) == '*') {
						fireQueue.offer(new int[] {r,c});
						visited[r][c] += 1;
					} else if(input.charAt(c) == '@') {
						queue.offer(new int[] {r,c,0});
						visited[r][c] += 2;
					}
				}
			}

			// solution
			int[][] directions = { {-1,0},{1,0},{0,-1},{0,1} };
			int min = Integer.MAX_VALUE;
			while(!queue.isEmpty()) {
				// fire
				int fireQueueSize = fireQueue.size();
				for(int i=0; i<fireQueueSize; i++) {
					int[] fireInfo = fireQueue.poll();
					for(int d=0; d<4; d++) {
						int nr = fireInfo[0]+directions[d][0];
						int nc = fireInfo[1]+directions[d][1];
						if(nr>=0 && nr<h && nc>=0 && nc<w && visited[nr][nc]<1 && map[nr][nc] != '#') {
							visited[nr][nc] += 1;
							fireQueue.offer(new int[] {nr,nc});
						}
					}
				}

				// move
				int queueSize = queue.size();
				for(int i=0; i<queueSize; i++) {
					int[] info = queue.poll();
					int r = info[0]; int c = info[1]; int cnt = info[2];
					if(cnt >= min) {
						continue;
					}
					if(r==h-1 || r==0 || c==w-1 || c==0) {
						min = Math.min(min, cnt+1);
					}
					for(int d=0; d<4; d++) {
						int nr = r+directions[d][0];
						int nc = c+directions[d][1];
						if(nr>=0 && nr<h && nc>=0 && nc<w && visited[nr][nc]<1 && map[nr][nc] != '#') {
							visited[nr][nc] += 2;
							queue.offer(new int[] {nr,nc,cnt+1});
						}
					}
				}
			}
			// output
			if(min == Integer.MAX_VALUE) {
				sb.append("IMPOSSIBLE").append("\n");
			} else {
				sb.append(min).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}