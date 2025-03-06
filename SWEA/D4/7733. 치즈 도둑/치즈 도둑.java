import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	private static final int[] dx = { 0, 1, 0, -1 };
	private static final int[] dy = { 1, 0, -1, 0 };
	
	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder   sb = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N;
	private static int ans;
	private static int cnt;
	private static int maxScore;
	
	private static int[][]     score;
	private static boolean[][] visited;
	
	private static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			init();
			cheese();
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		ans = 1;
		maxScore = 0;
		
		score = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
				maxScore = Math.max(maxScore, score[i][j]);
			}
		}
		
		visited = new boolean[N][N];
		q = new ArrayDeque<>();
	}
	
	private static void cheese() {
		for (int S = 1; S <= maxScore; S++) {
			clearVisited();
			countCheeseLoaves(S);
		}
	}
	
	private static void countCheeseLoaves(int S) {
		cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (score[i][j] > S && !visited[i][j]) {
					bfs(i, j, S);
					cnt++;
				}
			}
		}
		ans = Math.max(ans, cnt);
	}
	
	private static void clearVisited() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
	}
	
	private static void bfs(int i, int j, int S) {
		q.offer(new Point(i, j));
		visited[i][j] = true;
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				// OOB || visited || ate
				if (OOB(nx, ny) || visited[nx][ny] || score[nx][ny] <= S) continue;
				
				q.offer(new Point(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
	
	private static boolean OOB(int x, int y) {
		return x < 0 || N <= x || y < 0 || N <= y;
	}
	
}
