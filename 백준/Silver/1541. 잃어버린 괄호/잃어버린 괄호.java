import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		String input = br.readLine();
		
		// solution
		int res = 0;
		String[] inputs = input.split("-");
		
		int[] nums = new int[inputs.length];
		for(int i=0; i<inputs.length; i++) {
			if(!inputs[i].contains("+")) nums[i] = Integer.parseInt(inputs[i]);
			else {
				String[] temps = inputs[i].split("\\+");
				nums[i] = add(temps);
			}
		}
		
		// output
		res = nums[0];
		if(nums.length == 1) System.out.println(res);
		else {
			for(int i=1; i<nums.length; i++) {
				res -= nums[i];
			}
			System.out.println(res);
		}
	}
	
	static int add(String[] nums) {
		int sum = 0;
		for(String num : nums) sum += Integer.parseInt(num);
		return sum;
	}
}
