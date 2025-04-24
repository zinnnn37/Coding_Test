import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int[] nums;

    private static int[] dp;         // LIS 값을 저장하는 배열
    private static int[] lisIndex;   // 각 수가 dp의 몇 번째 위치에 들어갔는지 기록
    private static int dpLength;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        lisIndex = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void sol() {
        dp[0] = nums[0];
        lisIndex[0] = 0;
        dpLength = 1;

        for (int i = 1; i < N; i++) {
            if (nums[i] > dp[dpLength - 1]) {
                dp[dpLength] = nums[i];
                lisIndex[i] = dpLength;
                dpLength++;
            } else {
                int idx = lowerBound(0, dpLength, nums[i]);
                dp[idx] = nums[i];
                lisIndex[i] = idx;
            }
        }

        printAns();
    }

    private static int lowerBound(int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static void printAns() {
        int[] answer = new int[dpLength];
        int len = dpLength - 1;

        for (int i = N - 1; i >= 0; i--) {
            if (lisIndex[i] == len) {
                answer[len--] = nums[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dpLength).append("\n");
        for (int x : answer) {
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
