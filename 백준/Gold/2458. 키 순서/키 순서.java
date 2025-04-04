import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int M;

    private static int[] asc;
    private static int[] desc;

    private static boolean[] aVisited;
    private static boolean[] dVisited;

    private static List<Integer>[] aGraph; // asc
    private static List<Integer>[] dGraph; // desc

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        aGraph = new ArrayList[N];
        dGraph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            aGraph[i] = new ArrayList<>();
            dGraph[i] = new ArrayList<>();
        }

        aVisited = new boolean[N];
        dVisited = new boolean[N];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            aGraph[a].add(b);
            dGraph[b].add(a);
        }

        asc = new int[N];
        desc = new int[N];
        Arrays.fill(asc, -1);
        Arrays.fill(desc, -1);
    }

    private static void sol() {
        setDegree();

        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (asc[i] + desc[i] == N) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static void setDegree() {
        for (int i = 0; i < N; i++) {
            dfsAsc(i);
            dfsDesc(i);
        }
    }

    private static void dfsAsc(int i) {
        Arrays.fill(aVisited, false);
        asc[i] = countAsc(i) - 1; // 본인 제외(dfsDesc에서 적용)
    }

    private static int countAsc(int node) {
        aVisited[node] = true;
        int count = 1; // 자기 자신 포함

        for (int next : aGraph[node]) {
            if (!aVisited[next]) {
                count += countAsc(next);
            }
        }

        return count;
    }

    private static void dfsDesc(int i) {
        Arrays.fill(dVisited, false);
        desc[i] = countDesc(i);
    }

    private static int countDesc(int node) {
        dVisited[node] = true;
        int count = 1; // 자기 자신 포함

        for (int next : dGraph[node]) {
            if (!dVisited[next]) {
                count += countDesc(next);
            }
        }

        return count;
    }

}