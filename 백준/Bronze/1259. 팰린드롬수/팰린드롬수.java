import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private static StringBuilder sb = new StringBuilder();

	private static String input;

	public static void main(String[] args) throws IOException {
		sol();

		System.out.println(sb);
	}

	private static void sol() throws IOException {
		outer:
		while (!(input = br.readLine()).equals("0")) {
			int s = 0;
			int e = input.length() - 1;

			while (s <= e) {
				if (input.charAt(s++) != input.charAt(e--)) {
					sb.append("no\n");
					continue outer;
				}
			}
			sb.append("yes\n");
		}
	}

}
