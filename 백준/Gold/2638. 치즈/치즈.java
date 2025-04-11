import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int cnt;

    private static int[][] cheese;
    private static int[][] visited;

    private static Queue<Point> q;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;

        cheese = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q = new ArrayDeque<>();
    }

    private static void sol() {
        while (true) {
            clear();
            if (!findMeltingCheese()) {
                break;
            }
            meltCheese();
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void clear() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], 0);
        }
    }

    private static boolean findMeltingCheese() {
        boolean melted = false;

        q.offer(new Point(0, 0));
        visited[0][0] = -1;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (OOB(nx, ny) || visited[nx][ny] == -1) {
                    continue;
                }

                if (cheese[nx][ny] == 0) {
                    visited[nx][ny] = -1;
                    q.offer(new Point(nx, ny));
                } else {
                    melted = true;
                    visited[nx][ny]++;
                }
            }
        }
        return melted;
    }

    private static void meltCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] >= 2) {
                    cheese[i][j] = 0;
                }
            }
        }
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || N <= x || y < 0 || M <= y;
    }

}