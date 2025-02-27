import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder   sb = new StringBuilder();
	private static StringTokenizer st;
	
	private static int[] cost;
	private static int[] months;
	private static int[] dp;
	
	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			init();
			swimmingPool();
			
			sb.append('#').append(tc).append(' ').append(dp[12]).append('\n');
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void init() throws IOException {
		cost = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		months = new int[13];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < 13; i++) {
			months[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[13];
	}
	
	private static void swimmingPool() {
		for (int i = 1; i < 13; i++) {
			dp[i] = Math.min(
						cost[3],
						Math.min(dp[i-1] + cost[0] * months[i], dp[i-1] + cost[1])
					);
			
			if (i >= 3) {
				dp[i] = Math.min(dp[i], dp[i-3] + cost[2]); 
			}
		}
	}

}