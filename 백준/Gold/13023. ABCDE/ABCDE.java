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

    private static int ans;

    private static boolean[] visited;

    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = 0;

        visited = new boolean[N];
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
    }

    private static void sol() throws IOException {
        for (int i = 0; i < N; i++) {
        	visited[i] = true;
            dfs(i, 0);
            
            if (ans == 1) break;
            
            visited[i] = false;
        }
        System.out.println(ans);
    }

    private static void dfs(int i, int depth) {
        if (depth == 4) {
            ans = 1;
            return;
        }
        
        for (Integer node : graph[i]) {
        	if (visited[node]) continue;
        	
            visited[node] = true;
            dfs(node, depth + 1);
            visited[node] = false;
        }
    }

}