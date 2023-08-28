import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static Map<String, String> map = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map.put(st.nextToken(), st.nextToken());
		}

		// solution
		for(int i=0; i<M; i++) {
			sb.append(map.get(br.readLine())).append("\n");
		}

		// output
		System.out.println(sb.toString());
	}
}
