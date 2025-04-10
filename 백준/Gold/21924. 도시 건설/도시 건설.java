import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static long total;
    private static long ans;

    private static int[] parents;

    private static Queue<Node> pq;

    private static class Node implements Comparable<Node> {

        int from;
        int to;
        int dist;

        public Node(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
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
        total = 0;
        ans = 0;

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            pq.offer(new Node(from, to, dist));

            total += dist;
        }
    }

    private static void sol() {
        pq.offer(new Node(1, 1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (find(cur.from) == find(cur.to)) {
                continue;
            }

            union(cur.from, cur.to);
            ans += cur.dist;
        }

        System.out.println(checkRoute() ? total - ans : -1);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA < rootB) {
            parents[rootB] = rootA;
        } else {
            parents[rootA] = rootB;
        }
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    private static boolean checkRoute() {
        int prev = find(1);
        
        for (int i = 2; i <= N; i++) {
            if (find(i) != prev)
                return false;
        }
        return true;
    }

}