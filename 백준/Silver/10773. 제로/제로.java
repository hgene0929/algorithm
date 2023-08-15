import java.io.*;
import java.util.*;

public class Main {
	static int K;
	static Stack<Integer> stack = new Stack<>();
	static int sum = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) push(Integer.parseInt(br.readLine()));

		// solution
		add();

		// output
		System.out.println(sum);
	}

	static void push(int num) {
		if(num != 0) stack.push(num);
		else stack.pop();
	}

	static void add() {
		while(!stack.isEmpty()) sum += stack.pop();
	}
}