import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final int MOD = 1234567891;

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static int    L;
	private static String str;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		L   = Integer.parseInt(br.readLine());
		str = br.readLine();
	}

	private static void sol() {
		long mul = 1;
		long ans = 0;
		for (int i = 0; i < L; i++) {
			int tmp = str.charAt(i) - 'a' + 1;
			ans = (ans + tmp * mul) % MOD;
			mul = (mul * 31) % MOD;
		}
		System.out.println(ans);
	}

}