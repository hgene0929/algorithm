import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] people;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		N = Integer.parseInt(br.readLine());
		people = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int wei = Integer.parseInt(st.nextToken());
			int hei = Integer.parseInt(st.nextToken());
			people[i][0] = wei; people[i][1] = hei;
		}

		// solution
		compare();

		// output
		System.out.println(sb.toString());
	}

	static void compare() {
		for(int i=0; i<N; i++) {
			int index = 1;
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) index++;
			}
			sb.append(index).append(" ");
		}
	}
}