import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[10001];

		for(int i=0; i<N; i++) {
			nums[Integer.parseInt(br.readLine())]++;
		}

		// solution
		for(int i=0; i<10001; i++) {
			while(nums[i] > 0) {
				sb.append(i).append("\n");
				nums[i]--;
			}
		}

		// output
		System.out.println(sb.toString());
	}
}