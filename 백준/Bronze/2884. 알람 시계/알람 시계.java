import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        
        // 풀이
        if(min >= 45) {
			min -= 45;
			bw.write(hour+" "+min);
		} else {
			int diff = 45 - min;
			min = 60 - diff;
			hour -= 1;
			if(hour < 0) {
				hour = 23;
			}
			bw.write(hour+" "+min);
		}
        
        // 출력
        bw.flush();
        bw.close();
    }
}