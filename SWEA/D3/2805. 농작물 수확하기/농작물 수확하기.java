import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	
	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder   sb = new StringBuilder();
	
	private static int N;
	private static int ans;
	
	private static int[][]     farm;
	
	private static class Block {
		int x;
		int y;
		int depth;
		
		Block(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
	
	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			init();
			harvest();
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb.toString());
		
		br.close();
	}
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		farm = new int[N][N];		
		for (int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			for (int j = 0; j < N; j++) {
				farm[i][j] = str.charAt(j) - '0';
			}
		}
		
		ans = 0;
	}
	
	private static void harvest() {
		int mid = N/2;
		
		for (int i = 0; i < N; i++) {
			int start = Math.abs(mid - i);
			int end = N - start;
			
			for (int j = start; j < end; j++) {
				ans += farm[i][j];
			}
		}
	}

}