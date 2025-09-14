import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final String OPS = " +-";

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	private static final StringBuilder  sb = new StringBuilder();

	private static int    N;
	private static char[] ops;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		ops = new char[10];

		while (T-- > 0) {
			sol();
			if (T > 0) {
				sb.append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void sol() throws IOException {
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < 3; i++) {
			char o = OPS.charAt(i);
			ops[2] = o;
			dfs(2);
		}
	}

	private static void dfs(int num) {
		if (num == N) {
			if (isValid()) {
				appendString();
			}
			return;
		}

		for (int i = 0; i < 3; i++) {
			char o = OPS.charAt(i);
			ops[num + 1] = o;
			dfs(num + 1);
		}
	}

	private static boolean isValid() {
		List<Integer> nums = new ArrayList<>();

		// 공백 처리
		int idx = 0;
		while (++idx <= N) {
			int num = idx;
			while (idx < N && ops[idx + 1] == ' ') {
				idx++;
				num = num * 10 + idx;
			}
			nums.add(num);
		}

		int res   = nums.get(0);
		int opIdx = 2;

		for (int i = 1; i < nums.size(); i++) {
			// 공백 건너뛰기
			while (opIdx <= N && ops[opIdx] == ' ') opIdx++;

			if (ops[opIdx] == '+') {
				res += nums.get(i);
			} else {
				res -= nums.get(i);
			}
			opIdx++;
		}

		return res == 0;
	}

	private static void appendString() {
		for (int i = 1; i < N; i++) {
			sb.append(i).append(ops[i + 1]);
		}
		sb.append(N).append('\n');
	}
}