import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T;
	private static int N;
	private static int L;
	private static int maxSum;
	
	private static int[]	scores;
	private static int[]	calories;
	
	private static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T  = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			init();
			hamburger();
			
			System.out.printf("#%d %d\n", tc, maxSum);
		}
	}
	
	private static void init() throws IOException {
		StringTokenizer	st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		maxSum = 0;
		
		scores   = new int[N];
		calories = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int score   = Integer.parseInt(st.nextToken());
			int calorie = Integer.parseInt(st.nextToken());
			
			scores[i]   = score;
			calories[i] = calorie;
		}
	}
	
	private static void hamburger() {
		int subsetCnt = 1 << N;
		
		for (int i = 0; i < subsetCnt; i++) {
			int tmpCal   = 0;
			int tmpScore = 0;
			
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					tmpCal   += calories[j];
					tmpScore += scores[j];
				}
			}
			
			if (tmpCal <= L) {
				maxSum = Math.max(maxSum, tmpScore);
			}
		}
	}

}