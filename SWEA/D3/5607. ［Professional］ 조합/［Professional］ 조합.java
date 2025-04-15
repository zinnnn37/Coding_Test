import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    private static final long MOD = 1234567891;

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int N;
    private static int R;

    private static long[] fact;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        initFactorial();

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");

            init();
            sol();
        }
        System.out.println(sb);
    }

    private static void initFactorial() {
        fact = new long[1000001];

        fact[0] = 1;
        fact[1] = 1;

        for (int i = 2; i <= 1000000; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
    }

    private static void sol() {
        long numerator = fact[N];
        long denominator = (fact[R] * fact[N - R]) % MOD;

        sb.append(numerator * pow(denominator, MOD - 2) % MOD).append("\n");
    }

    private static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        }

        long half = pow(a, b / 2);

        if (b % 2 == 0) {
            return (half * half) % MOD;
        } else {
            return ((half * half) % MOD * a) % MOD;
        }
    }

}