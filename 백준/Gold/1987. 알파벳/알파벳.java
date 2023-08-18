import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static int[][] map;
    static boolean[] visited = new boolean[26];
    static int[][] directions = { {-1,0},{1,0},{0,-1},{0,1} };
    static int maxCnt = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        for(int r=0; r<R; r++) {
            String input = br.readLine();
            for(int c=0; c<C; c++) {
                map[r][c] = input.charAt(c) - 'A';
            }
        }
        
        // solution
        dfs(0, 0, 0);
        
        // output
        System.out.println(maxCnt);
    }
    
    static void dfs(int r, int c, int cnt) {
        if(visited[map[r][c]]) {
            maxCnt = maxCnt < cnt ? cnt : maxCnt;
            return;
        }
        visited[map[r][c]] = true;
        for(int d=0; d<4; d++) {
            int nr = r + directions[d][0];
            int nc = c + directions[d][1];
            if(!(nr>=0 && nr<R && nc>=0 && nc<C)) continue;
            dfs(nr, nc, cnt+1);
        }
        visited[map[r][c]] = false;
    }
}