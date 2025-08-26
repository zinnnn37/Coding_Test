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
    private static boolean[][] coins;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;

        coins = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                coins[i][j] = s.charAt(j) == 'T'; // 뒷면이 true
            }
        }
    }

    private static void sol() throws IOException {
        // 행 뒤집기
        for (int rowFillped = 0; rowFillped < (1 << N); rowFillped++) {
            // 뒷면
            int totalTails = 0;

            // 각 열에 있는 뒷면 동전 개수
            for (int col = 0; col < N; col++) {
                int tailsInCol = 0;

                for (int row = 0; row < N; row++) {
                    boolean isFlipped = (rowFillped & (1 << row)) != 0; // 뒤집힘
                    boolean coinState = (coins[row][col] ^ isFlipped); // 동전의 현재 상태

                    if (coinState) {
                        tailsInCol++;
                    }
                }
                // 뒤집었을 때 vs 뒤집지 않았을 때
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