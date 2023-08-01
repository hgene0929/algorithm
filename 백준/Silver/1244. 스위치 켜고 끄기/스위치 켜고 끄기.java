import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// input
		int n = Integer.parseInt(br.readLine());
		int[] switches = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int[] sex = new int[m];
		int[] nums = new int[m];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			sex[i] = Integer.parseInt(st.nextToken());
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// solution
		for(int i=0; i<m; i++) {
			if(sex[i] == 1) {
				// 남학생이 스위치를 변경하는 과정
				for(int j=nums[i]; j<n+1; j+=nums[i]) {
					if(switches[j-1] == 0) {
						switches[j-1] = 1;
					} else {
						switches[j-1] = 0;
					}
				}
			} else {
				// 여학생이 스위치를 변경하는 과정
				int idx = nums[i]-1;
				if(switches[idx] == 0) {
					switches[idx] = 1;
				} else {
					switches[idx] = 0;
				}

				int left = idx-1;
				int right = idx+1;
				while(left >= 0 && right < n) {
					if(switches[left] != switches[right]) {
						break;
					}
					if(switches[left] == 0) {
						switches[left] = 1;
						switches[right] = 1;
					} else {
						switches[left] = 0;
						switches[right] = 0;
					}
					left--;
					right++;
				}
			}
		}

		// output
        for(int i = 0; i<n; i++) {
			bw.write(switches[i] + " ");
			if((i+1) % 20 == 0) {	// 한 줄에 20개씩 출력
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}