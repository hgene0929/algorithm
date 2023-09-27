import java.io.*;
import java.util.*;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// input
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[][] graph = new int[N][N];

			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					graph[r][c] = Integer.parseInt(st.nextToken());
					if(graph[r][c] == 0) {
						graph[r][c] = 1001;
					}
				}
			}

			// solution
			// (1) 모든 출발지~도착지 까지 최단거리 구하기
			for(int via=0; via<N; via++) { //경유지
				for(int r=0; r<N; r++) { //출발지
					for(int c=0; c<N; c++) { //도착지
						if(r == c) {
							continue;
						}
						graph[r][c] = Math.min(graph[r][c], graph[r][via] + graph[via][c]);
					}
				}
			}

			// (2) 모든 출발지로부터의 최단거리 합이 제일 작은 도착지 구하기
			int minDist = Integer.MAX_VALUE;
			for(int r=0; r<N; r++) {
				int sum = 0;
				for(int c=0; c<N; c++) {
					if(r == c) {
						continue;
					}
					sum += graph[r][c];
				}
				minDist = Math.min(minDist, sum);
			}

			// output
			sb.append("#").append(t).append(" ").append(minDist).append("\n");
		}

		System.out.println(sb.toString());
	}
}
