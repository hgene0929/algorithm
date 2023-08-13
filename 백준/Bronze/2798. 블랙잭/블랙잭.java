import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] cards, nums;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) cards[i] = Integer.parseInt(st.nextToken());

		// solution
		nums = new int[3];
		combinations(0, 0);

		// output
		System.out.println(max);
	}

	static void combinations(int cnt, int start) {
		if(cnt == 3) {
			int sum = 0;
			for(int i=0; i<3; i++) sum += nums[i];
			if(sum <= M) max = Math.max(max, sum);
			return;
		}
		for(int i=start; i<N; i++) {
			nums[cnt] = cards[i];
			combinations(cnt+1, i+1);
		}
	}
}