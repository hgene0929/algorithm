import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[] coins;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		coins = new int[N];
		for(int i=N-1; i>=0; i--) coins[i] = Integer.parseInt(br.readLine());

		// solution
		int res = 0;
		for(int i=0; i<N; i++) {
			while(K >= coins[i]) {
				res += K/coins[i];
				K %= coins[i];
			}
		}

		// output
		System.out.println(res);
	}
}
