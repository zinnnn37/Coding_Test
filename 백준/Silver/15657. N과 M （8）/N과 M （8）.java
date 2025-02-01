import java.util.*;
import java.io.*;

public class Main {
	
	static int				n;
	static int				m;
	static int[]			arr;
	static int[]			cur;
	static StringBuilder	sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       arr = new int[n];
       cur = new int[m];
       
       st = new StringTokenizer(br.readLine());
       for (int i = 0; i < n; i++) {
    	   arr[i] = Integer.parseInt(st.nextToken());
       }
       
       Arrays.sort(arr);

       for (int i = 0; i < n; i++) {
    	   cur[0] = arr[i];
    	   rec(1, i);
       }
       System.out.print(sb);
    }
    
    private static void rec(int depth, int idx) {
    	if (depth == m) {
    		appendAns();
    		return ;
    	}
    	
    	for (int i = idx; i < n; i++) {
    		cur[depth] = arr[i];
    		rec(depth + 1, i);
    	}
    }
    
    private static void appendAns() {
    	for (int i = 0; i < m; i++) {
    		sb.append(cur[i]).append(" ");
    	}
    	sb.append("\n");
    }
}