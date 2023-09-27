import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int n=1; n<=N; n++) {
			// input
			int x = Integer.parseInt(br.readLine());

			// solution
			if(x == 0) { // 최솟값을 출력하고 제거
				if(queue.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
			} else { // 큐에 값을 저장
				queue.offer(x);
			}
		}

		System.out.println(sb.toString());
	}
}