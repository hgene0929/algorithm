import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static char[] inputs, temps;
	static boolean[] selected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		inputs = new char[C];
		selected = new boolean[C];
		temps = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			inputs[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(inputs);
		
		// solution
		combinations(0, 0);
		
		// output
		System.out.println(sb.toString());
	}
	
	static void combinations(int cnt, int start) {
		if(cnt == L) {
			if(possible(temps)) {
				for(int i=0; i<L; i++) sb.append(temps[i]);
				sb.append("\n");
			}
			return;
		}
		for(int i=start; i<C; i++) {
			temps[cnt] = inputs[i];
			combinations(cnt+1, i+1);
		}
	}
	
	static boolean possible(char[] temps) {
		int cntVow = 0;
		int cntCon = 0;
		for(char temp : temps) {
			if(temp == 'a') cntVow++;
			else if(temp == 'e') cntVow++;
			else if(temp == 'i') cntVow++;
			else if(temp == 'o') cntVow++;
			else if(temp == 'u') cntVow++;
			else cntCon++;
		}
		if(cntVow >= 1 && cntCon >= 2) return true; 
		else return false;
	}
}
