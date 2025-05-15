import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int M;
    private static int ans;
    private static String A;
    private static String B;

    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        A = br.readLine().trim();
        B = br.readLine().trim();
        ans = 0;

        N = A.length();
        M = B.length();

        dp = new int[N + 1][M + 1];
    }

    private static void sol() throws IOException {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

}