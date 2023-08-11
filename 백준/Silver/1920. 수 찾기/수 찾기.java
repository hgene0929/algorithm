import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] standards, compares;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // input
        N = Integer.parseInt(br.readLine());
        standards = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            standards[i] = Long.parseLong(st.nextToken());
        }
        
        M = Integer.parseInt(br.readLine());
        compares = new long[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            compares[i] = Long.parseLong(st.nextToken());
        }
        
        // solution
        Arrays.sort(standards);
        
        for(int i=0; i<M; i++) {
            int exists = binarySearch(0, N-1, compares[i]);
            sb.append(exists).append("\n");
        }
        
        // output
        System.out.println(sb.toString());
    }
    
    static int binarySearch(int start, int end, long target) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if(standards[mid] > target) end = mid - 1;
            else if(standards[mid] < target) start = mid + 1;
            else return 1;
        }
        return 0;
    }
}