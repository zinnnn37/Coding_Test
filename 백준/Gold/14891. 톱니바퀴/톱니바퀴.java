import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static final int S     = 1;
	private static final int LEFT  = 6;
	private static final int RIGHT = 2;
	private static final int CCW   = 1;
	private static final int CW    = -1;

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder   sb = new StringBuilder();
	private static       StringTokenizer st;

	private static int K;
	private static int score;

	private static int[]   topIdx;
	private static int[]   rotateDir;
	private static int[][] magnets;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		score = 0;

		magnets = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				magnets[i][j] = Integer.parseInt(s.charAt(j) + "");
			}
		}
		topIdx    = new int[4];
		rotateDir = new int[4];
	}

	private static void sol() throws IOException {
		K = Integer.parseInt(br.readLine());

		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());

			int id  = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken()) * -1;

			Arrays.fill(rotateDir, 0);
			rotateDir[id] = dir;

			checkLeft(id);
			checkRight(id);
			rotateMagnet();
		}
		getAns();
	}

	private static void checkLeft(int id) {
		for (int i = id; i > 0; i--) {
			if (rotateDir[i] == 0 || getRightPole(i - 1) == getLeftPole(i)) {
				break;
			}
			rotateDir[i - 1] = -rotateDir[i];
		}
	}

	private static void checkRight(int id) {
		for (int i = id; i < 3; i++) {
			if (rotateDir[i] == 0 || getRightPole(i) == getLeftPole(i + 1)) {
				break;
			}
			rotateDir[i + 1] = -rotateDir[i];
		}
	}

	private static void rotateMagnet() {
		for (int i = 0; i < 4; i++) {
			int dir = rotateDir[i];

			if (dir == CCW) {
				topIdx[i] = (topIdx[i] + dir) % 8;
			} else if (dir == CW) {
				topIdx[i] = (topIdx[i] + CW + 8) % 8;
			}
		}
	}

	private static void getAns() {
		for (int i = 0; i < 4; i++) {
			if (magnets[i][topIdx[i]] != S) {
				continue;
			}
			score += (1 << i);
		}
		System.out.println(score);
	}

	private static int getLeftPole(int id) {
		return magnets[id][(topIdx[id] + LEFT) % 8];
	}

	private static int getRightPole(int id) {
		return magnets[id][(topIdx[id] + RIGHT) % 8];
	}

}