import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int max;
    private static int start;

    private static int[] nums;     // input sequence
    private static int[] lis;      // array to store LIS values
    private static int[] idx;      // array to store index information
    private static int lisSize;    // current size of LIS

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        max = 1;
        start = 0;
        lisSize = 1;
        
        idx = new int[N];
        nums = new int[N];
        lis = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = Integer.MIN_VALUE;
    }

    private static void sol() {
        for (int i = 0; i < N; i++) {
            if (lis[lisSize - 1] < nums[i]) {
                lis[lisSize] = nums[i];

                idx[i] = lisSize;
                lisSize++;

                if (lisSize - 1 > max) {
                    start = i;
                    max = lisSize - 1;
                }
            } else {
                int target = binarySearch(0, lisSize - 1, nums[i]);

                lis[target] = nums[i];
                idx[i] = target;

                if (target > max) {
                    start = i;
                    max = target;
                }
            }
        }
        printAns();
    }

    private static int binarySearch(int s, int e, int target) {
        while (s < e) {
            int mid = (s + e) / 2;

            if (lis[mid] < target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return e;
    }

    private static void printAns() {
        int[] ans = new int[max];
        int currentMax = max;

        System.out.println(max);

        // Reconstruct the LIS by tracing back
        for (int i = start; i >= 0; i--) {
            if (idx[i] == currentMax) {
                ans[--currentMax] = nums[i];
            }
        }

        for (int a : ans) {
            System.out.print(a + " ");
        }
    }
}
