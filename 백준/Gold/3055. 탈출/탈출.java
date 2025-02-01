import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	
	static int	r;
	static int	c;

	static int[]	dx = { 0, 1, 0, -1 };
	static int[]	dy = { 1, 0, -1, 0 };
	
	static char[][]	map;
	static int[][]	dp;
	
	static int	dstX;
	static int	dstY;
	
	static Queue<Point> q;
	
	public static void main(String[] args) throws IOException {
		
		init();
		System.out.println(bfs());
	}
	
	static void init() throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		dp = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				dp[i][j] = 0;
			}
		}
		
		q = new LinkedList<>();
		
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				
				if (map[i][j] == 'S') {
					q.offer(new Point(i, j));
				} else if (map[i][j] == 'D') {
					dstX = i;
					dstY = j;
				}
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == '*') {
					q.offer(new Point(i, j));
				}
			}
		}
	}
	
	static String bfs() {
		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (checkValid(nx, ny)) {
					if (map[cur.x][cur.y] == 'S'
							&& (map[nx][ny] == '.' || map[nx][ny] == 'D')) {
						map[nx][ny] = 'S';
						dp[nx][ny] = dp[cur.x][cur.y] + 1;
						
						if (nx == dstX && ny == dstY) {
							return dp[dstX][dstY] + "";
						}
						
						q.offer(new Point(nx, ny));
					} else if (map[cur.x][cur.y] == '*'
							&& (map[nx][ny] == '.' || map[nx][ny] == 'S')) {
						map[nx][ny] = '*';
						q.offer(new Point(nx, ny));
					}
				}
			}
		}
		
		return "KAKTUS";
	}
	
	static boolean checkValid(int nx, int ny) {
		return 0 <= nx && nx < r && 0 <= ny && ny < c;
	}
	
	static void printMap() {

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}