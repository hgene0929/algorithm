import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] time;
	static int res = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());
		time = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) time[i] = Integer.parseInt(st.nextToken());

		// solution
		Arrays.sort(time);
		count();

		// output
		System.out.println(res);
	}

	static void count() {
		int[] cnt = new int[N];
		cnt[0] = time[0];
		for(int i=1; i<N; i++) cnt[i] = cnt[i-1] + time[i];

		int sum = 0;
		for(int i=0; i<N; i++) sum += cnt[i];
		res = res > sum ? sum : res;
	}
}
