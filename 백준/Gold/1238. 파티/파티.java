import java.io.*;
import java.util.*;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static       StringTokenizer st;

	private static int N;
	private static int M;
	private static int X;

	private static int[]         aDist;
	private static int[]         dDist;
	private static List<int[]>[] asc;
	private static List<int[]>[] desc;

	static class Edge implements Comparable<Edge> {
		int end;
		int weight;

		public Edge(int end, int weight) {
			this.end    = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
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
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

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
	}

	private static void sol() throws IOException {
		aDist = dijkstra(X, desc);
		dDist = dijkstra(X, asc);

		// INF 검사 제거 (첫 번째 코드 스타일)
		int maxTime = 0;
		for (int i = 1; i <= N; i++) {
			if (i != X) {
				maxTime = Math.max(maxTime, aDist[i] + dDist[i]);
			}
		}

		bw.write(maxTime + "");
		bw.flush();
		bw.close();
		br.close();
	}

	private static int[] dijkstra(int start, List<int[]>[] graph) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] = 0;
		pq.offer(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge current   = pq.poll();
			int  curEnd    = current.end;
			int  curWeight = current.weight;

			if (curWeight > dist[curEnd]) continue;

			for (int[] edge : graph[curEnd]) {
				int nextEnd    = edge[0];
				int nextWeight = edge[1];

				int new_dist = dist[curEnd] + nextWeight;

				if (new_dist < dist[nextEnd]) {
					dist[nextEnd] = new_dist;
					pq.offer(new Edge(nextEnd, new_dist));
				}
			}
		}
		return dist;
	}
}