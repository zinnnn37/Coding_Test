import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final long MOD = 1_000_000_007L;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int K;

    private static int[] arr;
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

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;

        tree = new long[(1 << h) + 1];
    }

    private static void sol() throws IOException {
        initSegTree(1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
            	arr[b] = c; 
                update(1, 1, N, b);
            } else {
                sb.append(mulOf(1, 1, N, b, c)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static long initSegTree(int node, int start, int end) {
        // leaf node
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        long res = initSegTree(node * 2, start, mid)
                * initSegTree(node * 2 + 1, mid + 1, end);

        return tree[node] = mod(res);
    }

    private static void update(int node, int start, int end, int idx) {
        // out of range
        if (idx < start || end < idx) {
            return;
        }

        if (start == end) {
        	tree[node] = arr[idx]; 
            return;
        }

        int mid = (start + end) / 2;

        update(node * 2, start, mid, idx);
        update(node * 2 + 1, mid + 1, end, idx);
        
        tree[node] = mod(tree[node * 2] * tree[node * 2 + 1]);
    }

    private static long mulOf(int node, int start, int end, int left, int right) {
        // out of range
        if (right < start || end < left) {
            // multiple -> return 1
            return 1;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;

        long res = mulOf(node * 2, start, mid, left, right)
                * mulOf(node * 2 + 1, mid + 1, end, left, right);

        return mod(res);
    }

    private static long mod(long val) {
        return val % MOD;
    }

}
