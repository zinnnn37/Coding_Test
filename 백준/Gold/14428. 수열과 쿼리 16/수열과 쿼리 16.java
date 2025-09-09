import java.io.*;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final StringBuilder   sb = new StringBuilder();
	private static       StringTokenizer st;

	private static int N, M;
	private static int[]  nums;
	private static Node[] segTree;

	private static class Node {
		int index;
		int value;

		Node(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public String toString() {
			return "[ " + this.index + " : " + this.value + " ]";
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());

		nums = new int[N + 1];
		st   = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());

		segTree = new Node[N * 4];
		initSegTree(1, N, 1);
	}

	private static Node initSegTree(int start, int end, int node) {
		if (start == end) {
			segTree[node] = new Node(start, nums[start]);
			return segTree[node];
		}

		int mid = (start + end) / 2;

		return segTree[node] = compareNodes(initSegTree(start, mid, node * 2)
				, initSegTree(mid + 1, end, node * 2 + 1));
	}

	private static void sol() throws IOException {
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());
			int x   = Integer.parseInt(st.nextToken());
			int y   = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				update(1, 1, N, new Node(x, y));
			} else if (cmd == 2) {
				Node target = getMinIndexNode(1, 1, N, x, y);
				sb.append(target.index).append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void update(int node, int start, int end, Node val) {
		if (val.index < start || end < val.index) {
			return;
		}

		if (start == end) {
			segTree[node] = val;
			return;
		}

		int mid = (start + end) / 2;

		update(node * 2, start, mid, val);
		update(node * 2 + 1, mid + 1, end, val);

		segTree[node] = compareNodes(segTree[node * 2], segTree[node * 2 + 1]);
	}

	private static Node getMinIndexNode(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return null;
		}

		if (left <= start && end <= right) {
			return segTree[node];
		}

		int mid = (start + end) / 2;

		return compareNodes(getMinIndexNode(node * 2, start, mid, left, right)
				, getMinIndexNode(node * 2 + 1, mid + 1, end, left, right));
	}

	private static Node compareNodes(Node n1, Node n2) {
		if (n1 == null) return n2;
		if (n2 == null) return n1;

		if (n1.value == n2.value) {
			return n1.index < n2.index ? n1 : n2;
		}
		return n1.value < n2.value ? n1 : n2;
	}

}