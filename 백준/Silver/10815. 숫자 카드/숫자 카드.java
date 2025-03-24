import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int N;
    private static int M;
    private static int[] cards;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
    }

    private static void sol() throws IOException {
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            sb.append(binarySearch(0, N - 1, target)).append(" ");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (cards[mid] == target) {
                return 1;
            } else if (cards[mid] < target) {
            	start = mid + 1;
            } else {
            	end = mid - 1;
            }
        }
        return 0;
    }

}