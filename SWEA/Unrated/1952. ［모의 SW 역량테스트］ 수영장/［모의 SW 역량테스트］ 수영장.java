import java.io.*;
import java.util.*;

public class Solution {
	static int[] prices = new int[4];
	static int[] schedules = new int[13];
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=12; i++) {
				schedules[i] = Integer.parseInt(st.nextToken());
			}

			// solution
			min = prices[3]; // 1년 이용권이랑 전체 비교
			dfs(1, 0);

			// output
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}

		System.out.println(sb.toString());
	}

	static void dfs(int month, int price) {
		if(month == 13) { // 12월 모두 탐색완료
			min = Math.min(min, price);
			return;
		}
		// 해당 월에 이용권 X
		if(schedules[month] == 0) {
			dfs(month+1, price);
		}
		// 1일 이용권
		if(schedules[month] > 0) {
			dfs(month+1, price+schedules[month]*prices[0]);
		}
		// 1달 이용권
		dfs(month+1, price+prices[1]);
		// 3달 이용권
		if(month <= 10) {
			dfs(month+3, price+prices[2]);
		}
	}
}