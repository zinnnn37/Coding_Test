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
    private static long ans;

    private static int[] parents;
    private static Queue<Node> pq;

    private static class Node implements Comparable<Node> {

        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        ans = 0;

        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.offer(new Node(a, b, c));
        }
    }

    private static void sol() {
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // cycle
            if (find(cur.from) == find(cur.to)) {
                continue;
            }

            union(cur.from, cur.to);
            ans += cur.weight;
        }
        System.out.println(ans);
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

}