import java.io.*;
import java.util.*;

public class Main {

    private static final int   N  = 5;
    private static final int   C  = 25;
    private static final int[] dx = { -1, 1, 0, 0 };
    private static final int[] dy = { 0, 0, -1, 1 };

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int          ans;
    private static int[]        order;
    private static char[][]     matrix;
    private static boolean[][]  visited;
    private static Queue<Node>  q;
    private static Set<Integer> set;

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        matrix = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
        visited = new boolean[N][N];
        q = new ArrayDeque<>();

        order = new int[7];

        set = new HashSet<>();
    }

    private static void sol() throws IOException {
        setOrder(0, 0);

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void setOrder(int depth, int start) {
        if (depth == 7) {
            checkValid();
            return;
        }

        for (int i = start; i < C; i++) {
            order[depth] = i;
            setOrder(depth + 1, i + 1);
        }
    }

    private static void checkValid() {
        int cnt = 0;
        for (int o : order) {
            if (matrix[o / N][o % N] == 'S') {
                cnt++;
            }
        }

        if (cnt < 4) return;

        clear();

        int x        = order[0] / N;
        int y        = order[0] % N;
        int visitCnt = 1;

        q.offer(new Node(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];

                if (OOB(nx, ny) || visited[nx][ny] || !set.contains(nx * 5 + ny)) continue;

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
                visitCnt++;
            }
        }

        if (visitCnt == 7) {
            ans++;
        }
    }

    private static void clear() {
        q.clear();

        set.clear();
        for (int o : order) {
            set.add(o);
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || N <= x || y < 0 || N <= y;
    }

}