import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static final int[] dx = { 0, 0, -1, 1 };
    private static final int[] dy = { -1, 1, 0, 0 };

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int         N;
    private static int[][]     dist;
    private static char[][]    matrix;
    private static Queue<Node> q;

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt, o.cnt);
        }

    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        matrix = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = s.charAt(j);
            }
        }

        dist = new int[N][N];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        q = new PriorityQueue<>();
    }

    private static void sol() throws IOException {
        q.offer(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N - 1 && cur.y == N - 1) {
                bw.write(cur.cnt + "");
                bw.flush();
                bw.close();
                br.close();
                return;
            }

            if (cur.cnt > dist[cur.x][cur.y]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (OOB(nx, ny)) continue;

                int newCost = cur.cnt + (matrix[nx][ny] == '0' ? 1 : 0);

                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;

                    q.offer(new Node(nx, ny, newCost));
                }
            }
        }
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || N <= x || y < 0 || N <= y;
    }

}