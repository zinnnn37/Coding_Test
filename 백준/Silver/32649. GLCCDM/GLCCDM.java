import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static       StringTokenizer st;

	private static int A;
	private static int B;
	private static int K;

	private static ArrayList<Integer> ans;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		ans = new ArrayList<>();
		ans.add(A);
		ans.add(B);

		for (int i = A * 2; i < B; i++) {
			if (i % A == 0 && B % i == 0) {
				ans.add(i);
			}
		}
	}

	private static void sol() throws IOException {
		if (ans.size() >= K) {
			for (int i = 0; i < K; i++) {
				bw.write(ans.get(i) + " ");
			}
		} else {
			bw.write("-1\n");
		}
		bw.flush();
		bw.close();
	}
}