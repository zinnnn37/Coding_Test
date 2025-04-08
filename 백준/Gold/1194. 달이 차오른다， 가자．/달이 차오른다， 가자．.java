import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final String keys = "abcdef";
    private static final String doors = "ABCDEF";

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;

    private static char[][] map;

    private static Queue<Block> q;
    private static boolean[][][] visited; // [얻은 열쇠][][]

    private static class Block {

        int x;
        int y;
        int key; // bitmasking
        int dist;

        public Block(int x, int y, int key, int dist) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.dist = dist;
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

        visited = new boolean[1 << 6][N][M];

        q = new ArrayDeque<>();
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == '0') {
                    q.offer(new Block(i, j, 0, 1));
                    visited[0][i][j] = true;
                }
            }
        }
    }

    private static void sol() {
        while (!q.isEmpty()) {
            Block cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                // out of bounds || visited || meets a wall
                if (OOB(nx, ny) || visited[cur.key][nx][ny] || map[nx][ny] == '#') {
                    continue;
                }

                // exit
                if (map[nx][ny] == '1') {
                    System.out.println(cur.dist);
                    return;
                }

                // doors
                int door = doors.indexOf(map[nx][ny]);
                if (door != -1) {
                    // no key
                    if ((cur.key & (1 << door)) == 0) {
                        continue;
                    }
                }

                // key found
                int nxtKey = cur.key;
                if (keys.indexOf(map[nx][ny]) != -1) {
                    nxtKey |= (1 << map[nx][ny] - 'a');
                }

                q.offer(new Block(nx, ny, nxtKey, cur.dist + 1));
                visited[nxtKey][nx][ny] = true;
            }
        }
        System.out.println(-1);
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || N <= x || y < 0 || M <= y;
    }

}