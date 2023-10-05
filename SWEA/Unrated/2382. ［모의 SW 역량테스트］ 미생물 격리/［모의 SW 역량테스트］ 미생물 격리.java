import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, K;
	static List<MicroGroup> groups;
	static int[][] directions = { {0,0},{-1,0},{1,0},{0,-1},{0,1} }; // X U D L R

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// input
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			groups = new ArrayList<>();
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				groups.add(new MicroGroup(r, c, cnt, dir));
			}

			// solution
			for(int time=M; time>0; time--) {
				// 미생물 맵 초기화
				List<MicroGroup>[][] map = new List[N][N];
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						map[r][c] = new ArrayList<>();
					}
				}
				// (1) 이동
				for(MicroGroup group : groups) {
					if(group.cnt == 0) continue;
					group.r = group.r + directions[group.dir][0];
					group.c = group.c + directions[group.dir][1];
					map[group.r][group.c].add(group);
				}
				// (2) 미생물 수 조정
				for(MicroGroup group : groups) {
					if(group.cnt == 0) continue;
					// 약품에 칠해진 셀에 도착
					if(group.r == 0 || group.r == N-1 || group.c == 0 || group.c == N-1) {
						group.cnt /= 2;
						if(group.dir == 1 || group.dir == 3) group.dir += 1;
						else group.dir -= 1;
					}
				}
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						// 두 개 이상의 군집이 한 셀에 모임
						if(map[r][c].size() < 2) continue;
						int sum = 0, max = Integer.MIN_VALUE, dir = 0;
						for(MicroGroup group : map[r][c]) {
							sum += group.cnt;
							if(max < group.cnt) {
								dir = group.dir;
								max = group.cnt;
							}
							group.cnt = 0;
						}
						groups.add(new MicroGroup(r, c, sum, dir));
					}
				}
			}
			// 남아있는 미생물 총합 구하기
			int res = 0;
			for(MicroGroup group : groups) {
				res += group.cnt;
			}

			// output
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}

		System.out.println(sb.toString());
	}
}

class MicroGroup {
	int r, c, cnt, dir;

	public MicroGroup(int r, int c, int cnt, int dir) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.dir = dir;
	}
}
