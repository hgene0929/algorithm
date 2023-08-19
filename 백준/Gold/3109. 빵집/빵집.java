import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static char[][] map;
	static int[][] directions = { {-1,1},{1,1},{0,1} };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for(int r=0; r<R; r++) {
			String input = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = input.charAt(c);
			}
		}

		// solution
		int cnt = 0;
		for(int r=0; r<R; r++) {
			if(check(r, 0)) cnt++;
		}

		// output
		System.out.println(cnt);
	}

	static boolean check(int r, int c) {
		map[r][c] = 'X';
		if(c == C-1) return true;

		if(r-1 >= 0 && map[r-1][c+1] == '.' && check(r-1, c+1)) return true;
		if(map[r][c+1] == '.' && check(r, c+1)) return true;
		if(r+1 < R && map[r+1][c+1] == '.' && check(r+1, c+1)) return true;
		return false;
	}
}
