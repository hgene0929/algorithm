import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<List<Node>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<>());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(new Node(b, 1));
			graph.get(b).add(new Node(a, 1));
		}
		
		// solution
		boolean isSmall = true;
		for(int from=1; from<=N; from++) {
			for(int to=1; to<=N; to++) {
				if(from == to) continue;
				if(!dijkstra(from, to, graph)) isSmall = false;
			}
		}
		
		// output
		if(isSmall) System.out.println("Small World!");
		else System.out.println("Big World!");
	}
	
	static boolean dijkstra(int from, int to, List<List<Node>> graph) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int[] distance = new int[graph.size()];
		Arrays.fill(distance, Integer.MAX_VALUE);
		queue.offer(new Node(from, 0));
		distance[from] = 0;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(distance[now.idx] < now.wei) continue;
			for(Node next : graph.get(now.idx)) {
				if(distance[next.idx] > distance[now.idx]+next.wei) {
					distance[next.idx] = distance[now.idx]+next.wei;
					queue.offer(new Node(next.idx, distance[next.idx]));
				}
			}
		}
		
		for(int i=1; i<distance.length; i++) {
			if(distance[i] > 6) return false;
		}
		return true;
	}
}

class Node implements Comparable<Node> {
	int idx, wei;
	
	public Node(int idx, int wei) {
		this.idx = idx;
		this.wei = wei;
	}
	
	@Override
	public int compareTo(Node node) {
		return this.wei - node.wei;
	}
}
