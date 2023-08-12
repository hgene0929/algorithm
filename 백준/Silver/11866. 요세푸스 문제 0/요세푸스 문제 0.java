import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static Queue<Integer> nums = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=1; i<=N; i++) nums.offer(i);
        
        // solution
        sb.append("<");
        solution();
        sb.append(">");
        
        // output
        System.out.println(sb.toString());
    }
    
    static void solution() {
        while(nums.size() > 1) {
            for(int j=0; j<K-1; j++) {
                int num = nums.poll();
                nums.offer(num);
            }
            sb.append(nums.poll()).append(", ");
        }
        sb.append(nums.poll());
    }
}