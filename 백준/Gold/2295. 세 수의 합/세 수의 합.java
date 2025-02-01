import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] nums;
	static int[] sumOfTwo;
	static int len;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		nums = new int[n];
		len = n;
		
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = 0;
		sumOfTwo = new int[(len * (len+1)) / 2];
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				sumOfTwo[idx++] = nums[i] + nums[j];
			}
		}
		
		Arrays.sort(sumOfTwo);
		int ans = sumOfThree();

		System.out.println(ans);
	}
	
	static boolean binarySearch(int target) {
		int start = 0;
		int end = sumOfTwo.length - 1;
		
		while (start <= end) {
			int mid = start + (end - start) / 2;
			
			if (sumOfTwo[mid] < target) {
				start = mid + 1;
			} else if (sumOfTwo[mid] > target) {
				end = mid - 1;
			} else {
				return true;
			}
		}
		
		return false;
	}
	
	static int sumOfThree() {
		int ans = -1;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if (binarySearch(nums[j] - nums[i])) {
					ans = Math.max(ans,  nums[j]);
				}
			}
		}
		return ans;
	}

}
