import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

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
		devideConquer(0, 0, N);

		// output
		sb.append(white).append("\n").append(blue);
		System.out.println(sb.toString());
	}

	static boolean check(int sr, int sc, int size) {
		for(int r=sr; r<sr+size; r++) {
			for(int c=sc; c<sc+size; c++) {
				if(map[r][c] != map[sr][sc]) return false;
			}
		}
		return true;
	}

	static void devideConquer(int sr, int sc, int size) {
		if(check(sr, sc, size)) {
			if(map[sr][sc] == 0) white += 1;
			else blue += 1;
			return;
		}
		devideConquer(sr, sc, size/2);
		devideConquer(sr+size/2, sc, size/2);
		devideConquer(sr, sc+size/2, size/2);
		devideConquer(sr+size/2, sc+size/2, size/2);
	}
}