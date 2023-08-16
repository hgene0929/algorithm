import java.io.*;
import java.util.*;

public class Main {
	static int N, destRow, destCol;
	static int order = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		destRow = Integer.parseInt(st.nextToken());
		destCol = Integer.parseInt(st.nextToken());

		// solution
		int size = (int) Math.pow(2, N);
		count(0, 0, size);

		// output
		System.out.println(order);
	}

	static void count(int sr, int sc, int size) {
		if(size == 1) return;

		int newSize = size/2;
		if(destRow < sr+newSize && destCol < sc+newSize) {
			order += ((size * size) / 4) * 0;
			count(sr, sc, newSize);
		}
		else if(destRow < sr+newSize && destCol >= sc+newSize) {
			order += ((size * size) / 4) * 1;
			count(sr, sc+newSize, newSize);
		}
		else if(destRow >= sr+newSize && destCol < sc+newSize) {
			order += ((size * size) / 4) * 2;
			count(sr+newSize, sc, newSize);
		}
		else {
			order += ((size * size) / 4) * 3;
			count(sr+newSize, sc+newSize, newSize);
		}
	}
}