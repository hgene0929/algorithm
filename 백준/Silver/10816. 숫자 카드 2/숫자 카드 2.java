import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] nNums, mNums;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		N = Integer.parseInt(br.readLine());
		nNums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) nNums[i] = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());
		mNums = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) mNums[i] = Integer.parseInt(st.nextToken());

		// solution
		Arrays.sort(nNums);
		for(int mNum : mNums) {
			int upper = upperBound(0, N, mNum);
			int lower = lowerBound(0, N, mNum);
			sb.append(upper - lower).append(" ");
		}

		// output
		System.out.println(sb.toString());
	}

	static int upperBound(int start, int end, int target) {
		while(start < end) {
			int mid = (start + end) / 2;
			if(nNums[mid] > target) {
				end = mid;
			}
			else start = mid + 1;
		}
		return start;
	}

	static int lowerBound(int start, int end, int target) {
		while(start < end) {
			int mid = (start + end) / 2;
			if(nNums[mid] >= target) {
				end = mid;
			}
			else start = mid + 1;
		}
		return start;
	}
}