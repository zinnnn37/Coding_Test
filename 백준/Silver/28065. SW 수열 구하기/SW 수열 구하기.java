import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder  sb = new StringBuilder();

    private static int N;

    public static void main(String[] args) throws IOException {
        sol();
    }

    private static void sol() throws IOException {
        N = Integer.parseInt(br.readLine());

        int min = 1;
        int max = N;
        int idx = -1;
        while (++idx < N) {
            sb.append(min++).append(" ");

            if (++idx == N) break;

            sb.append(max--).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }

}