import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static       StringTokenizer st;

	private static int N;
	private static int M;
	private static int sum;

	private static int[] active;
	private static int[] cost;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		active = new int[N + 1];
		st     = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			active[i] = Integer.parseInt(st.nextToken());
		}

		sum  = 0;
		cost = new int[N + 1];
		st   = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sum += cost[i];
		}

		dp = new int[sum + 1];
	}

	private static void sol() {
		for (int i = 1; i <= N; i++) {
			for (int j = sum; j >= cost[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - cost[i]] + active[i]);
			}
		}
		for (int i = 0; i <= sum; i++) {
			if (dp[i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}

}