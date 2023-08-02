import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];

		for(int r=1; r<=n; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=n; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// solution(1)
		// dp 테이블에 누적합 저장
		for(int r=1; r<=n; r++) {
			for(int c=1; c<=n; c++) {
				dp[r][c] = dp[r][c-1] + dp[r-1][c] - dp[r-1][c-1] + map[r][c];
			}
		}

		// solution(2)
		// 전체 맵(2번째 좌표)까지의 범위 - 뺄 맵(1번째 좌표)보다 한칸 적은행 까지의 범위 - 뺄 맵(1번쨰 좌표)보다 한칸 적읜열 까지의 범위 + 중복돼서 뺀 범위
		// map[r2][c2] - map[r2][c1-1] - map[r1-1][c2] + map[r1-1][c1-1]
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int sum = dp[r2][c2] - dp[r2][c1-1] - dp[r1-1][c2] + dp[r1-1][c1-1];
			sb.append(sum+"\n");
		}

		// output
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}