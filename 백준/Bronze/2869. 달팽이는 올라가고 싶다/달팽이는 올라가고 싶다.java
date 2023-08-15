import java.io.*;
import java.util.*;

public class Main {
	static int A, B, V;
	static int cnt = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		// solution
		solution();

		// output
		System.out.println(cnt);
	}

	static void solution() {
		cnt += (V - A) / (A - B);
		V -= A; V %= (A - B);
		if(V != 0) cnt += 1;
	}
}