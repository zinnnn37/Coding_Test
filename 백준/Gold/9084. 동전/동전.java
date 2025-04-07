import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder   sb = new StringBuilder();
	private static       StringTokenizer st;

	private static int N;
	private static int M;

	private static int[] coins;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			init();
			sol();
		}
		System.out.println(sb);
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		coins = new int[N];
		st    = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
		}

		M  = Integer.parseInt(br.readLine());
		dp = new int[M + 1];
	}

	private static void sol() {
		dp[0] = 1;

		for (int c = 0; c < N; c++) {
			for (int i = coins[c]; i <= M; i++) {
				dp[i] += dp[i - coins[c]];
			}
		}
		sb.append(dp[M]).append("\n");
	}

}