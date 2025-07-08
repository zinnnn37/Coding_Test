import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    private static int N;
    private static int ans;
    private static int[][] lines;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        lines = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.stream(lines).forEach(Arrays::sort);
        Arrays.sort(lines, (a, b) -> Integer.compare(a[0], b[0]));
    }

    private static void sol() throws IOException {
        int start = lines[0][0];
        int end = lines[0][1];

        for (int i = 1; i < N; i++) {
            if (start <= lines[i][0] && lines[i][0] <= end && lines[i][1] > end) {
                end = lines[i][1];
            } else if (lines[i][0] > end) {
                ans += (end - start);

                start = lines[i][0];
                end =  lines[i][1];
            }
        }
        ans += (end - start);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

}