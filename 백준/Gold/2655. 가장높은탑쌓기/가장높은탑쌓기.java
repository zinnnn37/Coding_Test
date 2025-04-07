import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder   sb = new StringBuilder();
	private static       StringTokenizer st;

	private static int N;

	private static int[] dp;
	private static int[] prev;

	private static Brick[] bricks;

	private static class Brick implements Comparable<Brick> {
		int id;
		int area;
		int height;
		int weight;

		public Brick(int id, int area, int height, int weight) {
			this.id     = id;
			this.area   = area;
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Brick o) {
			return Integer.compare(o.area, this.area);
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		bricks = new Brick[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			bricks[i] = new Brick(i + 1, a, b, c);
		}
		Arrays.sort(bricks);

		dp   = new int[N];
		prev = new int[N]; // 경로 추적용
		for (int i = 0; i < N; i++) {
			dp[i]   = bricks[i].height;
			prev[i] = -1;
		}
	}

	private static void sol() {
		doDP();
		getAns();
	}

	private static void doDP() {
		// dp[i]: i번째 벽돌이 탑의 가장 위에 있을 때의 최대 높이
		for (int i = 0; i < N; i++) {
			// i가 위에 쌓이는 벽돌
			for (int j = 0; j < i; j++) {
				if (bricks[i].weight >= bricks[j].weight) continue;
				if (dp[i] >= dp[j] + bricks[i].height) continue;

				dp[i]   = dp[j] + bricks[i].height;
				prev[i] = j; // i 밑에 j가 놓임
			}
		}
	}

	private static void getAns() {
		// 최대 높이 찾기
		int maxIdx = 0;
		for (int i = 1; i < N; i++) {
			maxIdx = dp[i] > dp[maxIdx] ? i : maxIdx;
		}

		// 경로 추적
		Queue<Integer> q = new ArrayDeque<>();
		while (maxIdx != -1) {
			q.offer(bricks[maxIdx].id);
			maxIdx = prev[maxIdx];
		}

		sb.append(q.size()).append("\n");
		while (!q.isEmpty()) {
			sb.append(q.poll()).append("\n");
		}
		System.out.println(sb);
	}

}