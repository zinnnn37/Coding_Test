import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;

    private static int N;
    private static int M;

    private static int[] payment;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        payment = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            payment[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void sol() {
        long max = 0;

        for (int i = 0; i < M; i++) {
            max += payment[i];
        }

        int left = 0;
        int right = M;
        long sum = max;
        while (right < N) {
            sum = sum - payment[left++] + payment[right++];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

}
