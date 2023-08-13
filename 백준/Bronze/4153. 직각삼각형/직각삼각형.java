import java.io.*;
import java.util.*;

public class Main {
	static int a, b, c;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			// input
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			// solution
			if(a == 0 && b == 0 && c == 0) break;
			
			int[] nums = {a, b, c};
			Arrays.sort(nums);

			if(isTrue(nums)) sb.append("right").append("\n");
			else sb.append("wrong").append("\n");

		}

		// output
		System.out.println(sb.toString());
	}

	static boolean isTrue(int[] nums) {
		return (nums[0]*nums[0]) + (nums[1]*nums[1]) == (nums[2]*nums[2]);
	}
}