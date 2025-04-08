import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 987654321;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int bitCnt;

    private static int[][] works;
    private static int[][] dp;    // [i][j: 진행되는 일]: j 일이 진행 중이고 i가 일을 할 때의 최소값

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        works = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                works[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bitCnt = (1 << N) - 1; // 모든 일 진행
        dp = new int[N + 1][bitCnt + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
    }

    private static void sol() {
        for (int p = 1; p <= N; p++) {
            for (int subset = 0; subset <= bitCnt; subset++) {
                if (dp[p - 1][subset] == INF) {
                    continue;
                }
                
                for (int job = 0; job < N; job++) {
                    if ((subset & (1 << job)) != 0) {
                        continue;
                    }

                    int nextSet = subset | (1 << job);

                    dp[p][nextSet] = Math.min(dp[p][nextSet], dp[p-1][subset] + works[p-1][job]);
                }
            }
        }
        System.out.println(dp[N][bitCnt]);
    }

}