import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static boolean[] prime;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // input
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        // solution
        prime = new boolean[N+1];
        prime[0] = prime[1] = true; // true : 소수 x, false : 소수 o
        check();
        for(int i=M; i<=N; i++) {
            if(!prime[i]) sb.append(i).append("\n");
        }
        
        // output
        System.out.println(sb.toString());
    }
    
    static void check() { // 에라토스테네스의 체
        for(int i=2; i*i<=N; i++) {
            if(prime[i]) continue;
            for(int j=i*i; j<=N; j+=i) prime[j] = true;
        }
    }
}