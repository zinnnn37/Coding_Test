import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N, ans;
    private static int[]  nums;
    private static char[] ops;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int numCnt = N / 2 + 1;
        nums = new int[numCnt];
        ops = new char[numCnt - 1];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                nums[i / 2] = line.charAt(i) - '0';
            } else {
                ops[i / 2] = line.charAt(i);
            }
        }

        ans = Integer.MIN_VALUE;
        rec(0, nums[0]);

        System.out.println(ans);
    }

    private static void rec(int idx, int cur) {
        if (idx >= ops.length) {
            ans = Math.max(ans, cur);
            return;
        }

        int next      = nums[idx + 1];
        int noBracket = calc(cur, next, ops[idx]);
        rec(idx + 1, noBracket);

        if (idx + 1 < ops.length) {
            int bracketVal  = calc(next, nums[idx + 2], ops[idx + 1]);
            int withBracket = calc(cur, bracketVal, ops[idx]);
            rec(idx + 2, withBracket);
        }
    }

    private static int calc(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
    }

}