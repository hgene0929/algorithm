import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N+1];
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int before = Integer.parseInt(st.nextToken());
			int after = Integer.parseInt(st.nextToken());
			graph.get(before).add(after);
			indegree[after]++;
		}
		
		// solution
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<indegree.length; i++) {
			if(indegree[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			
			for(int next : graph.get(now)) {
				indegree[next]--;
				if(indegree[next] == 0) queue.offer(next);
			}
		}
		
		// output
		System.out.println(sb.toString());
	}
}