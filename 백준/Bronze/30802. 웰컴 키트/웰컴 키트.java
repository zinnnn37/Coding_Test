import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static       StringTokenizer st;

	private static int N;
	private static int T;
	private static int P;

	private static int[] sizes;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		sizes = new int[6];
		st    = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			sizes[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		T  = Integer.parseInt(st.nextToken());
		P  = Integer.parseInt(st.nextToken());
	}

	private static void sol() {
		int shirts = 0;
		for (int size : sizes) {
			shirts += size / T;
			if (size % T != 0) shirts++;
		}
		System.out.println(shirts);
		System.out.println((N / P) + " " + (N % P));
	}

}