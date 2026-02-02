import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static       StringTokenizer st;

    private static int N, M;
    private static long                  max;
    private static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = 0;
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int key = Integer.parseInt(br.readLine());
            map.put(key, map.getOrDefault(key, 0) + 1);
            max = Math.max(max, key);
        }
    }

    private static void sol() throws IOException {
        long left  = 0;
        long right = ((M + N - 1) / N) * max;
        while (left < right) {
            long mid = left + (right - left) / 2;

            if (canUseImmigration(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        bw.write(right + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean canUseImmigration(long time) {
        long cnt = 0;
        for (int key : map.keySet()) {
            cnt += (time / key) * map.get(key);
        }
        return cnt >= M;
    }

}