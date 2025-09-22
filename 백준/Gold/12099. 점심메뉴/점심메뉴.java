import java.io.*;
import java.util.StringTokenizer;

public class Main {

	private static final BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final StringBuilder   sb = new StringBuilder();
	private static       StringTokenizer st;

	private static int N;
	private static int Q;

	private static int[] spiciness;
	private static int[] sweetness;

	public static void main(String[] args) throws IOException {
		init();
		sol();
	}

	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		N  = Integer.parseInt(st.nextToken());
		Q  = Integer.parseInt(st.nextToken());

		spiciness = new int[N];
		sweetness = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			spiciness[i] = s;
			sweetness[i] = w;
		}
	}

	private static void sol() throws IOException {
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());

			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			int w1 = Integer.parseInt(st.nextToken());
			int w2 = Integer.parseInt(st.nextToken());

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (s1 <= spiciness[i] && spiciness[i] <= s2 && w1 <= sweetness[i] && sweetness[i] <= w2) {
					cnt++;
				}
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}