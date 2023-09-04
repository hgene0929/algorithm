import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] lectures;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lectures = new int[N];
		int sum = 0, max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			lectures[i] = Integer.parseInt(st.nextToken());
			sum += lectures[i];
			max = max < lectures[i] ? lectures[i] : max;
		}

		// solution
		int res = binarySearch(max, sum, M);

		// output
		System.out.println(res);
	}

	static int binarySearch(int start, int end, int target) {
		int res = 0;
		while(start <= end) {
			int mid = (start+end)/2;
			int sum = 0, cnt = 1;
			for(int i=0; i<N; i++) { //처음부터 강의크기를 더해보고 -> 크기를 넘으면 새로운 블루레이로 갱신
				if(sum + lectures[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += lectures[i];
			}
			if(cnt <= target) { //블루레이 개수가 모자람(M보다 작거나 같음) -> 블루레이 크기 줄여도 됨
				end = mid - 1;
				res = mid;
			} else { //블루레이 개수가 넘침(M보다 큼) -> 블루레이 크기 키워야 됨
				start = mid + 1;
			}
		}
		return res;
	}
}