import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // input
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        
        // solution
        Arrays.sort(nums);
        
        // output
        for(int num : nums) {
            bw.write(num+"\n");
        }
        bw.flush();
        bw.close();
    }
}