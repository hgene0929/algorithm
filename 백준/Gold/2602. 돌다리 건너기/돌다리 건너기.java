import java.util.*;
import java.io.*;

public class Main {
	static String target;
	static String[] strings = new String[2];
	static int N, M;
	static int[][][] memo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		target = br.readLine();
		for (int i = 0; i < 2; i++) {
			strings[i] = br.readLine();
		}

		// solution
		N = strings[0].length();
		M = target.length();
		memo = new int[M+1][3][N+1];

		for (int k = 0; k < M; k++) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					memo[k][i][j] = -1;
				}
			}
		}

		int res = DFS(0, 0, 0) + DFS(0, 1, 0);

		// output
 		System.out.println(res);
	}

	static int DFS(int depth, int i, int j) { // 문자열의 위치, 왼쪽/오른쪽, 문자 인덱스
		if (depth == M) {
			return 1;
		}

		// memoization
		if (memo[depth][i][j] != -1) {
			return memo[depth][i][j];
		}

		int sum = 0;
		int ni = (i + 1) % 2;
		for (int nj = j; nj < N; nj++) {
			if (strings[ni].charAt(nj) == target.charAt(depth)) {
				sum += DFS(depth+1, ni, nj+1);
			}
		}

		return memo[depth][i][j] = sum;
	}
}
