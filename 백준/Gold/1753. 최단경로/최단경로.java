import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int V; // vertex
    private static int E; // edge
    private static int S; // start node

    private static int[] dist;

    private static Queue<Node> q;
    private static List<Node>[] graph;

    private static StringTokenizer tokenize() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static int nextInt() {
        return Integer.parseInt(st.nextToken());
    }

    private static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
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
        st = tokenize();

        V = nextInt();
        E = nextInt();
        S = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        while (E-- > 0) {
            st = tokenize();

            int a = nextInt();
            int b = nextInt();
            int c = nextInt();

            graph[a].add(new Node(b, c));
        }
        q = new PriorityQueue<>();
    }

    private static void sol() {
        q.offer(new Node(S, 0));
        dist[S] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.weight > dist[cur.to]) {
                continue;
            }

            for (Node nxt : graph[cur.to]) {
                if (dist[nxt.to] <= dist[cur.to] + nxt.weight) {
                    continue;
                }

                dist[nxt.to] = dist[cur.to] + nxt.weight;
                q.add(new Node(nxt.to, dist[nxt.to]));
            }
        }
		
        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }

}