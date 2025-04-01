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
    private static int visitAll;

    private static int[][] graph;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(sol(0, 1));
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visitAll = (1 << N) - 1;

        dp = new int[N][visitAll+1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    private static int sol(int idx, int visited) {
        if (dp[idx][visited] != -1) {
            return dp[idx][visited];
        }

        if (visited == visitAll) {
            return graph[idx][0] != 0 ? graph[idx][0] : INF;
        }

        dp[idx][visited] = INF;

        for (int i = 0; i < N; i++) {
            // route X || visited
            if (graph[idx][i] == 0 || (visited & (1 << i)) != 0) {
                continue;
            }

            int next = visited | (1 << i);

            dp[idx][visited] = Math.min(dp[idx][visited], sol(i, next) + graph[idx][i]);
        }
        return dp[idx][visited];
    }

}