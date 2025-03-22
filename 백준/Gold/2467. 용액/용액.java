import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static       StringTokenizer st;

	private static int N;

	private static double[] ans;
	private static int[]    chemical;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		N  = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		chemical = new int[N];
		for (int i = 0; i < N; i++) {
			chemical[i] = Integer.parseInt(st.nextToken());
		}
	}

	private static void sol() {
		int   left  = 0;
		int   right = N - 1;
		int   min   = Integer.MAX_VALUE;
		int[] idx   = new int[N];

		int tmp = chemical[left] + chemical[right];
		while (left < right) {
			if (tmp == 0) {
				System.out.println(chemical[left] + " " + chemical[right]);
				return;
			}

			if (Math.abs(tmp) < min) {
				min    = Math.abs(tmp);
				idx[0] = left;
				idx[1] = right;
			}

			if (tmp < 0) {
				tmp -= chemical[left];
				left++;
				tmp += chemical[left];
			} else {
				tmp -= chemical[right];
				right--;
				tmp += chemical[right];
			}

		}
		System.out.println(chemical[idx[0]] + " " + chemical[idx[1]]);
	}

}