import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static       StringTokenizer st;

    private static int      N;
    private static int[]    nums;
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp = new long[N][21];
    }

    private static void sol() throws IOException {
        bw.write(dfs(1, nums[0]) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long dfs(int depth, int sum) {
        if (depth == N - 1) {
            return sum == nums[depth] ? 1 : 0;
        }

        if (dp[depth][sum] != 0) {
            return dp[depth][sum];
        }

        if (sum + nums[depth] <= 20) {
            dp[depth][sum] += dfs(depth + 1, sum + nums[depth]);
        }
        if (sum - nums[depth] >= 0) {
            dp[depth][sum] += dfs(depth + 1, sum - nums[depth]);
        }

        return dp[depth][sum];
    }

}