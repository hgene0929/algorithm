import java.io.*;
import java.util.*;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int m;
	static int[] num;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[m];
		visited = new boolean[n+1];

		// solution
		permutation(0, 1);

		// output
		bw.flush();
		bw.close();
	}

	static void permutation(int cnt, int min) throws Exception {
		if(cnt == m) {
			for(int i=0; i<m; i++) {
				bw.write(num[i]+" ");
			}
			bw.write("\n");
			return;
		}
		for(int i=1; i<=n; i++) {
			if(visited[i] || i < min) {
				continue;
			}
			num[cnt] = i;
			visited[i] = true;
			permutation(cnt+1, i);
			visited[i] = false;
		}
	}
}