import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int ans;

    private static boolean[][] connected;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0;

        connected = new boolean[N][N];
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            connected[a][b] = true;
        }
    }

    private static void sol() {
        // Floyd-Warshall -> check connection
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (connected[i][k] && connected[k][j])
                        connected[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            // 현 노드에서 도달할 수 있는 다른 노드의 수
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                if (connected[i][j] || connected[j][i])
                    cnt++;
            }

            if (cnt == N - 1)
                ans++;
        }
        System.out.println(ans);
    }
}