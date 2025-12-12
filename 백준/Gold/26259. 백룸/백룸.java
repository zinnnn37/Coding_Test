import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = -987654321;

    private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static       StringTokenizer st;

    private static int N, M, x1, y1, x2, y2;
    private static int[][] matrix, dp;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N + 1][M + 1];
        for (int[] d : dp) {
            Arrays.fill(d, INF);
        }
        dp[1][1] = matrix[1][1];

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        if (x1 > x2) {
            int tmp = x1;
            x1 = x2;
            x2 = tmp;
        }
        if (y1 > y2) {
            int tmp = y1;
            y1 = y2;
            y2 = tmp;
        }
    }

    private static void sol() throws IOException {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i == 1 && j == 1) continue;

                int up   = canMoveDown(i, j) ? dp[i - 1][j] : INF;
                int left = canMoveRight(i, j) ? dp[i][j - 1] : INF;

                if (up != INF || left != INF) {
                    dp[i][j] = matrix[i][j] + Math.max(up, left);
                }
            }
        }
        bw.write(dp[N][M] == INF ? "Entity" : String.valueOf(dp[N][M]));
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean canMoveDown(int i, int j) {
        if (x1 != x2) {
            return true;
        }
        return !(i - 1 == x1 && y1 < j && j <= y2);
    }

    private static boolean canMoveRight(int i, int j) {
        if (y1 != y2) {
            return true;
        }
        return !(j - 1 == y1 && x1 < i && i <= x2);
    }

}