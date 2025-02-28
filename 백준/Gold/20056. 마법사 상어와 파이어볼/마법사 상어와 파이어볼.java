import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	// ↑, ↗, →, ↘, ↓, ↙, ←, ↖
	private static final int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	private static final int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;

	private static int N; // shark
	private static int M; // number of fireball
	private static int K; // cmd

	private static List<FireBall>     fireBalls;
	private static List<FireBall>[][] board;

	private static class FireBall {
		int row;
		int col;
		int mass;
		int speed;
		int dir;

		FireBall(int row, int col, int mass, int speed, int dir) {
			this.row   = row;
			this.col   = col;
			this.mass  = mass;
			this.speed = speed;
			this.dir   = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		enchant();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board     = new ArrayList[N][N];
		fireBalls = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int row   = Integer.parseInt(st.nextToken()) - 1;
			int col   = Integer.parseInt(st.nextToken()) - 1;
			int mass  = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir   = Integer.parseInt(st.nextToken());

			FireBall fireBall = new FireBall(row, col, mass, speed, dir);
			fireBalls.add(fireBall);
		}

		br.close();
	}

	private static void enchant() {
		while (K-- > 0) {
			initBoard();
			// move fireballs
			moveFireBall();
			// find spots with multiple fireballs and split them
			dealCollision();

			updateFireBallsList();
		}
		System.out.println(getTotalMass());
	}

	private static void initBoard() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = new ArrayList<>();
			}
		}
	}

	private static void moveFireBall() {
		for (FireBall fb : fireBalls) {
			// if N == 4 && speed == 5
			// shark appears to move only 1 unit (5 % 4 = 1)
			int nrow = fb.row + dx[fb.dir] * (fb.speed % N);
			int ncol = fb.col + dy[fb.dir] * (fb.speed % N);

			if (nrow < 0) {
				nrow += N;
			} else if (nrow >= N) {
				nrow -= N;
			}
			if (ncol < 0) {
				ncol += N;
			} else if (ncol >= N) {
				ncol -= N;
			}

			fb.row = nrow;
			fb.col = ncol;
			board[fb.row][fb.col].add(fb);
		}
	}

	private static void dealCollision() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j].size() < 2) continue;

				int mSum = 0;
				int sSum = 0;

				boolean even = false;
				boolean odd  = false;

				for (FireBall fb : board[i][j]) {
					mSum += fb.mass;
					sSum += fb.speed;

					if (fb.dir % 2 == 0) {
						even = true;
					} else {
						odd = true;
					}
				}
				int nMass  = mSum / 5;
				int nSpeed = sSum / board[i][j].size();

				board[i][j].clear();

				if (nMass <= 0) continue;

				// true -> contains both even and odd vals
				int add = even && odd ? 1 : 0;
				for (int k = 0; k < 8; k += 2) {
					board[i][j].add(new FireBall(i, j, nMass, nSpeed, k + add));
				}
			}
		}
	}

	private static void updateFireBallsList() {
		fireBalls = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j].isEmpty()) continue;

				fireBalls.addAll(board[i][j]);
			}
		}
	}

	private static int getTotalMass() {
		int mass = 0;
		for (FireBall fb : fireBalls) {
			mass += fb.mass;
		}
		return mass;
	}

}