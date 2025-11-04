import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static       StringTokenizer st;

	private static int N, K;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
	}

	private static void sol() throws IOException {
		for (int i = 0; i < N; i++) {
			dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);

			int next = i + i / 2;
			if (i < next && next <= N) dp[next] = Math.min(dp[next], dp[i] + 1);
		}

		bw.write(dp[N] <= K ? "minigimbob" : "water");
		bw.flush();
		bw.close();
		br.close();
	}

}