import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static PriorityQueue<Point> queue = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			queue.offer(new Point(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
			));
		}

		// solution
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			sb.append(point.x).append(" ").append(point.y).append("\n");
		}

		// output
		System.out.println(sb.toString());
	}
}

class Point implements Comparable<Point> {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point point) {
		if(this.y == point.y) return this.x - point.x;
		return this.y - point.y;
	}
}