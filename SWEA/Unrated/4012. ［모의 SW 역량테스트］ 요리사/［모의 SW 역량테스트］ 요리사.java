import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static int[][] map;
	static int[] first;
	static int[] second;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// input
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int r=0; r<N; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// solution
			first = new int[N/2];
			second = new int[N/2];
			min = Integer.MAX_VALUE;
			setFirst(0, 0);

			// output
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}

		System.out.println(sb);
	}

	static void setFirst(int cnt, int start) {
		if(cnt == N/2) {
			setSecond();
			getMinSynergy();
			return;
		}
		for(int i=start; i<N; i++) {
			first[cnt] = i;
			setFirst(cnt+1, i+1);
		}
	}

	static void setSecond() {
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<N/2; i++) set.add(first[i]);
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(set.contains(i)) continue;
			second[cnt++] = i;
		}
	}

	static void getMinSynergy() {
		int[] synergies = new int[2];
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				synergies[0] += map[first[i]][first[j]];
				synergies[1] += map[second[i]][second[j]];
			}
		}

		int diff = Math.abs(synergies[0] - synergies[1]);
		min = min > diff ? diff : min;
	}
}
