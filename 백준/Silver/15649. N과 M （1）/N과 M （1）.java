import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int	N;
	private static int	M;
	
	private static int[]		nums;
	private static boolean[]	visited;
	
	private static StringBuilder	sb;
	
	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer	st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[M];
		visited = new boolean[N];
		
		sb = new StringBuilder();
		
		perm(0);
		
		System.out.println(sb);
	}

	private static void perm(int depth) {
		if (depth == M) {
			printArr();
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;

			nums[depth] = i+1;
			visited[i] = true;
			
			perm(depth + 1);
			
			visited[i] = false;
			nums[depth] = 0;
		}
	}
	
	private static void printArr() {
		for (int num : nums) {
			sb.append(num).append(" ");
		}
		sb.append('\n');
	}
	
}
