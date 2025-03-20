import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int N;
    private static int M;

    private static int[] arr;
    private static Node[] tree;

    private static class Node {

        int min;
        int max;

        public Node(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return min + " " + max + "\n";
        }

    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;

        tree = new Node[(1 << h) + 1];

        initSegTree(1, 1, N);
    }

    private static Node initSegTree(int node, int start, int end) {
        if (start == end) {
            return tree[node] = new Node(arr[start], arr[start]);
        }

        int mid = (start + end) / 2;

        Node left = initSegTree(node * 2, start, mid);
        Node right = initSegTree(node * 2 + 1, mid + 1, end);

        int min = Math.min(left.min, right.min);
        int max = Math.max(left.max, right.max);

        return tree[node] = new Node(min, max);
    }

    private static void sol() throws IOException {
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(getMinAndMax(1, 1, N, a, b));
        }
        System.out.println(sb);
    }

    private static Node getMinAndMax(int node, int start, int end, int left, int right) {
        // OOB
        if (right < start || end < left) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // in range
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        Node leftNode = getMinAndMax(node * 2, start, mid, left, right);
        Node rightNode = getMinAndMax(node * 2 + 1, mid + 1, end, left, right);

        int min = Math.min(leftNode.min, rightNode.min);
        int max = Math.max(leftNode.max, rightNode.max);

        return new Node(min, max);
    }

}
