import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] comments;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // input
        n = Integer.parseInt(br.readLine());
        comments = new int[n];
        for(int i=0; i<n; i++) comments[i] = Integer.parseInt(br.readLine());
        
        // solution
        Arrays.sort(comments);
        int excepts = (int) Math.round(n * 0.15);
        int avg = avg(excepts);
        
        // output
        System.out.print(avg);
    }
    
    static int avg(int excepts) {
    	double sum = 0; int cnt = 0;
    	for(int i=excepts; i<n-excepts; i++) {
    		sum += comments[i]; cnt++;
    	}
    	return (int) Math.round(sum/cnt);
    }
}