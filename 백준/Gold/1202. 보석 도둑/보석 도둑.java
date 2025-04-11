import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int K;

    private static Gem[] gems;
    private static int[] bags;

    private static Queue<Integer> pq;

    private static class Gem implements Comparable<Gem> {

        int weight;
        int value;

        public Gem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Gem o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        gems = new Gem[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            gems[i] = new Gem(w, c);
        }
        Arrays.sort(gems);

        bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine().trim());
        }
        Arrays.sort(bags);

        pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    private static void sol() {
        int idx = 0;
        long sum = 0;

        for (int bag : bags) {
            while (idx < N && gems[idx].weight <= bag) {
                pq.offer(gems[idx++].value);
            }

            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        System.out.println(sum);
    }

}