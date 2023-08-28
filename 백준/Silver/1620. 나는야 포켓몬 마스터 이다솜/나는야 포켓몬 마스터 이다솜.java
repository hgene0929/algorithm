import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static Map<String, Integer> strToIdx = new HashMap<>();
	static String[] idxToStr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// input
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		idxToStr = new String[N+1];
		for(int i=1; i<=N; i++) {
			String input = br.readLine();
			strToIdx.put(input, i);
			idxToStr[i] = input;
		}

		// solution
		for(int i=0; i<M; i++) {
			String input = br.readLine();
			if(isNumeric(input)) {
				sb.append(idxToStr[Integer.parseInt(input)]).append("\n");
			} else {
				sb.append(strToIdx.get(input)).append("\n");
			}
		}

		// output
		System.out.println(sb.toString());
	}

	static boolean isNumeric(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
