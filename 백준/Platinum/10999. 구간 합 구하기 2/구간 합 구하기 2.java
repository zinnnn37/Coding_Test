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
    private static int K;

    private static long[] arr;
    private static long[] lazy;
    private static long[] tree;

    public static void main(String[] args) throws IOException {
        init();
        sol();

        System.out.println(sb);
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // read input array
        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;

        tree = new long[(1 << h) + 1];
        lazy = new long[(1 << h) + 1];

        initSegTree(1, 1, N);
    }

    private static void sol() throws IOException {
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            long d = st.hasMoreTokens() ? Long.parseLong(st.nextToken()) : 0;

            if (a == 1) {
                updateRangeOf(1, 1, N, b, c, d);
            } else {
                sb.append(sumOf(1, 1, N, b, c)).append("\n");
            }
        }
    }

    private static long initSegTree(int node, int start, int end) {
        // base: leaf node
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = initSegTree(node * 2, start, mid)
                + initSegTree(node * 2 + 1, mid + 1, end);
    }

    private static void updateRangeOf(int node, int start, int end, int left, int right, long diff) {
        // lazy propagation
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];

            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            // clear lazy[node]: diff applied
            lazy[node] = 0;
        }

        // out of range
        if (right < start || end < left) {
            return;
        }

        // fully in range
        if (left <= start && end <= right) {
            tree[node] += (end - start + 1) * diff;

            // update child lazy node
            if (start != end) {
                lazy[node * 2] += diff;
                lazy[node * 2 + 1] += diff;
            }
            return;
        }

        int mid = (start + end) / 2;

        updateRangeOf(node * 2, start, mid, left, right, diff);
        updateRangeOf(node * 2 + 1, mid + 1, end, left, right, diff);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static long sumOf(int node, int start, int end, int left, int right) {
        // lazy propagation
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];

            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }

        // out of range
        if (right < start || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return sumOf(node * 2, start, mid, left, right)
                + sumOf(node * 2 + 1, mid + 1, end, left, right);
    }

}
