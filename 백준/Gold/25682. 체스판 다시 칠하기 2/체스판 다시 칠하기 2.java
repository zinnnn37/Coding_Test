import java.io.*;
import java.util.StringTokenizer;

public class Main {

	private static final boolean BLACK = true;
	private static final boolean WHITE = false;

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static       StringTokenizer st;

	private static int N, M, K;

	private static boolean[][] board;
	private static int[][]     prefix;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());
		K  = Integer.parseInt(st.nextToken());

		board  = new boolean[N + 1][M + 1];
		prefix = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				board[i][j] = s.charAt(j - 1) == 'B' ? BLACK : WHITE;
			}
		}
	}

	private static void sol() throws IOException {
		bw.write(Math.min(setPrefix(BLACK), setPrefix(WHITE)) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	// 열 + 행이 짝수일 때 color라고 가정
	private static int setPrefix(boolean color) {
		int val;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if ((i + j) % 2 == 0) {
					val = board[i][j] != color ? 1 : 0;
				} else {
					val = board[i][j] == color ? 1 : 0;
				}
				prefix[i][j] = prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1] + val;
			}
		}
		return getMinPrefix();
	}

	private static int getMinPrefix() {
		int cnt = Integer.MAX_VALUE;

		for (int i = K; i <= N; i++) {
			for (int j = K; j <= M; j++) {
				cnt = Math.min(cnt, prefix[i][j] - prefix[i - K][j] - prefix[i][j - K] + prefix[i - K][j - K]);
			}
		}
		return cnt;
	}

}