import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N, cnt;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            sol();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void sol() throws IOException {
        N = Integer.parseInt(br.readLine());
        cnt = 0;

        while (N > 1) {
            if (N % 2 == 0) {
                N /= 2;
            } else {
                N++;
            }
            cnt++;
        }

        bw.write(cnt + "\n");
    }

}