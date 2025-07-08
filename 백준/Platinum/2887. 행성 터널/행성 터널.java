import java.io.*;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    private static int N;
    private static int ans;

    private static int[] parents;
    private static Planet[] planets;

    private static Queue<Cost> pq;

    private static class Planet {
        int id;
        int x;
        int y;
        int z;

        public Planet(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static class Cost implements Comparable<Cost> {
        int to;
        int from;
        int cost;

        public Cost(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }

        @Override
        public int compareTo(Cost o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args0) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        ans = 0;

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        planets = new Planet[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets[i] = new Planet(i, x, y, z);
        }

        pq = new PriorityQueue<>();

        generateEdges();
    }

    private static void generateEdges() {
        // x
        Arrays.sort(planets, Comparator.comparingInt(p -> p.x));
        for (int i = 0; i < N-1; i++) {
            pq.offer(new Cost(planets[i].id, planets[i+1].id, Math.abs(planets[i].x - planets[i+1].x)));
        }

        // y
        Arrays.sort(planets, Comparator.comparingInt(p -> p.y));
        for (int i = 0; i < N-1; i++) {
            pq.offer(new Cost(planets[i].id, planets[i+1].id, Math.abs(planets[i].y - planets[i+1].y)));
        }

        //z
        Arrays.sort(planets, Comparator.comparingInt(p -> p.z));
        for (int i = 0; i < N-1; i++) {
            pq.offer(new Cost(planets[i].id, planets[i+1].id, Math.abs(planets[i].z - planets[i+1].z)));
        }
    }

    private static void sol() {
        while (!pq.isEmpty()) {
            Cost cost = pq.poll();

            if (find(cost.to) == find(cost.from)) {
                continue;
            }

            union(cost.to, cost.from);
            ans += cost.cost;
        }
        System.out.println(ans);
    }

    private static int getMinCost(Planet p1, Planet p2) {
        return Math.min(Math.abs(p1.x - p2.x), Math.min(Math.abs(p1.y - p2.y), Math.abs(p1.z - p2.z)));
    }

    private static int find(int a) {
        if (parents[a] != a) {
            parents[a] = find(parents[a]);
        }
        return parents[a];
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (parents[rootA] < parents[rootB]) {
            parents[rootB] = rootA;
        } else {
            parents[rootA] = rootB;
        }
    }
}