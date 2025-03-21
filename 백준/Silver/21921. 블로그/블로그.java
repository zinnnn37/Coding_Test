import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;

    private static int N;
    private static int X;
    private static int cnt;
    private static int max;

    private static int[] views;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        cnt = 1;
        max = 0;

        views = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            views[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void sol() {
        for (int i = 0; i < X; i++) {
            max += views[i];
        }

        int sub = max;
        int left = 0;
        int right = X;
        while (right < N) {
            sub = sub - views[left++] + views[right++];

            if (sub > max) {
            	max = Math.max(max, sub);
            	cnt = 1;
            } else if (sub == max) {
            	cnt++;
            }
        }
        
        if (max == 0) {
        	System.out.println("SAD");
        } else {
        	System.out.println(max);
        	System.out.println(cnt);
        }
    }

}