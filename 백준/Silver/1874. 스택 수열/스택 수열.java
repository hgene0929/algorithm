import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static boolean possible = true;
    static Stack<Integer> stack = new Stack<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // input
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(br.readLine());
        
        // solution
        int pushNum = 1;
        for(int num : nums) {
            while(num >= pushNum) {
                stack.push(pushNum++);
                sb.append("+").append("\n");
            }
            if(!check(num)) {
                possible = false;
                break;
            } 
            else {
            	stack.pop();
            	sb.append("-").append("\n");
            }
        }
        
        // output
        if(possible) System.out.println(sb.toString());
        else System.out.println("NO");
    }
    
    static boolean check(int num) {
        if(stack.peek() > num) return false;
        return true;
    }
}
