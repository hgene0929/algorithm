import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// input
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		for(int t=0; t<n; t++) {
			int num = Integer.parseInt(st.nextToken());

			// solution : 에라토스테네스의 체
			boolean[] isPrime = new boolean[num+1];
			for(int i=2; i<isPrime.length; i++) { // 자연수 중 가장 작은 소수 == 2
				isPrime[i] = true;
			}
			for(int i=2; i<=Math.sqrt(num); i++) {
				if(isPrime[i]) {
					for(int j=i*i; j<=num; j+=i) {
						isPrime[j] = false;
					}
				}
			}
			if(isPrime[num]) {
				count++;
			}
		}

		// output
		bw.write(count+"");
		bw.flush();
		bw.close();
    }
}