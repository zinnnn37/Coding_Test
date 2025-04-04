import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int[][] pas;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        init();

        while (T-- > 0)
            sol();

        System.out.println(sb);
    }

    private static void init() throws IOException {
        pas = new int[31][31];

        pas[0][0] = 1;
        for (int i = 1; i <= 30; i++) {
            pas[i][0] = 1;

            for (int j = 1; j <= i; j++) {
                pas[i][j] = pas[i - 1][j - 1] + pas[i - 1][j];
            }
        }
    }

    private static void sol() throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sb.append(pas[M][N]).append("\n");
    }

}