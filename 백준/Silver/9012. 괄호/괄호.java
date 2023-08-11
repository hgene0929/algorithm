import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            // input
            String ps = br.readLine();
        
            // solution
            Stack<Character> stack = new Stack<>();
            boolean possible = true;
            for(int i=0; i<ps.length(); i++) {
                if(ps.charAt(i) == '(') stack.push('(');
                else {
                    if(stack.isEmpty() || stack.peek() == ')') {
                        possible = false;
                        break;
                    }
                    stack.pop();
                    continue;
                }
            }
            if(!stack.isEmpty()) possible = false;
            
            // output
            if(possible) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb.toString());
    }
}