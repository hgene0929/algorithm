import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
		
		int[] indegree = new int[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph.get(from).add(to);
			indegree[to]++;
		}
		
		// solution
		Queue<int[]> queue = new ArrayDeque<>();
		int[] results = new int[N+1];
		
		for(int i=1; i<indegree.length; i++) {
			if(indegree[i] == 0) queue.offer(new int[] { i,1 });
		}
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			results[now[0]] = now[1];
			
			for(int next : graph.get(now[0])) {
				indegree[next]--;
				if(indegree[next] == 0) queue.offer(new int[] { next,now[1]+1 });
			}
		}
		
		// output
		for(int i=1; i<results.length; i++) sb.append(results[i]).append(" ");
		System.out.println(sb.toString());
	}

}
