import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private static int N;
	private static int ans;
	
	public static void main(String[] args) throws IOException {
		init();
		sol();
		
		System.out.println(ans);
	}
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		ans = 0;
	}
	
	private static void sol() {
		while (N > 0) {
			if (N % 5 == 0) {
				ans += (N / 5);
				return ;
			}
			
			N -= 3;
			ans += 1;
		}
		
		if (N < 0) ans = -1;
	}

}