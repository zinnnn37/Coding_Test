import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static       StringTokenizer st;

	private static int N;
	private static int K;

	private static int[][] obj;
	private static int[][] knapsack;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		obj = new int[N + 1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			obj[i][0] = Integer.parseInt(st.nextToken());
			obj[i][1] = Integer.parseInt(st.nextToken());
		}

		knapsack = new int[N + 1][K + 1];
	}

	private static void sol() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j >= obj[i][0]) {
					knapsack[i][j] = Math.max(knapsack[i - 1][j], knapsack[i - 1][j - obj[i][0]] + obj[i][1]);
				} else {
					knapsack[i][j] = knapsack[i - 1][j];
				}
			}
		}
		System.out.println(knapsack[N][K]);
	}

}