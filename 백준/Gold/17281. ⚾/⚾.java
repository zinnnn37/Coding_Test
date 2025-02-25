import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int N;
	private static int ans;
	
	private static int[] order;
	private static int[] perm;
	
	private static int[][] inning;

	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		init();
		orderBatters(0);
		
		System.out.println(ans);
	}
	
	private static void init() throws IOException {
		N = Integer.parseInt(br.readLine());
		
		ans = 0;
		order = new int[9];
		perm = new int[8]; // 1번 타자 제외

		inning = new int[N][9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 8; i++) {
			perm[i] = i + 1;
		}
		
		// fixed
		order[3] = 0;
		
		br.close();
	}
	
	private static void orderBatters(int depth) {
		do {
			// 순서 적용
			int idx = 0;
			
			for (int i = 0; i < 9; i++) {
				if (i == 3) continue;
				
				order[i] = perm[idx++]; 
			}
			
			playBaseball();
			
		} while (nextPerm());
	}
	
	private static void playBaseball() {
		int score = 0;
		int batter = 0;
		
		for (int i = 0; i < N; i++) {
			int out = 0;
			int base = 0;
			
			while (out < 3) {
				int hitter = order[batter];
				int res = inning[i][hitter];
				
				if (res == 0) {
					out++;
				} else {
					// base << res: 진루
					// - 안타: 1만큼 이동, 2루타: 2만큼 이동, ...
					// 1 << (res - 1): 타자가 딴 점수
					base = (base << res) | (1 << (res - 1));

					// 4자리 이상의 비트는 모두 딴 점수가 되는 것 (base >> 3)
					score += Integer.bitCount(base >> 3);
					
					// 3루까지만 남기기(111)
					base &= 7;
				}
				
				// 타자 순서 유지
				batter = (batter + 1) % 9;
			}
		}
		ans = Math.max(ans, score);
	}
	
    private static boolean nextPerm() {
        int i = 7;
        
        while (i > 0 && perm[i-1] >= perm[i]) i--;
        
        if (i == 0) return false;
        
        int j = 7;
        while (perm[i-1] >= perm[j]) j--;
        
        swap(i-1, j);
        reverse(i, 7);
        
        return true;
    }
    
    private static void swap(int i, int j) {
        int temp = perm[i];

        perm[i] = perm[j];
        perm[j] = temp;
    }
    
    private static void reverse(int start, int end) {
        while (start < end) {
            swap(start++, end--);
        }
    }
	
}