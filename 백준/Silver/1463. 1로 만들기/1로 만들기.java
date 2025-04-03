import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        if (N <= 3) {
            System.out.println(N == 1 ? 0 : 1);
            System.exit(0);
        }

        dp = new int[N + 1];
        for (int i = 2; i <= 3; i++) {
            dp[i] = 1;
        }
    }

    private static void sol() {
        for (int i = 4; i <= N; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i / 2]) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        System.out.println(dp[N]);
    }

}