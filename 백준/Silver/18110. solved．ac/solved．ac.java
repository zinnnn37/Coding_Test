import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static int   N;
	private static int[] scores;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		scores = new int[N];
		for (int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(scores);

		int remove = toRemove();
		int sum    = 0;
		for (int i = remove; i < N - remove; i++) {
			sum += scores[i];
		}
		System.out.println(Math.round((float) sum / (N - 2 * remove)));
	}

	private static int toRemove() {
		return (int) Math.round(N * 0.15);
	}

}