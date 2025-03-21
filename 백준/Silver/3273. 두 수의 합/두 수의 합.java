import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;

    private static int N;
    private static int X;

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        X = Integer.parseInt(br.readLine());
    }

    private static void sol() {
        int left = 0;
        int right = N-1;
        int cnt = 0;

        while (left < right) {
            int sum = getSum(left, right);

            if (sum == X) {
                cnt++;
            }

            if (sum > X) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(cnt);
    }

    private static int getSum(int left, int right) {
        return arr[left] + arr[right];
    }

}