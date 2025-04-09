import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int n;

    private static int[] home;
    private static int[] festival;
    private static boolean[] visited;

    private static int[][] store;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sol();
        }

        System.out.print(sb);
    }

    private static void sol() throws IOException {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        home = new int[2];
        home[0] = Integer.parseInt(st.nextToken());
        home[1] = Integer.parseInt(st.nextToken());

        store = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            store[i][0] = Integer.parseInt(st.nextToken());
            store[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        festival = new int[2];
        festival[0] = Integer.parseInt(st.nextToken());
        festival[1] = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        bfs();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{home[0], home[1]});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            if (Math.abs(x - festival[0]) + Math.abs(y - festival[1]) <= 1000) {
                sb.append("happy").append("\n");
                return;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    int nx = store[i][0];
                    int ny = store[i][1];

                    if (Math.abs(x - nx) + Math.abs(y - ny) <= 1000) {
                        q.offer(new int[]{nx, ny});
                        visited[i] = true;
                    }
                }
            }
        }
        sb.append("sad").append("\n");
    }
}