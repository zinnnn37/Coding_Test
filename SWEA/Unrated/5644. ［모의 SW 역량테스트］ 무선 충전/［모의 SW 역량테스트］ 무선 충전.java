import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	private static final int[] dx = { 0, -1, 0, 1, 0 };
	private static final int[] dy = { 0, 0, 1, 0, -1 };
	
	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder   sb = new StringBuilder();
	private static StringTokenizer st;
	
	private static int M; // move
	private static int A; // amount
	private static int ans;
	
	private static Player pa;
	private static Player pb;

	private static int[]     moveA;
	private static int[]     moveB;
	private static Battery[] batteries;
	
	private static class Battery {
		int x;
		int y;
		int c;
		int p;
		int id;
		
		@Override
		public String toString() {
			return "Battery [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + ", id=" + id + "]";
		}
		
		public Battery(int x, int y, int c, int p, int id) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
			this.id = id;
		}
	}
	
	private static class Player {
		int x;
		int y;
		
		public Player(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public void move(int dir) {
			this.x += dx[dir];
			this.y += dy[dir];
		}
	}
	
	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			init();
			charge();
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	private static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		ans = 0;
		
		moveA = readMove();
		moveB = readMove();

		batteries = new Battery[A];
		for (int a = 0; a < A; a++) {
			st = new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			batteries[a] = new Battery(j, i, c, p, a);
		}
		
		pa = new Player(0, 0);
		pb = new Player(9, 9);
	}
	
	private static int[] readMove() throws IOException {
		int[] move = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}
		
		return move;
	}
	
	private static void charge() {
		chargeBattery();
		
		for (int i = 0; i < M; i++) {
			pa.move(moveA[i]);
			pb.move(moveB[i]);
			chargeBattery();
		}
	}
	
	private static void chargeBattery() {
		// available batteries
		List<Battery> batA = getBatteries(pa);
		List<Battery> batB = getBatteries(pb);
		
		// can't charge
		if (batA.isEmpty() && batB.isEmpty()) return ;
		
		// can only charge A
		if (batB.isEmpty()) {
			ans += batA.get(0).p;
			return ;
		}
		
		// B
		if (batA.isEmpty()) {
			ans += batB.get(0).p;
			return ;
		}
		
		Battery bestA = batA.get(0);
		Battery bestB = batB.get(0);
		 
		// diff
		if (bestA.id != bestB.id) {
			ans += bestA.p + bestB.p;
			return ;
		}
		
		// same
		int opt1 = bestA.p;
		int opt2 = bestA.p;
		
		if (batA.size() > 1) {
			opt1 += batA.get(1).p;
		}
		if (batB.size() > 1) {
			opt2 += batB.get(1).p;
		}
		
		ans += Math.max(opt1, opt2);
	}
	
	private static List<Battery> getBatteries(Player p) {
		List<Battery> tmp = new ArrayList<>();
		
		for (Battery b : batteries) {
			if (canCharge(p, b)) {
				tmp.add(b);
			}
		}
		tmp.sort(Comparator.comparingInt(b -> -b.p));
		
		return tmp;
	}
	
	private static boolean canCharge(Player p, Battery b) {
		return b.c >= Math.abs(p.x - b.x) + Math.abs(p.y - b.y);
	}
	
}
