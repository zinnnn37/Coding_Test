import java.io.*;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static long N;

	public static void main(String[] args) throws IOException {
		sol();
	}

	private static void sol() throws IOException {
		N = Long.parseLong(br.readLine());

		long ans  = N;
		long  sqrt = (long) Math.sqrt(N);
		for (int i = 2; i <= sqrt; i++) {
			if (N % i == 0) {
				ans -= ans / i;

				while (N % i == 0) {
					N /= i;
				}
			}
		}
		if (N > 1) {
			ans -= ans / N;
		}
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}