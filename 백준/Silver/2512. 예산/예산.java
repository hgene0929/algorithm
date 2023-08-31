import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] budgets;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());
		budgets = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			budgets[i] = Integer.parseInt(st.nextToken());
			max = max < budgets[i] ? budgets[i] : max;
		}
		M = Integer.parseInt(br.readLine());

		// solution
		int res = binarySearch(0, max, M);

		// output
		System.out.println(res);
	}

	static int binarySearch(int start, int end, int limit) {
		int res = 0;
		while(start <= end) {
			int mid = (start+end)/2;
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(budgets[i] <= mid) sum += budgets[i];
				else sum += mid;
			}
			if(sum <= limit) {
				start = mid+1;
				res = mid;
			} else {
				end = mid-1;
			}
		}
		return res;
	}
}
