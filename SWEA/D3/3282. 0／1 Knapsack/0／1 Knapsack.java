import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder   sb = new StringBuilder();
	private static       StringTokenizer st;

	private static int N;
	private static int K;

	private static int[]   dp;
	private static int[][] objs;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			init();
			sol();

			sb.append("#").append(t).append(" ").append(dp[K]).append("\n");
		}
		System.out.println(sb);
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		objs = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			objs[i][0] = Integer.parseInt(st.nextToken());
			objs[i][1] = Integer.parseInt(st.nextToken());
		}
		dp = new int[K + 1];
	}

	private static void sol() {
		for (int i = 0; i < N; i++) {
			for (int j = K; j >= objs[i][0]; j--) {
				dp[j] = Math.max(dp[j], dp[j - objs[i][0]] + objs[i][1]);
			}
		}
	}

}
