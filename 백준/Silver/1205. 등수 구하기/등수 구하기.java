import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int S;
    private static int P;

    private static int[] scores;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        
        if (N == 0) {
            System.out.println(1);
            System.exit(0);
        }

        scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void sol() {
        int rank = binarySearch(S);

        if (N == P && scores[N-1] >= S) {
            System.out.println(-1);
        } else {
            System.out.println(rank + 1);
        }
    }

    private static int binarySearch(int target) {
        int start = 0;
        int end = N;

        while (start < end) {
            int mid = (start + end) / 2;

            if (scores[mid] > target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

}