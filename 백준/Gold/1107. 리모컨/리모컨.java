import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean[] broken = new boolean[10]; // 0-9

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				int button = Integer.parseInt(st.nextToken());
				broken[button] = true;
			}
		}

		// solution
		int withoutNums = Math.abs(N - 100);
		int res = withoutNums;

		if (M == 10) {
			System.out.println(res);
			return;
		}

		for (int i = 0; i < 1000000; i++) {
			String channel = String.valueOf(i);
			boolean hasBroken = false;

			for (int j = 0; j < channel.length(); j++) {
				if (broken[channel.charAt(j) - '0']) {
					hasBroken = true;
					break;
				}
			}

			if (!hasBroken) {
				int withNums = Math.abs(N - i) + channel.length();
				res = Math.min(res, withNums);
			}
		}

		// output
		System.out.println(res);
	}
}
