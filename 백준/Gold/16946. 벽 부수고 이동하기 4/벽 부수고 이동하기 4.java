import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dx = { 0, 1, 0, -1 };
    private static final int[] dy = { 1, 0, -1, 0 };

    private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder   sb = new StringBuilder();
    private static StringTokenizer st;

    private static int N, M;
    private static int[][]     matrix;
    private static boolean[][] visited;
    private static Queue<Point> q;
    private static Queue<Point> walls;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = input.charAt(j) - '0';
            }
        }
        visited = new boolean[N][M];
        q = new ArrayDeque<>();
        walls = new ArrayDeque<>();
    }

    private static void sol() throws IOException {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        printMat();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int i, int j) {
        q.clear();
        walls.clear();
        
        q.offer(new Point(i, j));
        visited[i][j] = true;

        int cnt = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (OOB(nx, ny) || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                if (matrix[nx][ny] == 0) {
                    q.offer(new Point(nx, ny));
                } else {
                    walls.offer(new Point(nx, ny));
                }
            }
        }
        
        while (!walls.isEmpty()) {
            Point wall = walls.poll();
            matrix[wall.x][wall.y] += cnt;
            visited[wall.x][wall.y] = false;
        }
    }

    private static void printMat() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(matrix[i][j] % 10);
            }
            sb.append("\n");
        }
    }

    private static boolean OOB(int x, int y) {
        return x < 0 || N <= x || y < 0 || M <= y;
    }

}