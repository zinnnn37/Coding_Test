import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N; // lecture buildings
    private static int M; // construction zones
    private static long K; // total stones
    private static long cnt; // number of stones used

    private static long[] stones;
    private static int[] parents;

    private static boolean[] constructionZones;

    private static StringTokenizer tokenize() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static int nextInt() {
        return Integer.parseInt(st.nextToken());
    }

    private static long nextLong() {
        return Long.parseLong(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        if (init())
            sol();
    }

    private static boolean init() throws IOException {
        st = tokenize();

        N = nextInt();
        M = nextInt();
        K = nextLong();
        cnt = 0;

        st = tokenize();
        stones = new long[N + 1];
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stones[i] = nextLong();
            parents[i] = i;
        }

        constructionZones = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = tokenize();
            int a = nextInt();
            int b = nextInt();

            int large = Math.max(a, b);
            int small = Math.min(a, b);

            constructionZones[large == N && small == 1 ? 1 : large] = true;
        }
        // no need to build bridges
        if (M <= 1) {
            System.out.println("YES");
            return false;
        }
        // not enough stones to build bridges
        if (K < M) {
            System.out.println("NO");
            return false;
        }

        grouping();

        return true;
    }

    private static void grouping() {
        for (int i = 1; i <= N; i++) {
            int v = (i + 1) % (N + 1);

            if (v == 0)
                v = 1;

            if (constructionZones[v] || find(v) == find(i))
                continue;

            union(i, v);
        }
    }

    private static void sol() {
        for (int i = 1; i <= N; i++) {
            if (find(i) == i) {
                cnt += stones[i];
            }
        }
        System.out.println(cnt <= K ? "YES" : "NO");
    }

    private static int find(int a) {
        if (parents[a] == a)
            return a;

        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (stones[rootA] < stones[rootB])
            parents[rootB] = rootA;
        else
            parents[rootA] = rootB;
    }

}