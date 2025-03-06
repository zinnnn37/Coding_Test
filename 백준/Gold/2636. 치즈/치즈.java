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
	
	private static int H;
	private static int W;
	
	private static int time;
	private static int prev;
	
	private static int[][]     cheese;
	private static boolean[][] visited;
	
	private static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}
	
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		time = 0;
		prev = 0;
		
		cheese = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[H][W];
		q = new ArrayDeque<>();
	}
	
	private static void sol() {
		int cnt = 0;
		
		while (true) {
			clearVisited();
			
			cnt = bfs();
			
			if (cnt == 0) break;
			
			prev = cnt;
			time++;
		}
		
		System.out.println(time);
		System.out.println(prev);
	}
	
	private static int bfs() {
		int cnt = 0;

		visited[0][0] = true;
		q.offer(new Point(0, 0));
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if (OOB(nx, ny) || visited[nx][ny]) continue;
				
				if (cheese[nx][ny] == 0) {
					q.offer(new Point(nx, ny));
					visited[nx][ny] = true;
				} else {
					cheese[nx][ny] = 0;
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	private static void clearVisited() {
		for (int i = 0; i < H; i++) {
			Arrays.fill(visited[i], false);
		}
	}
	
	private static boolean OOB(int x, int y) {
		return x < 0 || H <= x || y < 0 || W <= y;
	}
	
}
