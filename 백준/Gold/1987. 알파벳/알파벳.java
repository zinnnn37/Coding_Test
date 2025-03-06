import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static final int[] dx = { 0, 1, 0, -1 };
	private static final int[] dy = { 1, 0, -1, 0 };
	
	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int R;
	private static int C;
	private static int ans;
	
	private static boolean[] alpha;

	private static char[][] matrix;
	
	public static void main(String[] args) throws IOException {
		init();
		sol(0, 0, 1);
		
		System.out.println(ans);
	}
	
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new boolean[26];
		
		matrix = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				matrix[i][j] = s.charAt(j);
			}
		}
		
		alpha[matrix[0][0] - 'A'] = true;
	}
	
	private static void sol(int x, int y, int cnt) {
		ans = Math.max(ans, cnt);
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (OOB(nx, ny)) continue;
			
			int target = matrix[nx][ny] - 'A';
			if (alpha[target]) continue;
			
			alpha[target] = true;
			sol(nx, ny, cnt+1);
			alpha[target] = false;
		}
	}
	
	private static boolean OOB(int x, int y) {
		return x < 0 || R <= x || y < 0 || C <= y;
	}

}
