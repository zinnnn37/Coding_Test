import java.util.*;
import java.io.*;

public class Main {
	
	static int				n;
	static int				m;
	static int[]			arr;
	static int[]			cur;
	static boolean[]		visited;
	static StringBuilder	sb = new StringBuilder();
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       cur = new int[m];
       arr = new int[n];
       
       st = new StringTokenizer(br.readLine());
       for (int i = 0; i < n; i++) {
    	   arr[i] = Integer.parseInt(st.nextToken());
       }
       
       Arrays.sort(arr);
       
       visited = new boolean[n];
       initVisited();

       rec(0);
       System.out.println(sb);
    }
    
    private static void rec(int depth) {
    	if (depth == m) {
    		appendAns();
    		return ;
    	}
    	
    	for (int i = 0; i < n; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			cur[depth] = arr[i];
    			rec(depth + 1);
    			visited[i] = false;
    		}
    	}
    }
    
    private static void initVisited() {
    	for (int i = 0; i < n; i++) {
    		visited[i] = false;
    	}
    }
    
    private static void appendAns() {
    	String tmp = "";
    	for (int i = 0; i < m; i++) {
    		tmp += cur[i] + " ";
    	}
    	if (sb.toString().indexOf(tmp) == -1)
    		sb.append(tmp).append("\n");
    }
}