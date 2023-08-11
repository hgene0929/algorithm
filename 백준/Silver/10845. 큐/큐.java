import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Deque<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());

		// solution
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
				case "push": push(Integer.parseInt(st.nextToken())); break;
				case "pop": pop(); break;
				case "size": size(); break;
				case "empty": empty(); break;
				case "front": front(); break;
				default: back(); break;
			}
		}

		// output
		System.out.println(sb.toString());
	}

	static void push(int x) {
		queue.offer(x);
	}

	static void pop() {
		if(queue.isEmpty()) sb.append(-1).append("\n");
		else sb.append(queue.poll()).append("\n");
	}

	static void size() {
		sb.append(queue.size()).append("\n");
	}

	static void empty() {
		if(queue.isEmpty()) sb.append(1).append("\n");
		else sb.append(0).append("\n");
	}

	static void front() {
		if(queue.isEmpty()) sb.append(-1).append("\n");
		else sb.append(queue.peek()).append("\n");
	}

	static void back() {
		if(queue.isEmpty()) sb.append(-1).append("\n");
		else sb.append(queue.peekLast()).append("\n");
	}
}