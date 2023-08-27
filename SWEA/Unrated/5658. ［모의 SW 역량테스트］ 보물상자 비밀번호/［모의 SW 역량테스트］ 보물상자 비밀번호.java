import java.io.*;
import java.util.*;

public class Solution {
	static int N, K, len;
	static String[] numbers;
	static Set<String> set;
	static int res;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// input
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			numbers = new String[N];
			len = N/4;
			String input = br.readLine();
			for(int i=0; i<N; i++) numbers[i] = String.valueOf(input.charAt(i));

			// solution
			set = new HashSet<>();
			for(int i=0; i<len; i++) {
				getPasswords();
				rotate();
			}
			res = getRes();

			// output
			sb.append("#").append(t).append(" ").append(res).append("\n");
		}

		System.out.println(sb);
	}

	static void rotate() {
		String[] newNumbers = new String[N];
		for(int i=0; i<N; i++) newNumbers[(i+1) % N] = numbers[i];
		numbers = newNumbers;
	}

	static void getPasswords() {
		for(int i=0; i<N; i+=len) {
			String temp = "";
			for(int j=i; j<i+len; j++) {
				temp += numbers[j];
			}
			set.add(temp);
		}
	}

	static int getRes() {
		List<Integer> nums = new ArrayList<>();
		for(String password : set) {
			nums.add(Integer.parseInt(password, 16));
		}
		nums.sort(Comparator.reverseOrder());
		return nums.get(K-1);
	}
}
