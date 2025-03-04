import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int N;
	private static int M;
	private static int ans;
	
	private static int[] cards;
	private static int[] tmp;
	
	public static void main(String[] args) throws IOException {
		//--------------솔루션 코드를 작성하세요.--------------------------------
		init();
		sol(0, 0, 0);
		System.out.println(ans);
	}
	
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cards = new int[N];
		tmp = new int[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void sol(int depth, int start, int sum) {
		if (sum > M) return ;
		
		if (depth == 3) {
			ans = Math.max(ans, sum);			
			return ;
		}

		
		for (int i = start; i < N; i++) {
			tmp[depth] = cards[i];
			sol(depth + 1, i + 1, sum + cards[i]);
		}
	}

}
