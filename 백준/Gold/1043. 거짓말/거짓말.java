import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] truth, parents;
	static boolean[] knows;
	static int[][] participants;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		// truth = new int[Integer.parseInt(st.nextToken())];
		knows = new boolean[N+1];
		int cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			int know = Integer.parseInt(st.nextToken());
			knows[know] = true;
		}

		participants = new int[M][];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cnt = Integer.parseInt(st.nextToken());
			participants[i] = new int[cnt];
			for (int j = 0; j < cnt; j++) {
				participants[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// solution
		parents = new int[N+1];
		for (int i = 1; i <=N; i++) parents[i] = i;

		for (int i = 0; i < M; i++) {
			int std = participants[i][0];
			for (int j = 0; j < participants[i].length; j++) {
				union(std, participants[i][j]);
			}
		}

		int res = 0;
		for (int i = 0; i < M; i++) {
			boolean mustBeTrue = false;
			for (int j = 0; j < participants[i].length; j++) {
				if (knows[find(participants[i][j])]) {
					mustBeTrue = true;
				}
			}
			if (!mustBeTrue) res++;
		}

		// output
		System.out.println(res);
	}

	static int find(int x) {
		if (parents[x] == x) return x;
		return find(parents[x]);
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y) return false;

		if (knows[x]) parents[y] = x;
		else if (knows[y]) parents[x] = y;
		else parents[y] = x;
		return true;
	}
}
