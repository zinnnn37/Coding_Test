import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static       StringTokenizer st;

    private static int L, R, A, B, ans;
    private static boolean[] checked;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        ans = 0;
        checked = new boolean[100_001];
    }

    private static void sol() throws IOException {
        for (int i = L; i <= R; i++) {
            Arrays.fill(checked, false);
            ans += dfs(i);
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int cur) {
        if (checked[cur]) {
            return 0;
        }
        checked[cur] = true;

        int A = 0;
        int B = 1;

        int tmp = cur;
        while (tmp != 0) {
            A += tmp % 10;
            B *= tmp % 10;
            tmp /= 10;
        }

        int res = Integer.parseInt(String.valueOf(A) + B);

        if (cur == res) {
            return 1;
        } else if (res > 100000) {
            return -1;
        } else {
            return dfs(res);
        }
    }

}