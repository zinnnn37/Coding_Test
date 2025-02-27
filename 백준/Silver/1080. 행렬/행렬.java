import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int N;
	private static int M;
	private static int cnt;
	
	private static boolean[][] input;
	private static boolean[][] output;
	
	public static void main(String[] args) throws IOException {
		init();
		sol();
	}
	
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		input = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < M; j++) {
				input[i][j] = s.charAt(j) == '1' ? true : false;
			}
		}
		
		output = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();

			for (int j = 0; j < M; j++) {
				output[i][j] = s.charAt(j) == '1' ? true : false;
			}
		}
		
		br.close();
	}
	
	private static void sol() {
		for (int i = 0; i < N-2; i++) {
			for (int j = 0; j < M-2; j++) {
				flipFlop(i, j);
			}
		}
		
		if (!checkLastTwoLines()) {
			System.out.println(-1);
		} else {
			System.out.println(cnt);
		}
	}
	
	private static void flipFlop(int x, int y) {
		if (input[x][y] != output[x][y]) {
			cnt++;
			for (int i = x; i < x + 3; i++) {
				for (int j = y; j < y + 3; j++) {
					input[i][j] = !input[i][j];
				}
			}
		}
	}
	
	private static boolean checkLastTwoLines() {
		if (N < 3 || M < 3) {
			if (checkSame()) {
				return true;
			} else {
				return false;
			}
		}

        for (int i = N-2; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (input[i][j] != output[i][j]) {
					return false;
				}
			}
		}
		
		for (int i = 0; i < N-2; i++) {
			for (int j = M-2; j < M; j++) {
				if (input[i][j] != output[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private static boolean checkSame() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (input[i][j] != output[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}