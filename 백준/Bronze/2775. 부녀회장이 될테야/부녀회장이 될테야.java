import java.io.*;
import java.util.*;

public class Main {
	static int T, k, n;
	static int[][] counts;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// input
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());

			// solution
			counts = new int[k+1][n+1];
			for(int i=1; i<=n; i++) counts[0][i] = i;
			setPeople();

			sb.append(counts[k][n]).append("\n");
		}

		// output
		System.out.println(sb.toString());
	}

	static void setPeople() {
		for(int i=1; i<=k; i++) {
			for(int j=1; j<=n; j++) {
				int sum = 0;
				for(int k=1; k<=j; k++) sum += counts[i-1][k];
				counts[i][j] = sum;
			}
		}
	}
}