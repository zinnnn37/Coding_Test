import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final StringBuilder   sb = new StringBuilder();
	private static       StringTokenizer st;

	private static int   N;
	private static int[] nums, ans;
	private static Stack<Integer> s;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		nums = new int[N];
		ans = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		s = new Stack<>();
	}

	private static void sol() throws IOException {
		for (int i = N - 1; i >= 0; i--) {
			while (!s.isEmpty() && nums[s.peek()] > nums[i]) {
				s.pop();
			}

			if (s.isEmpty()) {
				ans[i] = -1; // Inf
			} else {
				ans[i] = s.peek() - i;
			}
			s.push(i);
		}

		for (int i = 0; i < N; i++) {
			bw.write(ans[i] != -1 ? ans[i] + "\n" : "infinity\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}