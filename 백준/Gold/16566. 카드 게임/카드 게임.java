import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder   sb = new StringBuilder();
    private static       StringTokenizer st;

    private static int N, M, K;
    private static int[] choices, parents;
    private static boolean[] cards;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cards = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cards[Integer.parseInt(st.nextToken())] = true;
        }

        parents = new int[N + 2];
        int parent = 0;
        for (int i = N; i > 0; i--) {
            if (cards[i]) parent = i;
            parents[i] = parent;
        }

        choices = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            choices[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void sol() throws IOException {
        for (int choice : choices) {
            int target = find(choice + 1);

            sb.append(parents[target]).append("\n");
            union(target, target + 1);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        parents[rootA] = rootB;
    }

}