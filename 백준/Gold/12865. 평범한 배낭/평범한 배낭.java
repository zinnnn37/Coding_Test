import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static       StringTokenizer st;

	private static int N;
	private static int K;

	private static int[]   knapsack;
	private static int[][] obj;

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

		knapsack = new int[K + 1];
	}

	private static void sol() {
		for (int i = 1; i <= N; i++) {
			for (int j = K; j >= obj[i][0]; j--) {
				knapsack[j] = Math.max(knapsack[j], knapsack[j - obj[i][0]] + obj[i][1]);
			}
		}
		System.out.println(knapsack[K]);
	}

}