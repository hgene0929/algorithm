import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // input
        int n = Integer.parseInt(br.readLine());
        
        // solution : 2nd 줄부터 6개씩 증가하는 등차수열
        int count = 1; // 최소거리(1시작)
        int range = 2; // 범위(6,12,18,...)
        if(n == 1) {
            bw.write(1+"");
        } else {
            while(range <= n) {
                range = range + (6*count);
                count++;
            }
            bw.write(count+"");
        }
        
        // output
        bw.flush();
        bw.close();
    }
}