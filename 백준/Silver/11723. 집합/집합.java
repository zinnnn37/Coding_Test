import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
       BufferedReader	br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder	sb = new StringBuilder();

       int	n = Integer.parseInt(br.readLine());
       
       Set<String>	set = new HashSet<>();
       
       for (int i = 0; i < n; i++) {
    	   StringTokenizer	st = new StringTokenizer(br.readLine());
    	   
    	   String	cmd = st.nextToken();
    	   String	target;

    	   switch (cmd) {
	    	   case "add":
	    		   target = st.nextToken();
	    		   set.add(target);
	    		   break ;
	    		   
	    	   case "check":
	    		   target = st.nextToken();
	    		   if (set.contains(target)) {
	    			   sb.append("1\n");
	    		   } else {
	    			   sb.append("0\n");
	    		   }
	    		   break ;
	    		   
	    	   case "remove":
	    		   target = st.nextToken();
	    		   set.remove(target);
	    		   break ;
	    		   
	    	   case "toggle":
	    		   target = st.nextToken();
	    		   if (set.contains(target)) {
	    			   set.remove(target);
	    		   } else {
	    			   set.add(target);
	    		   }
	    		   break ;
	    		   
	    	   case "all":
	    		   for (int j = 0; j < 20; j++) {
	    			   set.add(j+1+"");
	    		   }
	    		   break ;
	    	
	    	   case "empty":
	    		   set.clear();
	    		   break ;
    	   }
       }
       System.out.println(sb);
    }
}