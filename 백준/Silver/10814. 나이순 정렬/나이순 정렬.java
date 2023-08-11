import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Member> queue = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			queue.offer(new Member(
				Integer.parseInt(st.nextToken()),
				st.nextToken(),
				i+1
			));
		}

		// solution
		while(!queue.isEmpty()) {
			Member member = queue.poll();
			sb.append(member.age).append(" ").append(member.name).append("\n");
		}

		// output
		System.out.println(sb.toString());
	}
}

class Member implements Comparable<Member> {
	int age;
	String name;
	int order;

	public Member(int age, String name, int order) {
		this.age = age;
		this.name = name;
		this.order = order;
	}

	@Override
	public int compareTo(Member member) {
		if(this.age == member.age) return this.order - member.order;
		return this.age - member.age;
	}
}