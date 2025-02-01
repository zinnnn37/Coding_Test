import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static long   MOD;

    public static void main(String[] args) throws IOException {
        sol();
    }

    private static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        MOD = Long.parseLong(st.nextToken());

        System.out.println(rec(a, b));
    }

    private static long rec(long a, long b) {
        if (b == 1) return mod(a);

        long div = rec(a, b/2);

        if (b % 2 == 0) return mod(mod(div*div));
        return mod(mod(div*div) * mod(a));
    }

    private static long mod(long i) {
        return i % MOD;
    }
}