import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int M;
	
	private static int[] nums;
	
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		init();
		combi(0, 1);
		
		System.out.println(sb);
	}
	
	private static void init() throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[M];
		
		sb = new StringBuilder();
	}
	
	private static void combi(int depth, int idx) {
		if (depth == M) {
			getAns();
			return ;
		}
		
		for (int i = idx; i <= N; i++) {
			nums[depth] = i;
			combi(depth+1, i+1);
		}
	}
	
	private static void getAns() {
		for (int i = 0; i < M; i++) {
			sb.append(nums[i]).append(' ');
		}
		sb.append('\n');
	}
	
}