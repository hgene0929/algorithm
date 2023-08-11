import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // input
        int N = Integer.parseInt(br.readLine());
        
        // solution
        PriorityQueue<Point> queue = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            queue.offer(new Point(x, y));
        }
        
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            sb.append(point.x).append(" ").append(point.y).append("\n");
        }
        
        // output
        System.out.println(sb.toString());
    }
}

class Point implements Comparable<Point> {
    int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public int compareTo(Point point) {
        if(this.x == point.x) return this.y - point.y;
        return this.x - point.x;
    }
}