import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static StringBuilder   sb = new StringBuilder();
	private static StringTokenizer st;

	private static int N;
	private static int M;
	private static int K;

	private static long[] arr;
	private static long[] tree;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// original arr
		arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		int h = (int) Math.ceil(Math.log(N) / Math.log(2));

		// segment Tree
		tree = new long[2 * (1 << h)];
	}

	private static void sol() throws IOException {
		initSegTree(1, 1, N);

		int tc = K + M;
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine());

			int  cmd = Integer.parseInt(st.nextToken());
			int  a   = Integer.parseInt(st.nextToken());
			long b   = Long.parseLong(st.nextToken());

			switch (cmd) {
				case 1:
					update(1, 1, N, a, b - arr[a]);
					arr[a] = b;
					break;
				case 2:
					long res = partialSum(1, 1, N, a, b);
					sb.append(res).append('\n');
					break;
			}
		}
		System.out.println(sb);
	}

	/**
	 * Initialization of Segmentation Tree
	 *
	 * @param node  index of current node
	 * @param start start index of (sub)tree
	 * @param end   end infrc og (sub)tree
	 * @return sum of child node
	 */
	private static long initSegTree(int node, int start, int end) {
		// leaf node
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;

		// check subtree: left, right
		return tree[node] = initSegTree(node * 2, start, mid)
		                    + initSegTree(node * 2 + 1, mid + 1, end);
	}

	/**
	 * Update node
	 *
	 * @param node  idx of current node
	 * @param start start of tree
	 * @param end   end of tree
	 * @param idx   node to update
	 * @param diff  gap between original value and updated value
	 */
	private static void update(int node, int start, int end, int idx, long diff) {
		// out of range
		if (idx < start || idx > end) {
			return;
		}

		tree[node] += diff;
		if (start == end) return;

		int mid = (start + end) / 2;

		// update left subtree
		update(node * 2, start, mid, idx, diff);
		// update right subtree
		update(node * 2 + 1, mid + 1, end, idx, diff);
	}

	/**
	 * get partial Sum
	 *
	 * @param node  index of current node
	 * @param start start index of tree
	 * @param end   end index of tree
	 * @param left  leftmost index of range to sum
	 * @param right rightmost index of range to sum
	 * @return sum of range (left to right)
	 */
	private static long partialSum(int node, int start, int end, int left, long right) {
		// out of range
		if (left > end || right < start) {
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
