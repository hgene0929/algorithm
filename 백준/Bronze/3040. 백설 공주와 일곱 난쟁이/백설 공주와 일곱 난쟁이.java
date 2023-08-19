import java.io.*;
import java.util.*;

public class Main {
	static int[] inputs = new int[9];
	static int[] numbers = new int[7];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		for(int i=0; i<9; i++) inputs[i] = Integer.parseInt(br.readLine());

		// solution
		combinations(0, 0);

		// output
		System.out.println(sb.toString());
	}

	static void combinations(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int number : numbers) sum += number;
			if(sum == 100) {
				for(int number : numbers) sb.append(number).append("\n");
			}
			return;
		}
		for(int i=start; i<9; i++) {
			numbers[cnt] = inputs[i];
			combinations(cnt+1, i+1);
		}
	}
}