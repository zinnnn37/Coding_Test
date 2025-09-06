import java.io.*;
import java.util.*;

public class Main {

	private static final int INF = 987654321;

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static       StringTokenizer st;

	private static int N;
	private static int M;
	private static int X;
	private static int ans;

	private static int[]         aDist;
	private static int[]         dDist;
	private static List<int[]>[] asc;
	private static List<int[]>[] desc;
	private static Queue<int[]>  pq;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());

		N   = Integer.parseInt(st.nextToken());
		M   = Integer.parseInt(st.nextToken());
		X   = Integer.parseInt(st.nextToken());
		ans = 0;

		asc  = new List[N + 1];
		desc = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			asc[i]  = new ArrayList<>();
			desc[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			asc[u].add(new int[] { v, w });
			desc[v].add(new int[] { u, w });
		}

		pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
	}

	private static void sol() throws IOException {
		aDist = dijkstra(X, desc);
		dDist = dijkstra(X, asc);

		int tmp = 0;
		for (int i = 1; i <= N; i++) {
			if (i != X && aDist[i] != INF && dDist[i] != INF) {
				tmp = Math.max(tmp, aDist[i] + dDist[i]);
			}
		}

		bw.write(tmp + "");
		bw.flush();
		bw.close();
		br.close();
	}

	private static int[] dijkstra(int start, List<int[]>[] graph) {
		pq.clear();

		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);

		dist[start] = 0;
		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();

			if (cur[1] > dist[cur[0]]) continue;

			for (int[] edge : graph[cur[0]]) {
				if (dist[edge[0]] <= dist[cur[0]] + edge[1]) {
					continue;
				}

				dist[edge[0]] = dist[cur[0]] + edge[1];
				pq.add(new int[] { edge[0], dist[edge[0]] });
			}
		}
		return dist;
	}

}