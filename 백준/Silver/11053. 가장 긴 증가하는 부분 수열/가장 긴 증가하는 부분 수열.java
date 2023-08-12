import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums, dp;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // input
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());
        
        // solution
        dp = new int[N];
        lis(); // 최장 길이 증가 수열
        
        // output
        System.out.println(max);
    }
    
    static void lis() {
        for(int i=0; i<N; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            max = Math.max(max, dp[i]);
        }
    }
}