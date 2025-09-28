import java.io.*;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	private static int N;
	private static int[] dp;
	private static Schedule[] schedule;

	private static class Schedule {
		int time;
		int pay;

		Schedule(int time, int pay) {
			this.time = time;
			this.pay = pay;
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		schedule = new Schedule[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			schedule[i] = new Schedule(t, p);
		}
	}

	private static void sol() throws IOException {
		for (int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);

			int idx = schedule[i].time + i - 1;
			if (idx > N) continue;

			dp[idx] = Math.max(dp[i - 1] + schedule[i].pay, dp[idx]);
		}
		
		System.out.println(dp[N]);
		br.close();
	}
}