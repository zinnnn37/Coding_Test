import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;

    private static int[][] colors;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        colors = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][3];
        System.arraycopy(colors[0], 0, dp[0], 0, 3);
    }

    private static void sol() {
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + colors[i][0], dp[i - 1][2] + colors[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + colors[i][1], dp[i - 1][2] + colors[i][1]);
            dp[i][2] = Math.min(dp[i - 1][1] + colors[i][2], dp[i - 1][0] + colors[i][2]);
        }
        System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
    }

}