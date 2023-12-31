import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		String str = br.readLine();
		String bomb = br.readLine();

		// solution
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));

			if (stack.size() >= bomb.length()) {
				boolean possible = true;
				int k = stack.size() - bomb.length();
				for (int j = 0; j < bomb.length(); j++) {
					if (stack.get(k + j) != bomb.charAt(j)) {
						possible = false;
						break;
					}
				}
				
				if (possible) {
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}

		// output
		StringBuilder sb = new StringBuilder();
		for (char res : stack) sb.append(res);
		System.out.println(stack.isEmpty() ? "FRULA" : sb);
	}
}
