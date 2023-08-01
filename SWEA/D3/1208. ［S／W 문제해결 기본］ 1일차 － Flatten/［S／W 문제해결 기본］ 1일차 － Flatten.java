import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		for(int t = 1; t <= 10; t++)
		{
			// input
			int n = Integer.parseInt(br.readLine());
			int[] map = new int[100];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<100; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			// solution
			for(int i=0; i<n; i++) {
	                Arrays.sort(map);
	                if((map[map.length-1]-map[0]) <= 1) { // SWEA에는 없는 반례
	                	break;
	                }
			map[map.length-1]--;
			map[0]++;
			}
            		Arrays.sort(map);
			// output
			bw.write("#"+t+" "+(map[map.length-1]-map[0])+"\n");
		}
		bw.flush();
		bw.close();
	}
}
