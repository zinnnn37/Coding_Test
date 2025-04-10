import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N;
    private static int ans;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine().trim());
        ans = 0;

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine().trim());
        }
        Arrays.sort(nums);
    }

    private static void sol() {
        int gap;

        for (int i = 1; i < N - 1; i++) {
            gap = Math.abs(2 * nums[i] - nums[0] - nums[i + 1]);
            ans = Math.max(ans, gap);

            gap = Math.abs(2 * nums[i] - nums[i - 1] - nums[N - 1]);
            ans = Math.max(ans, gap);
        }
        System.out.println(ans);
    }

}