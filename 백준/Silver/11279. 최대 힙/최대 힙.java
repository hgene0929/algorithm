import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		N = Integer.parseInt(br.readLine());

		// solution
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(queue.isEmpty()) sb.append(0).append("\n");
				else sb.append(queue.poll()).append("\n");
			} else {
				queue.offer(input);
			}
		}

		// output
		System.out.println(sb.toString());
	}
}
