import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int total = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// solution
		combinations(0, 0);

		// output
		System.out.println(total);
	}

	static void combinations(int cnt, int start) {
		if(cnt == K) {
			total++;
			return;
		}
		for(int i=start; i<N; i++) combinations(cnt+1, i+1);
	}
}