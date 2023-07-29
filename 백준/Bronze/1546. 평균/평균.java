import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // input
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] scores = new int[n];
        int max = -1;
        for(int i=0; i<n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(temp > max) {
                max = temp;
            }
            scores[i] = temp;
        }
        
        // solution
        double sum = 0;
        for(int i=0; i<n; i++) {
            sum += (double)scores[i] / max * 100;
        }
        double result = sum / n;
        
        // output
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}