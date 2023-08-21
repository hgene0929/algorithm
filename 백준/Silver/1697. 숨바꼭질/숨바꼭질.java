import java.io.*;
import java.util.*;

public class Main {
	static int minCnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// solution
		solution(N, K);
		
		// output
		System.out.println(minCnt);
	}

	static void solution(int N, int K) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		queue.offer(new int[] { N,0 });
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(now[0] == K) {
				minCnt = minCnt > now[1] ? now[1] : minCnt;
			}
			
			// X + 1
			int next = now[0] + 1;
			if(next >= 0 && next <= 100000 && !visited[next]) {
				queue.offer(new int[] { next,now[1]+1 });
				visited[next] = true;
			}
			
			// X - 1
			next = now[0] - 1;
			if(next >= 0 && next <= 100000 && !visited[next]) {
				queue.offer(new int[] { next,now[1]+1 });
				visited[next] = true;
			}
			
			// X * 2
			next = now[0] * 2;
			if(next >= 0 && next <= 100000 && !visited[next]) {
				queue.offer(new int[] { next,now[1]+1 });
				visited[next] = true;
			}
		}
	}
}
