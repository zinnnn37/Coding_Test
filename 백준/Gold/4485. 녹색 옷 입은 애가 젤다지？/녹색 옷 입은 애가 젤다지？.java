import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = Integer.MAX_VALUE;

    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int N;
    private static int ans;

    private static int[][] map;
    private static int[][] dist;

    private static Queue<Node> pq;

    private static class Node implements Comparable<Node> {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    private static StringTokenizer tokenize() throws IOException {
        return new StringTokenizer(br.readLine());
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static int nextInt(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        int tc = 1;
        while ((N = nextInt()) != 0) {
            init();
            sol();
            sb.append("Problem ").append(tc++).append(": ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        map = new int[N][N];
        dist = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = tokenize();
            for (int j = 0; j < N; j++) {
                map[i][j] = nextInt(st);
                dist[i][j] = INF;
            }
        }
        pq = new PriorityQueue<>();
    }

    private static void sol() {
        pq.offer(new Node(0, 0, map[0][0]));
        dist[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == N - 1 && cur.y == N - 1) {
                ans = cur.cost;
                return;
            }

            if (dist[cur.x][cur.y] < cur.cost)
                continue;

            dist[cur.x][cur.y] = cur.cost;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || N <= nx || ny < 0 || N <= ny)
                    continue;

                if (dist[nx][ny] <= cur.cost + map[nx][ny])
                    continue;

                dist[nx][ny] = cur.cost + map[nx][ny];
                pq.offer(new Node(nx, ny, dist[nx][ny]));
            }
        }
    }

}