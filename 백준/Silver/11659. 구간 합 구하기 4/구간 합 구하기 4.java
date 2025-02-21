import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int M;
	
	private static int[] nums;
	private static int[] prefix;
	
	private static StringBuilder   sb;
	private static BufferedReader  br;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		init();
		
		for (int i = 0; i < M; i++)
			prefixSum();
		
		System.out.println(sb);
		
		clearAll();
	}
	
	private static void init() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st   = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		prefix = new int[N+1];
		for (int i = 1; i <= N; i++) {
			prefix[i] = prefix[i-1] + nums[i-1];
		}
		
		sb = new StringBuilder();
	}
	
	private static void prefixSum() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int i = Integer.parseInt(st.nextToken());
		int j = Integer.parseInt(st.nextToken());
		
		int	ans = prefix[j] - prefix[i-1];

		sb.append(ans).append('\n');
	}
	
	private static void clearAll() throws IOException {
		br.close();
	}

}