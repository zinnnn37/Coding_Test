import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static StringTokenizer st;

	private static int    N;
	private static double ans;

	private static long[] x;
	private static long[] y;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	public static void init() throws IOException {
		N   = Integer.parseInt(br.readLine());
		ans = 0;

		x = new long[N];
		y = new long[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			x[i] = Long.parseLong(st.nextToken());
			y[i] = Long.parseLong(st.nextToken());
		}
	}

	public static void sol() {
		double[] params = getParams();

		ans = (params[0] - params[1]) / 2;
		System.out.printf("%.1f", Math.abs(ans));
	}

	private static double[] getParams() {
		double left  = 0;
		double right = 0;

		for (int i = 0; i < N; i++) {
			left += x[i] * y[(i + 1) % N];
			right += x[(i + 1) % N] * y[i];
		}

		return new double[] { left, right };
	}

}