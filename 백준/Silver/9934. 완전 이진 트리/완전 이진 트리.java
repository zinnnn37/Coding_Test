import java.io.*;
import java.util.*;

public class Main {
	
	static int	height, k;
	
	static int[]				building;
	static ArrayList<Integer>[]	tree;

    public static void main(String[] args) throws IOException {
    
    	BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder	sb = new StringBuilder();
    	
    	k = Integer.parseInt(br.readLine());
    	height = (int)Math.pow(2, k) - 1;
    	
    	building = new int[height];
    	tree = new ArrayList[k];
    	
    	StringTokenizer	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < height; i++) {
    		building[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for (int i = 0; i < k; i++) {
    		tree[i] = new ArrayList<>();
    	}
    	
    	sol(0, height-1, 0);
    	
    	for (int i = 0; i < k; i++) {
    		for (int j : tree[i]) {
    			sb.append(j).append(" ");
    		}
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
    }
    
    static void	sol(int s, int e, int depth) {
    	if (depth == k) {
    		return ;
    	}
    	
    	int	mid = (s + e) / 2;
    	tree[depth].add(building[mid]);
    	
    	// left
    	sol(s, mid - 1, depth + 1);
    	// right
    	sol(mid + 1, e, depth + 1);
    }
}