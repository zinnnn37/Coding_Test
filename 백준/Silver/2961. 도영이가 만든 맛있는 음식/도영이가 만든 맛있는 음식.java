import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int  N;
	private static long ans;
	
	private static int[] S;
	private static int[] B;
	
	
	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		init();
		cook();
		
		System.out.println(ans);
	}
	
	private static void init() throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N   = Integer.parseInt(br.readLine());
		ans = Integer.MAX_VALUE;
		
		S = new int[N];
		B = new int[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
	
	private static void cook() {
		int subsetCnt = 1 << N;
		
		for (int i = 1; i < subsetCnt; i++) {
			long tmpS = 1;
			long tmpB = 0;

			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					tmpS *= S[j];
					tmpB += B[j];
				}
			}
			ans = Math.min(ans, Math.abs(tmpS - tmpB));
		}
	}

}