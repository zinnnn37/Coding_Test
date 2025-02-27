import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder   sb = new StringBuilder();
	private static StringTokenizer st;
	
	private static int N;
	private static int num;
	private static int cnt;

	private static int[]   length;
	private static Point[] pos;
	
	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			init();
			squareRoom();
			
			sb.append('#').append(tc).append(' ').append(num).append(' ').append(cnt).append('\n');
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		num = 0;
		cnt = 0;
		
		pos = new Point[N * N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int key = Integer.parseInt(st.nextToken());
				
				pos[key] = new Point(i, j);
			}
		}
		length = new int[N * N + 1];
	}
	
	private static void squareRoom() {
		for (int key = 1; key <= N * N; key++) {
			
			if (length[key] != 0) continue;
			
			int tmp = 1;
			int ckey = key;
			
			while (true) {
				int nkey = ckey + 1;
				
				if (nkey > N * N) break ;
				
				Point cur = pos[ckey];
				Point nxt = pos[nkey];
				
				if (!(Math.abs(cur.x - nxt.x) + Math.abs(cur.y - nxt.y) == 1)) {
					break;
				}
				
				ckey = nkey;
				tmp++;
				
				length[ckey] = tmp;
			}

			if (tmp > cnt) {
				cnt = tmp;
				num = key;
			}
		}
	}

}