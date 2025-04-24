import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int[] nums;     // Input array
    private static int[] dp;       // dp[i] = length of LIS ending at i
    private static int[] p;        // p[i] = previous index in LIS

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        dp = new int[N];
        p = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;        // Initialize dp values to 1
            p[i] = -1;        // Initialize previous index to -1
        }
    }

    private static void sol() {
        int[] lis = new int[N];    // Stores indices of the LIS
        int length = 0;

        for (int i = 0; i < N; i++) {
            // Find position in the LIS array using binary search
            int pos = binarySearch(lis, length, nums[i]);

            // Add current element to the LIS
            lis[pos] = i;

            // Update previous index
            if (pos > 0) {
                p[i] = lis[pos - 1];
            }

            // Update dp value
            dp[i] = pos + 1;

            // Update maximum length if needed
            if (pos == length) {
                length++;
            }
        }

        // Find the index with maximum LIS length
        int maxLen = 0;
        int lastIndex = -1;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        printAns(lastIndex, maxLen);
    }

    private static int binarySearch(int[] lis, int length, int target) {
        int left = 0;
        int right = length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[lis[mid]] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static void printAns(int lastIndex, int maxLen) {
        // First print the length
        System.out.println(maxLen);

        // Reconstruct the sequence
        int[] result = new int[maxLen];
        int curr = lastIndex;
        int idx = maxLen - 1;

        while (curr != -1) {
            result[idx--] = nums[curr];
            curr = p[curr];
        }

        // Print the sequence
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
