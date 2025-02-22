import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	private static final int UP    = 1;    // 변경: 1부터 시작하는 방향
	private static final int DOWN  = 2;
	private static final int LEFT  = 3;
	private static final int RIGHT = 4;

	private static final int[] dx = { 0, -1, 1, 0, 0 };  // 0번 인덱스는 사용하지 않음
	private static final int[] dy = { 0, 0, 0, -1, 1 };  // 0번 인덱스는 사용하지 않음

	private static int N;  // size
	private static int M;  // nums of shark
	private static int K;  // duration

	private static HashMap<Integer, Shark> sharks;
	private static Block[][]               matrix;
	private static int[][][]               priorities;

	private static class Shark {
		int x;
		int y;
		int dir;

		Shark(int x, int y, int dir) {
			this.x   = x;
			this.y   = y;
			this.dir = dir;
		}
	}

	private static class Block {
		int shark;    // 현재 상어
		int sentOf;   // 냄새 주인
		int duration; // 냄새 지속시간

		Block(int shark, int sentOf, int duration) {
			this.shark    = shark;
			this.sentOf   = sentOf;
			this.duration = duration;
		}

		public void decreaseDuration() {
			if (duration > 0) {
				duration--;
				if (duration == 0) {
					shark  = 0;
					sentOf = 0;
				}
			}
		}

		public void setNewSmell(int sharkId) {
			this.shark    = sharkId;
			this.sentOf   = sharkId;
			this.duration = K;
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		System.out.println(solve());
	}

	private static void init() throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		matrix     = new Block[N + 1][N + 1];
		sharks     = new HashMap<>();
		priorities = new int[M + 1][5][4];

		// 격자 초기화
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				matrix[i][j] = new Block(0, 0, 0);
			}
		}

		// 상어 위치 초기화
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int sharkNum = Integer.parseInt(st.nextToken());
				if (sharkNum > 0) {
					sharks.put(sharkNum, new Shark(i, j, 0));
					matrix[i][j] = new Block(sharkNum, sharkNum, K);
				}
			}
		}

		// 상어 방향 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			if (sharks.containsKey(i)) {
				sharks.get(i).dir = Integer.parseInt(st.nextToken());
			}
		}

		// 우선순위 초기화
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					priorities[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
	}

	private static int solve() {
		int time = 0;

		while (time <= 1000) {
			if (sharks.size() == 1 && sharks.containsKey(1)) {
				return time;
			}

			// 현재 상어 위치 초기화
			for (int i = 1; i <= M; i++) {
				if (sharks.containsKey(i)) {
					Shark cur = sharks.get(i);
					matrix[cur.x][cur.y].shark = 0;
				}
			}

			// 상어 이동
			for (int i = 1; i <= M; i++) {
				if (!sharks.containsKey(i)) continue;
				moveShark(i);
			}

			// 냄새 감소
			decreaseSmell();

			// 새로운 냄새 설정
			for (int i = 1; i <= M; i++) {
				if (sharks.containsKey(i)) {
					Shark cur = sharks.get(i);
					matrix[cur.x][cur.y].setNewSmell(i);
				}
			}

			time++;
		}

		return -1;
	}

	private static void moveShark(int sharkNum) {
		Shark   cur   = sharks.get(sharkNum);
		int     nx    = -1, ny = -1, nd = -1;
		boolean found = false;

		// 1. 냄새가 없는 칸 찾기
		for (int i = 0; i < 4; i++) {
			int dir = priorities[sharkNum][cur.dir][i];
			int tx  = cur.x + dx[dir];
			int ty  = cur.y + dy[dir];

			if (tx < 1 || tx > N || ty < 1 || ty > N) continue;
			if (matrix[tx][ty].sentOf == 0) {  // 냄새가 없는 칸
				nx    = tx;
				ny    = ty;
				nd    = dir;
				found = true;
				break;
			}
		}

		// 2. 자신의 냄새가 있는 칸 찾기
		if (!found) {
			for (int i = 0; i < 4; i++) {
				int dir = priorities[sharkNum][cur.dir][i];
				int tx  = cur.x + dx[dir];
				int ty  = cur.y + dy[dir];

				if (tx < 1 || tx > N || ty < 1 || ty > N) continue;
				if (matrix[tx][ty].sentOf == sharkNum) {
					nx = tx;
					ny = ty;
					nd = dir;
					break;
				}
			}
		}

		// 이동
		if (matrix[nx][ny].shark > 0) {  // 이미 다른 상어가 있는 경우
			sharks.remove(sharkNum);  // 현재 상어 제거
		} else {
			matrix[nx][ny].shark = sharkNum;
			
			cur.x   = nx;
			cur.y   = ny;
			cur.dir = nd;
		}
	}

	private static void decreaseSmell() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				matrix[i][j].decreaseDuration();
			}
		}
	}
}