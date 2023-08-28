import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static Set<String> people = new HashSet<>();
	static PriorityQueue<String> queue = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i=0; i<N; i++) people.add(br.readLine());

		// solution
		for(int i=0; i<M; i++) {
			String person = br.readLine();
			if(people.contains(person)) queue.offer(person);
		}
		
		sb.append(queue.size()).append("\n");
		while(!queue.isEmpty()) sb.append(queue.poll()).append("\n");

		// output
		System.out.println(sb.toString());
	}
}
