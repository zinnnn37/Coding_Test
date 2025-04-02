import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = { 1, 0, -1, 0 };
    private static final int[] dy = { 0, 1, 0, -1 };
    private static final int[] hx = { 2, 1, -1, -2, -2, -1, 1, 2 };
    private static final int[] hy = { 1, 2, 2, 1, -1, -2, -2, -1 };

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int K;
    private static int W;
    private static int H;
    private static int ans;

    private static int[][] map;
    private static boolean[][][] visited;
    private static Queue<Monkey> q;

    private static class Monkey {
        int x;
        int y;
        int k; // 말처럼 뛰는 횟수
        int cnt; // 이동 횟수

        public Monkey(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
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
        init();
        sol();
    }

    private static void init() throws IOException {
        K = nextInt();

        st = tokenize();
        W = nextInt(st);
        H = nextInt(st);
        ans = 0;

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = tokenize();
            for (int j = 0; j < W; j++) {
                map[i][j] = nextInt(st);
            }
        }
        visited = new boolean[H][W][K+1];
        q = new ArrayDeque<>();
    }

    private static void sol() {
        q.offer(new Monkey(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Monkey m = q.poll();

            if (m.x == H - 1 && m.y == W - 1) {
                ans = m.cnt;
                System.out.println(ans);
                return;
            }

            // 말처럼 뛰는 경우
            if (m.k < K) {
                for (int d = 0; d < 8; d++) {
                    int nx = m.x + hx[d];
                    int ny = m.y + hy[d];

                    if (OOB(nx, ny) || visited[nx][ny][m.k+1] || map[nx][ny] == 1)
                        continue;

                    visited[nx][ny][m.k+1] = true;
                    q.offer(new Monkey(nx, ny, m.k + 1, m.cnt + 1));
                }
            }

            // 일반 이동
            for (int d = 0; d < 4; d++) {
                int nx = m.x + dx[d];
                int ny = m.y + dy[d];

                if (OOB(nx, ny) || visited[nx][ny][m.k] || map[nx][ny] == 1)
                    continue;

                visited[nx][ny][m.k] = true;
                q.offer(new Monkey(nx, ny, m.k, m.cnt + 1));
            }
        }
        System.out.println(-1);
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || H <= x || y < 0 || W <= y;
    }

}