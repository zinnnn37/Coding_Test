import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static char[][] ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int maxLen = 4 * n - 3;
		ans = new char[maxLen][maxLen];
		
		for (int i = 0; i < maxLen; i++) {
			Arrays.fill(ans[i], ' ');
		}
		
		dfs(n, 0, maxLen / 2);
		
		// print
		for (int i = 0; i < maxLen; i++) {
			for (int j = 0; j < maxLen; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}
	
	static void dfs(int n, int depth, int start) {
		// break point
		if (depth >= n) return ;
		
		for (int i = start; i < start + 4 * depth + 1; i++) {
			for (int j = start; j < start + 4 * depth + 1; j++) {
				if (i == start || j == start || i == start + 4 * depth || j == start + 4 * depth) {
					ans[i][j] = '*';
				}
			}
		}
		
		dfs(n, depth + 1, start - 2);
	}

}