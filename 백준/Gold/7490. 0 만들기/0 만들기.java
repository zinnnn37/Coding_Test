import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	private static final char[] OPS = { ' ', '+', '-' };

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final StringBuilder  sb = new StringBuilder();

	private static int          N;
	private static char[]       ops;
	private static List<String> res;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		ops = new char[10];

		while (T-- > 0) {
			sol();

			if (T > 0) sb.append('\n');
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void sol() throws IOException {
		N   = Integer.parseInt(br.readLine());
		res = new ArrayList<>();

		dfs(1);

		Collections.sort(res);
		for (String result : res) {
			sb.append(result).append('\n');
		}
	}

	private static void dfs(int num) {
		if (num == N) {
			String expression = appendString();
			if (evaluate(expression) == 0) {
				res.add(expression);
			}
			return;
		}

		for (char op : OPS) {
			ops[num] = op;
			dfs(num + 1);
		}
	}

	private static String appendString() {
		StringBuilder exp = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			exp.append(i);
			if (i < N) {
				exp.append(ops[i]);
			}
		}
		return exp.toString();
	}

	private static int evaluate(String expression) {
		String noBlank = expression.replaceAll(" ", "");

		int  result = 0;
		int  cn     = 0;
		char co     = '+';

		for (int i = 0; i < noBlank.length(); i++) {
			char c = noBlank.charAt(i);

			// 숫자 합치기
			if (Character.isDigit(c)) {
				cn = cn * 10 + (c - '0');
			}

			if (c == '+' || c == '-' || i == noBlank.length() - 1) {
				if (co == '+') {
					result += cn;
				} else {
					result -= cn;
				}
				co = c;
				cn = 0;
			}
		}

		return result;
	}
}