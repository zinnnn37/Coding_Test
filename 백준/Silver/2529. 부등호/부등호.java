import java.io.*;

public class Main {
	
	static int		n;
	
	static int[]		ans;
	static String[]		ops;
	
	static StringBuilder[]		res;

    public static void main(String[] args) throws IOException {
    
    	BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
    	
    	n = Integer.parseInt(br.readLine());
    	
    	ops = br.readLine().split(" ");

    	ans = new int[n+1];

    	dfs(0);
    	System.out.println(res[1] + "\n" + res[0]);
    }
    
    static void dfs(int depth) {
    	if (depth == n + 1) {
    		makeAnsAsString();
    		return ;
    	}
    	
    	int	q = 0;
    	
    	while (q < 10) {
    		ans[depth] = q++;
    		
    		if (checkValid(depth)) {
    			dfs(depth + 1);
    		}
    	}
    }
    
    static boolean	checkValid(int depth) {
    	for (int i = 0; i < depth; i++) {
    		if (ans[i] == ans[depth]) return false;
    	}
    	
    	if (depth >= 1) {
    		
    		if (ops[depth - 1].equals("<")) {
    			if (ans[depth - 1] >= ans[depth]) return false;
    		} else if (ops[depth - 1].equals(">")) {
    			if (ans[depth - 1] <= ans[depth]) return false;
    		}
    	}
    	return true;
    }
    
    static void	makeAnsAsString() {
    	StringBuilder	sb = new StringBuilder();
    	
    	for (int a : ans) {
    		sb.append(a);
    	}
    	
    	if (res == null) { 
    		res = new StringBuilder[2];
    		res[0] = sb;
    	} else {
    		res[1] = sb;
    	}
    }
}