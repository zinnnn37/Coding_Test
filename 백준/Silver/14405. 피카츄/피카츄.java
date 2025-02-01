import java.io.*;

public class Main {
	
	static String[]	pikachu = { "pi", "ka", "chu" };
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String	input = br.readLine();
       
       String	regex = "(pi|ka|chu)*";
       System.out.println(input.matches(regex) ? "YES" : "NO");
    }
}
