import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static int   N;
	private static int[] children;

	private static List<Integer> lis;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		children = new int[N];
		for (int i = 0; i < N; i++) {
			children[i] = Integer.parseInt(br.readLine());
		}
		lis = new ArrayList<>();
	}

	private static void sol() throws IOException {
		lis.add(children[0]);
		for (int i = 1; i < N; i++) {
			if (lis.get(lis.size() - 1) < children[i]) {
				lis.add(children[i]);
			} else {
				int idx = binarySearch(0, lis.size(), children[i]);
				lis.set(idx, children[i]);
			}
		}
		bw.write((N - lis.size()) + "");
		bw.flush();
		bw.close();
	}

	private static int binarySearch(int s, int e, int target) {
		while (s < e) {
			int mid = (s + e) / 2;

			if (lis.get(mid) == target) {
				return mid;
			} else if (lis.get(mid) < target) {
				s = mid + 1;
			} else {
				e = mid;
			}
		}
		return s;
	}

}