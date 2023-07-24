import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int[][] rooms = new int[h][w];
			int roomNum = 100;
			for(int r=h-1; r>=0; r--) {
				for(int c=0; c<w; c++) {
					roomNum++;
					rooms[r][c] = roomNum;
				}
				roomNum -= w;
				roomNum += 100;
			}

			int result = 0;
			for(int c=0; c<w; c++) {
				for(int r=h-1; r>=0; r--) {
					if(n == 0) {
						break;
					}
					result = rooms[r][c];
					n--;
				}
			}

			bw.write(result+"\n");
		}

		bw.flush();
		bw.close();
    }
}