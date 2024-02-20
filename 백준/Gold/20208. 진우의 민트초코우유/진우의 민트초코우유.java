import java.util.*;
import java.io.*;

public class Main {
	static class Pos {
		int r, c;
		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M, H;
	static Pos home;
	static List<Pos> milks = new ArrayList<>();
	static boolean[] visited;
	static int res = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// input
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int in = Integer.parseInt(st.nextToken());
				if (in == 1) home = new Pos(i, j);
				if (in == 2) milks.add(new Pos(i, j));
			}
		}

		// solution
		visited = new boolean[milks.size()];

		for (int i = 0; i < milks.size(); i++) {
			Pos milk = milks.get(i);
			int dist = Math.abs(milk.r - home.r) + Math.abs(milk.c - home.c);
			if (M >= dist) {
				visited[i] = true;
				solution(milk.r, milk.c, 1, M - dist + H);
				visited[i] = false;
			}
		}

		// output
		System.out.println(res);
	}

	static void solution(int r, int c, int cnt, int hp) {
		for (int i = 0; i < milks.size(); i++) {
			Pos milk = milks.get(i);
			if (visited[i]) continue;
			int distFromMilk = Math.abs(milk.r - r) + Math.abs(milk.c - c);
			if (hp >= distFromMilk) {
				visited[i] = true;
				solution(milk.r, milk.c, cnt + 1, hp - distFromMilk + H);
				visited[i] = false;
			}
		}

		int distFromHome = Math.abs(r - home.r) + Math.abs(c - home.c);
		if (hp >= distFromHome) {
			res = Math.max(res, cnt);
		}
	}
}
