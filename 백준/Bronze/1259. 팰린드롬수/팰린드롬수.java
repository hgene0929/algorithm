import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String num;
		while(!(num = br.readLine()).equals("0")) {
			solution(num);
		}
		System.out.println(sb.toString());
	}

	static void solution(String num) {
		int half = num.length();
		boolean isPossible = true;
		for(int i=0; i<half; i++) {
			if(num.charAt(i) != num.charAt(num.length() - 1 - i)) {
				isPossible = false;
				break;
			}
		}
		if(isPossible) sb.append("yes").append("\n");
		else sb.append("no").append("\n");
	}
}