import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int ans;

    private static boolean[] bulbs;
    private static boolean[] result;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;

        bulbs = new boolean[N];
        result = new boolean[N];

        String s = br.readLine().trim();
        for (int i = 0; i < N; i++) {
            bulbs[i] = s.charAt(i) == '1';
        }

        s = br.readLine().trim();
        for (int i = 0; i < N; i++) {
            result[i] = s.charAt(i) == '1';
        }
    }

    private static void sol() throws IOException {
        flickering(Arrays.copyOf(bulbs, N), true);
        flickering(Arrays.copyOf(bulbs, N), false);

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

    private static void flickering(boolean[] bulbTmp, boolean doFirst) {
        int tmp = 0;

        // 1, 2번 전구 키는 경우
        if (doFirst) {
            tmp++;
            toggle(bulbTmp, 0);
        }

        for (int i = 1; i < N; i++) {
            if (bulbTmp[i - 1] != result[i - 1]) {
                toggle(bulbTmp, i);
                tmp++;
            }
        }

        if (checkValid(bulbTmp)) {
            ans = Math.min(ans, tmp);
        }
    }

    private static void toggle(boolean[] bulbTmp, int pos) {
        for (int i = (pos - 1 < 0 ? 0 : pos - 1); i <= pos + 1 && i < N; i++) {
            bulbTmp[i] = !bulbTmp[i];
        }
    }

    private static boolean checkValid(boolean[] bulbTmp) {
        for (int i = 0; i < N; i++) {
            if (bulbTmp[i] != result[i]) {
                return false;
            }
        }
        return true;
    }

}