import java.io.*;
import java.util.*;

public class Solution {
	static int M, A; //총이동시간, BC개수
	static int[] movesA, movesB; //A이동계획, B이동계획
	static BatteryCharger[] batteryChargers; //BC정보
	static int[][] directions = { {0,0},{-1,0},{0,1},{1,0},{0,-1} }; //이동X,상,우,하,좌
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// input
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			movesA = new int[M];
			movesB = new int[M];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<M; i++) movesA[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<M; i++) movesB[i] = Integer.parseInt(st.nextToken());

			batteryChargers = new BatteryCharger[A];
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken()) - 1;
				int coverage = Integer.parseInt(st.nextToken());
				int performance = Integer.parseInt(st.nextToken());
				batteryChargers[i] = new BatteryCharger(c, r, coverage, performance);
			}

			// solution
			res = 0;
			simulations();

			// output
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}

		System.out.println(sb);
	}

	static void simulations() {
		int[] a = { 0, 0 };
		int[] b = { 9, 9 };

		charge(a[0], a[1], b[0], b[1]);

		for(int i=0; i<M; i++) {
			a[0] += directions[movesA[i]][0];
			a[1] += directions[movesA[i]][1];
			b[0] += directions[movesB[i]][0];
			b[1] += directions[movesB[i]][1];
			charge(a[0], a[1], b[0], b[1]);
		}
	}

	static void charge(int ar, int ac, int br, int bc) {
		List<Integer> chargerA = new ArrayList<>();
		List<Integer> chargerB = new ArrayList<>();

		for(int i=0; i<A; i++) {
			if(inCoverage(ar, ac, batteryChargers[i])) chargerA.add(i);
			if(inCoverage(br, bc, batteryChargers[i])) chargerB.add(i);
		}

		int max = 0, temp = 0;

		if(chargerA.size() > 0 && chargerB.size() > 0) {
			for(int a : chargerA) {
				for(int b : chargerB) {
					temp = 0;
					if(a == b) {
						temp += batteryChargers[a].performance;
					} else {
						temp += batteryChargers[a].performance;
						temp += batteryChargers[b].performance;
					}
					max = max < temp ? temp : max;
				}
			}
		} else if(chargerA.size() > 0) {
			for(int a : chargerA) {
				max = max < batteryChargers[a].performance ? batteryChargers[a].performance : max;
			}
		} else if(chargerB.size() > 0) {
			for(int b : chargerB) {
				max = max < batteryChargers[b].performance ? batteryChargers[b].performance : max;
			}
		}
		res += max;
	}

	static boolean inCoverage(int r, int c, BatteryCharger batteryCharger) {
		return Math.abs(r - batteryCharger.r) + Math.abs(c - batteryCharger.c) <= batteryCharger.coverage;
	}
}

class BatteryCharger {
	int r, c, coverage, performance;

	public BatteryCharger(int r, int c, int coverage, int performance) {
		this.r = r;
		this.c = c;
		this.coverage = coverage;
		this.performance = performance;
	}
}
