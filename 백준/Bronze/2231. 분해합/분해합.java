import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());

		// solution
		for(int num=1; num<N; num++) {
			solution(String.valueOf(num));
		}

		// output
		if(min == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(min);
	}

	static void solution(String numStr) {
		int sum = Integer.parseInt(numStr);
		for(int i=0; i<numStr.length(); i++) sum += Integer.parseInt(String.valueOf(numStr.charAt(i)));
		if(sum == N) min = Math.min(min, Integer.parseInt(numStr));
	}
}