import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		System.out.println(solution(N));
	}

	static int solution(int N) {
		int cnt = 0;
		while(N >= 5) {
			cnt += N/5;
			N /= 5;
		}
		return cnt;
	}
}