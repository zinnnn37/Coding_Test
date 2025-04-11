import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // nesw
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static final int[] rev = {2, 3, 0, 1};

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int cnt;
    private static Robot robot;

    private static int[][] map;
    private static boolean[][] visited;

    private static class Robot {

        int x;
        int y;
        int dir;

        public Robot(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public void rotate() {
            dir = (dir + 3) % 4;
        }

        public boolean goBack() {
            x += dx[rev[dir]];
            y += dy[rev[dir]];

            if (map[x][y] != 1 && !visited[x][y]) {
                visited[x][y] = true;
                cnt++;
            }

            return !(map[x][y] == 1);
        }

        public void goAhead() {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (map[nx][ny] != 1 && !visited[nx][ny]) {
                x = nx;
                y = ny;

                visited[nx][ny] = true;
                cnt++;
            }
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
        cnt = 1;

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        robot = new Robot(x, y, d);

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[x][y] = true;
    }

    private static void sol() {
        while (true) {
            if (!canCleanAdjacent()) {
                if (!robot.goBack()) {
                    break;
                }
            } else {
                robot.rotate();
                robot.goAhead();
            }
        }
        System.out.println(cnt);
    }

    private static boolean canCleanAdjacent() {
        for (int d = 0; d < 4; d++) {
            int nx = robot.x + dx[d];
            int ny = robot.y + dy[d];

            if (map[nx][ny] == 1 || visited[nx][ny]) {
                continue;
            }
            return true;
        }
        return false;
    }

}