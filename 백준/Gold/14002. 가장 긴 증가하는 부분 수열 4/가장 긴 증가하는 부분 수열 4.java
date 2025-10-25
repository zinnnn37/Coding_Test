import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final StringBuilder   sb = new StringBuilder();
	private static       StringTokenizer st;

	private static int N, lis;
	private static int[] nums, dp;
	private static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N];
		dp[0] = 1;
		stack = new Stack<>();
	}

	private static void sol() throws IOException {
		getLis();
		getArr();

		sb.append(lis).append("\n");
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void getLis() {
		lis = 1;
		for (int i = 1; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					lis = Math.max(lis, dp[i]);
				}
			}
		}
	}

	private static void getArr() {
		int targetLen = lis;

		for (int i = N - 1; i >= 0; i--) {
			if (dp[i] == targetLen) {
				stack.push(nums[i]);
				targetLen--;
			}
		}
	}
}