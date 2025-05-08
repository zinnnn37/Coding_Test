import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    private static int N;
    private static int K;
    private static int ans;

    private static int[] classrooms;

    private static Queue<Integer> pq;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;

        st = new StringTokenizer(br.readLine());

        classrooms = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            classrooms[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(classrooms);

        pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i <= N; i++) {
            pq.offer(classrooms[i] - classrooms[i - 1]);
        }
    }

    private static void sol() throws IOException {
        for (int i = 0; i < K; i++) {
            pq.poll();
        }

        for (int p : pq) {
            ans += p;
        }

        print();
    }

    private static void print() throws IOException {
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

}