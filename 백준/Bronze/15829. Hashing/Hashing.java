import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input
		int L = Integer.parseInt(br.readLine());
		String S = br.readLine();

		// solution
		long result = 0;
		long pow = 1;
		for(int i = 0; i < L; i++) {
			result += ((S.charAt(i) - 96) * pow);
			pow = (pow * 31) % 1234567891;
		}

		// output
		System.out.println(result % 1234567891);
	}
}