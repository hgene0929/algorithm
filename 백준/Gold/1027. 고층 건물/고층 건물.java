import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] hei;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		hei = new int[N];
		for (int i = 0; i < N; i++) hei[i] = Integer.parseInt(st.nextToken());

		// solution
		int res = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			double gradient = Integer.MIN_VALUE;
			for (int j = i-1; j >= 0; j--) {
				double temp = (double)(hei[j] - hei[i]) / (i - j);
				if (temp > gradient) {
					cnt++;
					gradient = temp;
				}
			}
			gradient = Integer.MIN_VALUE;
			for (int j = i+1; j < N; j++) {
				double temp = (double)(hei[j] - hei[i]) / (j - i);
				if (temp > gradient) {
					cnt++;
					gradient = temp;
				}
			}
			res = Math.max(res, cnt);
		}

		// output
		System.out.println(res);
	}
}
