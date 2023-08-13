import java.io.*;
import java.util.*;

public class Main {
	static int N, M, B;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int minTime = Integer.MAX_VALUE;
	static int resHei = 0;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        for(int r=0; r<N; r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c=0; c<M; c++) {
        		map[r][c] = Integer.parseInt(st.nextToken());
        		min = Math.min(min, map[r][c]);
        		max = Math.max(max, map[r][c]);
        	}
        }
        
        // solution
        for(int hei=min; hei<=max; hei++) solution(hei);
        
        // output
        System.out.println(minTime+" "+resHei);
    }
    
    static void solution(int hei) {
    	int cnt = 0; int inventory = B;
    	for(int r=0; r<N; r++) {
    		for(int c=0; c<M; c++){
    			int diff = Math.abs(map[r][c] - hei);
    			if(map[r][c] < hei) {
    				inventory -= diff; cnt += diff;
    			} else {
    				inventory += diff; cnt += 2*diff;
    			}
    		}
    	}
    	if(inventory < 0) return;
    	if(minTime >= cnt) {
    		minTime = cnt;
    		resHei = hei;
    	}
    }
}