import java.io.*;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final StringBuilder  sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		sol();
	}

	private static void sol() throws IOException {
		int n = Integer.parseInt(br.readLine());

		String up   = br.readLine();
		String down = br.readLine();

		int i = 1;
		while (i < n) {
			i += 3;

			if (i >= n || up.charAt(i) == '.') {
				sb.append('v');
				i += 2;
			} else {
				sb.append('w');
				i += 6;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}