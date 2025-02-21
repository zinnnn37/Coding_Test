import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static final int[]	dx = { 0, 1, 0, -1 };
	private static final int[]	dy = { 1, 0, -1, 0 };
	
	private static int	N;
	private static int	tmpSum;
	private static int	minSum;
	
	private static int[][]		cost;
	private static boolean[][]	visited;
	
	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		init();

	    for(int i = 1; i < N-1; i++) {
	        for(int j = 1; j < N-1; j++) {
	            backTracking(i, j, 0);
	        }
	    }
		
		System.out.println(minSum);
	}
	
	private static void init() throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st;
		
		N      = Integer.parseInt(br.readLine());
		minSum = Integer.MAX_VALUE;
		
		cost    = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
	}
	
	private static void backTracking(int x, int y, int depth) {
		// base condition
		if (depth == 3) {
			minSum = Math.min(minSum, tmpSum);
			return ;
		}
		
		for (int i = x; i < N-1; i++) {
			for (int j = (i == x ? y : 1); j < N-1; j++) {
				if (!isAvailable(i, j)) continue;
				
				int costHere = getCost(i, j);
				
				tmpSum += costHere;
		        if (tmpSum >= minSum) {  // pruning
		            tmpSum -= costHere;
		            continue;
		        }
				
				setVisited(i, j, true);
				
				backTracking(i, j, depth+1);
				
				setVisited(i, j, false);
				tmpSum -= costHere;
			}
		}
		
	}
	
	private static boolean isAvailable(int x, int y) {
		if (isOOB(x, y)) return false;
		if (visited[x][y]) return false;
		
		for (int d = 0; d < 4; d++) {
			int	nx = x + dx[d];
			int ny = y + dy[d];
			
			if (visited[nx][ny]) return false;
		}
		return true;
	}
	
	private static void setVisited(int x, int y, boolean flag) {
		visited[x][y] = flag;
		for (int d = 0; d < 4; d++) {
			int	nx = x + dx[d];
			int ny = y + dy[d];
			
			visited[nx][ny] = flag;
		}
	}
	
	private static int getCost(int x, int y) {
		int	ret = cost[x][y];
		
		for (int d = 0; d < 4; d++) {
			int	nx = x + dx[d];
			int ny = y + dy[d];
			
			ret += cost[nx][ny];
		}
		return ret;
	}
	
	private static boolean isOOB(int x, int y) {
		return x <= 0 || x >= N-1 || y <= 0 || y >= N-1;
	}
	
}