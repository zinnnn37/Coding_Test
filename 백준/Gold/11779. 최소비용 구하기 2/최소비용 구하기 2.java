import java.io.*;
import java.util.*;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final StringBuilder   sb = new StringBuilder();
	private static       StringTokenizer st;

	private static int N, M;
	private static int start, end;

	private static Dist[]       dist;
	private static List<Node>[] graph;
	private static Queue<Node>  q;

	private static class Node implements Comparable<Node> {
		int to;
		int weight;

		Node(int to, int weight) {
			this.to     = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	private static class Dist {
		int           dist;
		List<Integer> cities;

		Dist(int dist, int cur) {
			this.dist   = dist;
			this.cities = new ArrayList<>();
			this.cities.add(cur);
		}

		Dist(int dist, List<Integer> cities) {
			this.dist   = dist;
			this.cities = new ArrayList<>(cities);
		}

		public void add(int v) {
			this.cities.add(v);
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		st    = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end   = Integer.parseInt(st.nextToken());

		q    = new PriorityQueue<>();
		dist = new Dist[N + 1];

		for (int i = 1; i <= N; i++) {
			dist[i] = new Dist(Integer.MAX_VALUE, i);
			dist[i].cities.clear();
		}
	}

	private static void sol() throws IOException {
		q.offer(new Node(start, 0));
		dist[start] = new Dist(0, start);

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (dist[cur.to].dist < cur.weight) continue;

			for (Node n : graph[cur.to]) {
				int nDist = dist[cur.to].dist + n.weight;

				if (dist[n.to] == null || nDist < dist[n.to].dist) {
					dist[n.to] = new Dist(nDist, dist[cur.to].cities);
					dist[n.to].add(n.to);
					q.offer(new Node(n.to, nDist));
				}
			}
		}

		sb.append(dist[end].dist).append("\n");
		sb.append(dist[end].cities.size()).append("\n");
		for (int city : dist[end].cities) {
			sb.append(city).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}