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
	
	private static int[] rule;
	
	private static HashMap<Character, Integer> cnt;
	
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
		
		rule = new int[4];
		st   = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			rule[i] = Integer.parseInt(st.nextToken()); 
		}
		
		cnt = new HashMap<>();
		
		br.close();
	}
	
	private static void countFirst() {
		for (int i = 0; i < P; i++) {
			char cur = str.charAt(i);
			
			cnt.merge(cur, 1, (oVal, nVal) -> oVal + nVal);
		}
	}
	
	private static void DNA() {
		countFirst();
		
		if (checkValid()) ans++;
		
		for (int i = P; i < S; i++) {
			char left  = str.charAt(i-P);
			char right = str.charAt(i);
			
			cnt.merge(left, -1, (oVal, nVal) -> oVal + nVal);
			cnt.merge(right, 1, (oVal, nVal) -> oVal + nVal);
			
			if (checkValid()) ans++;
		}
	}
	
	private static boolean checkValid() {
		return cnt.getOrDefault('A', 0) >= rule[0]
				&& cnt.getOrDefault('C', 0) >= rule[1]
				&& cnt.getOrDefault('G', 0) >= rule[2]
				&& cnt.getOrDefault('T', 0) >= rule[3];
	}

}