import java.io.*;
import java.util.*;

public class Main {
	static int N, L;
	static int[] heights;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		heights = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}

		// solution
		solution();

		// output
		System.out.println(L);
	}

	static void solution() {
		Arrays.sort(heights);
		Queue<Integer> queue = new ArrayDeque<>();
		for(int height : heights) queue.offer(height);

		while(!queue.isEmpty() && L >= queue.peek()) {
			queue.poll();
			L++;
		}
	}
}
