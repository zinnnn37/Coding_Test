import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int ans;
    private static int[] coins;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;

        coins = new int[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'T') {
                    coins[i] += (1 << j);
                }
            }
        }
    }

    private static void sol() throws IOException {
        // 행 뒤집기
        for (int rowFillped = 0; rowFillped < (1 << N); rowFillped++) {
            // 뒷면
            int totalTails = 0;

            for (int row = 0; row < N; row++) {
                int tailsInCol = Integer.bitCount(coins[row] ^ rowFillped);
                totalTails += Math.min(tailsInCol, N - tailsInCol);
            }
            ans = Math.min(ans, totalTails);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int countTails(boolean[][] arr) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}