import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int R;
	private static int C;
	private static int ans;
	
	private static String[]  map;

	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		init();
		sol();
	}
	
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = 0;
		
		map = new String[R];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().trim();
		}
		
		visited = new boolean[R][C];
	}
	
	private static void sol() {
		for (int i = 0; i < R; i++) {
			if (map[i].charAt(0) != 'x' && backTracking(i, 0)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	private static boolean backTracking(int row, int col) {
		if (col == C-1) {
			return true;
		}
		
		if (isOOB(row, col) || map[row].charAt(col) == 'x' || visited[row][col]) return false;
		
		visited[row][col] = true;

        if (backTracking(row - 1, col + 1)) {
			return true;
		} else if (backTracking(row, col + 1)) {
			return true;
		} else if (backTracking(row + 1, col + 1)) {
			return true;
		}
		
		return false;
	}
	
	private static boolean isOOB(int i, int j) {
		return !(0 <= i && i < R && 0 <= j && j < C);
	}

}