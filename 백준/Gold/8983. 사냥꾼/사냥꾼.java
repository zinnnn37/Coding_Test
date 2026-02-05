import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static       StringTokenizer st;

    private static int N, M, L, a, b, upper, lower, idx, ans;
    private static int[] shootingLane;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        shootingLane = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            shootingLane[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(shootingLane);
    }

    private static void sol() throws IOException {
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (b > L) continue;

            upper = upperbound(a);
            lower = lowerbound(a);

            idx = Math.abs(upper - a) < Math.abs(lower - a) ? upper : lower;

            //            System.out.println(upper + " " + lower + " " + idx);
            //            System.out.println(Math.abs(idx - a) + b);
            //            System.out.println();

            if (Math.abs(idx - a) + b <= L) {
                ans++;
            }
        }
        bw.write(ans + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int upperbound(int target) {
        int left  = 0;
        int right = M;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (shootingLane[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return shootingLane[Math.min(right, M - 1)];
    }

    private static int lowerbound(int target) {
        int left  = 0;
        int right = M;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (shootingLane[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return shootingLane[Math.min(left, M - 1)];
    }

}