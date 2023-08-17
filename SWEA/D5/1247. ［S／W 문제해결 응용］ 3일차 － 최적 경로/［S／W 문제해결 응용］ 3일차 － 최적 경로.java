import java.io.*;
import java.util.*;

public class Solution {
	static int T, N;
	static Position company, home;
	static Position[] customers;
	static int[] orders;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
            min = Integer.MAX_VALUE;
			// input
			N = Integer.parseInt(br.readLine());
			customers = new Position[N];
			orders = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			company = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i=0; i<N; i++) customers[i] = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			// solution
			for(int i=0; i<N; i++) orders[i] = i; // 다음순열을 위한 초깃값
			do {
				getDistance();
			} while(nextPermutation(orders));
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}

		// output
		System.out.println(sb.toString());
	}

	static boolean nextPermutation(int[] numbers) {
		int i = numbers.length - 1;
		while(i > 0 && numbers[i-1] >= numbers[i]) i--;

		if(i == 0) return false;

		int j = numbers.length - 1;
		while(numbers[i-1] >= numbers[j]) j--;

		swap(numbers, i-1, j);

		int k = numbers.length - 1;
		while(i < k) swap(numbers, i++, k--);

		return true;
	}

	static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	static void getDistance() {
		int sum = 0;
		sum += calcSum(company, customers[orders[0]]);
		for(int i=0; i<N-1; i++) sum += calcSum(customers[orders[i]], customers[orders[i+1]]);
		sum += calcSum(customers[orders[N-1]], home);
		min = min > sum ? sum : min;
	}

	static int calcSum(Position start, Position dest) {
		return Math.abs(start.r - dest.r) + Math.abs(start.c - dest.c);
	}
}

class Position {
	int r, c;

	public Position(int r, int c) {
		this.r = r;
		this.c = c;
	}
}