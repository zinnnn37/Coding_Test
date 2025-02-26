import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	private static int N;
	private static int L;
	
	private static int[] fruit;
	
	public static void main(String[] args) throws IOException {
		init();
		sol();
	}
	
	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		fruit = new int[N];
		for (int i = 0; i < N; i++) {
			fruit[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(fruit);
	}
	
	public static void sol() {
		for (int f : fruit) {
			if (f > L) break;
			
			L++;
		}
		
		System.out.println(L);
	}

}