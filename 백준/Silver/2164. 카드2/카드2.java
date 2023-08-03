import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		// input
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			q.add(i);
		}

		// solution
		while(q.size() != 1) {
			q.poll();
			q.add(q.poll());
		}

		// output
		bw.write(q.poll()+"");
		bw.flush();
		bw.close();
	}
}