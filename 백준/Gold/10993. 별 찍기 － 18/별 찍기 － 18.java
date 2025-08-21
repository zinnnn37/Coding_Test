import java.io.*;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static int N;
	private static int height;
	private static int width;

	private static char[][] mat;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		N      = Integer.parseInt(br.readLine());
		height = (int) (Math.pow(2, N) - 1);
		width  = height * 2 - 1;

		mat = new char[height][width];
	}

	private static void sol() throws IOException {
		rec(N, 0, 0);
		printMat();
	}

	private static void rec(int n, int x, int y) {
		if (n == 1) {
			mat[x][y] = '*';
			return;
		}

		int h = (int) (Math.pow(2, n) - 1);
		int w = h * 2 - 1;

		if (n % 2 == 1) {
			for (int i = 0; i <= w / 2; i++) {
				mat[x + h - i - 1][y + i]             = '*';
				mat[x + h - i - 1][y + h * 2 - i - 2] = '*';
				mat[x + h - 1][y + i]                 = '*';
				mat[x + h - 1][y + h * 2 - i - 2]     = '*';
			}
			rec(n - 1, x + h / 2, y + w / 4 + 1);
		} else {
			for (int i = 0; i <= w / 2; i++) {
				mat[x][y + i]                 = '*';
				mat[x][y + h * 2 - i - 2]     = '*';
				mat[x + i][y + i]             = '*';
				mat[x + i][y + h * 2 - i - 2] = '*';
			}
			rec(n - 1, x + 1, y + w / 4 + 1);
		}
	}

	private static void printMat() throws IOException {
		for (char[] chars : mat) {
			// 각 줄에서 마지막 '*'의 위치 찾기
			int lastStar = -1;
			for (int i = chars.length - 1; i >= 0; i--) {
				if (chars[i] == '*') {
					lastStar = i;
					break;
				}
			}

			// 마지막 별까지만 출력
			for (int i = 0; i <= lastStar; i++) {
				if (chars[i] == '*') {
					bw.write('*');
				} else {
					bw.write(' ');
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
