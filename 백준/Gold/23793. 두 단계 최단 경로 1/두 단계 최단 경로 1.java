import java.io.*;
import java.util.*;

public class Main {

	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static StringTokenizer st;

	private static int N;
	private static int M;
	private static int X;
	private static int Y;
	private static int Z;

	private static int[]        dist;
	private static Queue<Node>  pq;
	private static List<Node>[] graph;

	private static class Node implements Comparable<Node> {
		int to;
		int weigh;

		Node(int to, int weigh) {
			this.to    = to;
			this.weigh = weigh;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weigh, o.weigh);
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		dist  = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from   = Integer.parseInt(st.nextToken());
			int to     = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[from].add(new Node(to, weight));
		}

		st = new StringTokenizer(br.readLine());
		X  = Integer.parseInt(st.nextToken());
		Y  = Integer.parseInt(st.nextToken());
		Z  = Integer.parseInt(st.nextToken());
	}

	private static void sol() throws IOException {
		// 경유
		int a = dijkstra(X, Y, false);
		int b = dijkstra(Y, Z, false);
		if (a == -1 || b == -1) {
			bw.write("-1 ");
		} else {
			bw.write((a + b) + " ");
		}

		// 경유 X
		bw.write(dijkstra(X, Z, true) + "");
		bw.flush();
		bw.close();
		br.close();
	}

	private static int dijkstra(int from, int to, boolean flag) {
		clear();
		pq.offer(new Node(from, 0));
		dist[from] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (cur.to == to) {
				return cur.weigh;
			}

			if (dist[cur.to] < cur.weigh) {
				continue;
			}

			for (Node n : graph[cur.to]) {
				// Y를 경유하지 않아야하는데 경유함
				if (flag && n.to == Y) {
					continue;
				}

				int nextWeight = n.weigh + dist[cur.to];
				if (nextWeight < dist[n.to]) {
					dist[n.to] = nextWeight;
					pq.offer(new Node(n.to, nextWeight));
				}
			}
		}
		return dist[to] != Integer.MAX_VALUE ? dist[to] : -1;
	}

	private static void clear() {
		pq.clear();
		Arrays.fill(dist, Integer.MAX_VALUE);
	}

}