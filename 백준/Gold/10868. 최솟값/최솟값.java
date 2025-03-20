import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int N;
    private static int M;

    private static long[] arr;
    private static long[] tree;

    public static void main(String[] args) throws Exception {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;

        tree = new long[(1 << h) + 1];

        initSegTree(1, 1, N);
    }

    private static long initSegTree(int node, int start, int end) {
        // leaf node
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return tree[node] = Math.min(initSegTree(node * 2, start, mid),
                initSegTree(node * 2 + 1, mid + 1, end));
    }

    private static void sol() throws IOException {
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(findMin(1, 1, N, a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static long findMin(int node, int start, int end, int left, int right) {
        // OOB
        if (right < start || end < left) {
            return Long.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(findMin(node * 2, start, mid, left, right),
                findMin(node * 2 + 1, mid + 1, end, left, right));
    }
}
