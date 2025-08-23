import java.io.*;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final StringBuilder   sb = new StringBuilder();
	private static       StringTokenizer st;

	private static int N;
	private static int Q;

	private static long[] tree;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		tree = new long[N * 4];
	}

	private static void sol() throws IOException {
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());
			int a   = Integer.parseInt(st.nextToken());
			int b   = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				update(1, 1, N, a, b);
			} else {
				bw.write(partialSum(1, 1, N, a, b) + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

	private static void update(int node, int start, int end, int idx, long diff) {
		// OOB
		if (idx < start || end < idx) {
			return;
		}
		// update
		tree[node] += diff;

		// leaf node
		if (start == end) {
			return;
		}

		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx, diff);
		update(node * 2 + 1, mid + 1, end, idx, diff);
	}

	private static long partialSum(int node, int start, int end, int left, int right) {
		// OOB
		if (end < left || right < start) {
			return 0;
		}

		// in range
		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;

		return partialSum(node * 2, start, mid, left, right)
		       + partialSum(node * 2 + 1, mid + 1, end, left, right);
	}

}
