import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	private static int    S;
	private static int    P;
	private static int    ans;
	private static String str;
	
	private static int[] cnt;
	private static int[] rule;
	
	public static void main(String[] args) throws IOException {
		sol();
	}
	
	private static void sol() throws IOException {
		init();
		DNA();
		
		System.out.println(ans);
	}
	
	private static void init() throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S   = Integer.parseInt(st.nextToken());
		P   = Integer.parseInt(st.nextToken());
		ans = 0;
		str = br.readLine();
		
		cnt  = new int[4];
		rule = new int[4];

		st   = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			rule[i] = Integer.parseInt(st.nextToken()); 
		}
		
		br.close();
	}
	
	private static void countFirst() {
		for (int i = 0; i < P; i++) {
			char cur = str.charAt(i);
			int  idx = charToIndex(cur);
			
			cnt[idx]++; 
		}
	}
	
	private static void DNA() {
		countFirst();
		
		if (checkValid()) ans++;
		
		for (int i = P; i < S; i++) {
			int left  = charToIndex(str.charAt(i-P));
			int right = charToIndex(str.charAt(i));
			
			cnt[left]--;
			cnt[right]++;
			
			if (checkValid()) ans++;
		}
	}
	
	private static boolean checkValid() {
		return cnt[0] >= rule[0]
				&& cnt[1] >= rule[1]
				&& cnt[2] >= rule[2]
				&& cnt[3] >= rule[3];
	}
	
	private static int charToIndex(char c) {
		if (c == 'A') return 0;
		if (c == 'C') return 1;
		if (c == 'G') return 2;
		return 3;
	}

}