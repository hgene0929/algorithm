import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int r=0; r<N; r++) {
			String input = br.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = input.charAt(c) - '0';
			}
		}

		// solution
		solution(0, 0, N);

		// output
		System.out.println(sb.toString());
	}

	static void solution(int sr, int sc, int size) {
		if(isEquals(sr, sc, size)) {
			sb.append(map[sr][sc]);
			return;
		}
		sb.append("(");
		solution(sr, sc, size/2);
		solution(sr, sc+size/2, size/2);
		solution(sr+size/2, sc, size/2);
		solution(sr+size/2, sc+size/2, size/2);
		sb.append(")");
	}

	static boolean isEquals(int sr, int sc, int size) {
		for(int r=sr; r<sr+size; r++) {
			for(int c=sc; c<sc+size; c++) {
				if(map[r][c] != map[sr][sc]) return false;
			}
		}
		return true;
	}
}