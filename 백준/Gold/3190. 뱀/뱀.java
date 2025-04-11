import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static final int APPLE = 1;
    private static final int SNAKE = 9;

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int K;
    private static int L;
    private static int dir;
    private static int time;

    private static int[][] map;

    private static Map<Integer, Integer> move;
    private static Deque<Point> snake;

    public static void main(String[] args) throws IOException {
        init();
        sol();

        System.out.println(time);
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        K = Integer.parseInt(br.readLine().trim());
        dir = 0;
        time = 0;

        map = new int[N][N];
        map[0][0] = SNAKE;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = APPLE;
        }

        L = Integer.parseInt(br.readLine().trim());

        move = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int d = st.nextToken().charAt(0) == 'L' ? -1 : 1;

            move.put(t, d);
        }
        snake = new ArrayDeque<>();
        snake.offer(new Point(0, 0));
    }

    private static void sol() throws IOException {
        do {
            time++;
        } while (moveSnake());
    }

    private static boolean moveSnake() {
        Point head = snake.peekLast();

        int nx = head.x + dx[dir];
        int ny = head.y + dy[dir];

        if (!canMoveOn(nx, ny)) {
            return false;
        }

        // add head
        snake.offer(new Point(nx, ny));

        if (map[nx][ny] != APPLE) {
            Point tail = snake.poll();
            map[tail.x][tail.y] = 0;
        }
        map[nx][ny] = SNAKE;

        // change dir
        if (move.containsKey(time)) {
            dir = (dir + move.get(time) + 4) % 4;
        }

        return true;
    }

    private static boolean canMoveOn(int x, int y) {
        return !OOB(x, y) && map[x][y] != SNAKE;
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || N <= x || y < 0 || N <= y;
    }

}