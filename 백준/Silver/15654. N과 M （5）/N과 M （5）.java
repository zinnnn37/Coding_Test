import java.util.*;
import java.io.*;

public class Main {
	
	static int			n;
	static int			m;
	static int[]		arr;
	static int[]		cur;
	static boolean[]	visited;
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       arr = new int[n];
       cur = new int[m];
       visited = new boolean[n];
       
       st = new StringTokenizer(br.readLine());
       for (int i = 0; i < n; i++) {
    	   arr[i] = Integer.parseInt(st.nextToken());
       }
       
       Arrays.sort(arr);
       initVisited();

       rec(0);
    }
    
    private static void rec(int depth) {
    	if (depth == m) {
    		printAns();
    		return ;
    	}
    	
    	for (int i = 0; i < n; i++) {
    		if (!visited[i]) {
    			visited[i] = true;
    			cur[depth] = arr[i];
    			rec(depth + 1);
    			// 백트래킹
    			visited[i] = false;
    		}
    	}
    }
    
    private static void initVisited() {
    	for (int i = 0; i < n; i++) {
    		visited[i] = false;
    	}
    }
    
    private static void printAns() {
    	for (int i = 0; i < m; i++) {
    		System.out.print(cur[i] + " ");
    	}
    	System.out.println();
    }
}