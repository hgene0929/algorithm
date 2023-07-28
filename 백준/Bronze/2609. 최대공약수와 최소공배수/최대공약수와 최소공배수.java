import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        // solution
        int max;
        int min;
        
        if(a > b) {
            max = gcd(a, b);
            min = lcd(a, b);
        } else {
            max = gcd(b, a);
            min = lcd(b, a);
        }
        
        // output
        bw.write(max+"\n");
        bw.write(min+"\n");
        bw.flush();
        bw.close();
    }
    
    static int gcd(int a, int b) { // a>b
        if(a % b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }
    
    static int lcd(int a, int b) { // a*b != 0
        return a*b / gcd(a,b);
    }
}