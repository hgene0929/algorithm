import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        
		StringTokenizer st;
		for(int test_case = 1; test_case <= 10; test_case++)
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
				map[map.length-1]--;
				map[0]++;
			}
            Arrays.sort(map);
			// output
			bw.write("#"+test_case+" "+(map[map.length-1]-map[0])+"\n");
		}
        bw.flush();
		bw.close();
	}
}