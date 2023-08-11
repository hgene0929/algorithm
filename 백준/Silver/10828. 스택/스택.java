import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Stack<Integer> stack = new Stack<>();
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
				default: top(); break;
			}
		}

		// output
		System.out.println(sb.toString());
	}

	static void push(int x) {
		stack.push(x);
	}

	static void pop() {
		if(stack.isEmpty()) sb.append(-1).append("\n");
		else sb.append(stack.pop()).append("\n");
	}

	static void size() {
		sb.append(stack.size()).append("\n");
	}

	static void empty() {
		if(stack.isEmpty()) sb.append(1).append("\n");
		else sb.append(0).append("\n");
	}

	static void top() {
		if(stack.isEmpty()) sb.append(-1).append("\n");
		else sb.append(stack.peek()).append("\n");
	}
}