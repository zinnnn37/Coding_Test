import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int ans;
    private static int virusCnt;

    private static int[][] matrix;
    private static int[] activeVirus;
    private static List<Point> virus;
    private static Queue<Node> q;
    private static boolean[][] visited;

    private static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
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
        ans = Integer.MAX_VALUE;

        matrix = new int[N][N];
        virus = new ArrayList<>();
        int v = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());

                if (matrix[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }
        virusCnt = virus.size();
        activeVirus = new int[M];

        q = new ArrayDeque<>();
        visited = new boolean[N][N];
    }

    private static void sol() throws IOException {
        perm(0, 0);

        bw.write(ans == Integer.MAX_VALUE ? "-1" : ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void perm(int depth, int n) {
        if (depth == M) {
            bfs();
            return;
        }

        for (int i = n; i < virusCnt; i++) {
            activeVirus[depth] = i;
            perm(depth + 1, i + 1);
        }
    }

    private static void bfs() {
        // clear queue and visited
        clear();

        // put active virus
        for (int i = 0; i < M; i++) {
            Point curVirus = virus.get(activeVirus[i]);
            q.offer(new Node(curVirus.x, curVirus.y, 0));
            visited[curVirus.x][curVirus.y] = true;
        }

        int res = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (matrix[cur.x][cur.y] == 0) {
                res = Math.max(res, cur.cnt);
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (OOB(nx, ny) || visited[nx][ny] || matrix[nx][ny] == 1) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny, cur.cnt + 1));
            }
        }
        if (checkValid()) {
            ans = Math.min(ans, res);
        }
    }

    private static void clear() {
        q.clear();

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    private static boolean checkValid() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

}