import java.util.Scanner;

public class Solution {
	
	private static Scanner       sc = new Scanner(System.in);
	private static StringBuilder sb = new StringBuilder();
	
	private static int N;
	private static int ans;
	
	private static int[] mountains;
	
	public static void main(String[] args) {
		sol();
	}
	
	private static void sol() {
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			init();
			findPeak();
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		
		System.out.println(sb);
	}
	
	private static void init() {
		N = sc.nextInt();
		ans = 0;
		
		mountains = new int[N];
		
		for (int i = 0; i < N; i++) {
			mountains[i] = sc.nextInt();
		}
	}
	
	private static void findPeak() {
		for (int i = 1; i < N-1; i++) {
			if (mountains[i-1] > mountains[i] || mountains[i] < mountains[i+1]) {
				continue;
			}
			
			// check left
			int leftDesc = 1;
			for (int left = i-2; left >= 0; left--) {
				if (mountains[left] >= mountains[left+1]) {
					break;
				}
				leftDesc++;
			}
			
			int rightDesc = 1;
			int nxtIdx = i;
			for (int right = i+2; right < N; right++) {
				if (mountains[right-1] <= mountains[right]) {
					break;
				}
				rightDesc++;
				nxtIdx = right;
			}
			
			ans += leftDesc * rightDesc;
			i = nxtIdx;
		}
	}

}