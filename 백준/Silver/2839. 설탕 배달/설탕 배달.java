import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int cnt = Integer.MAX_VALUE;
	static boolean possible = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());

		// solution
		solution();

		// output
		if(!possible) System.out.println(-1);
		else System.out.println(cnt);
	}

	static void solution() {
		if(N % 5 == 0) {
			cnt = Math.min(cnt, N/5);
			possible = true;
		}
		if(N % 3 == 0) {
			cnt = Math.min(cnt, N/3);
			possible = true;
		}
		devide();
	}

	static void devide() {
		for(int i=1; i*3<=N; i++) {
			int temp = N;
			temp -= 3*i;
			if(temp % 5 == 0) {
				cnt = Math.min(cnt, temp/5+i);
				possible = true;
			}
		}
	}
}