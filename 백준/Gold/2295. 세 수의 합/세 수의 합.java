import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static int   N;
	private static int[] nums;

	private static Set<Integer> pref;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);

		pref = new HashSet<>();
	}

	private static void sol() {
		// a + b
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				pref.add(nums[i] + nums[j]);
			}
		}

		// k - c
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				int target = nums[i] - nums[j];

				if (pref.contains(target)) {
					System.out.println(nums[i]);
					System.exit(0);
				}
			}
		}
	}

}