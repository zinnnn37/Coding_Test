import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    private static int N;
    private static int mp;
    private static int mf;
    private static int ms;
    private static int mv;
    private static int min;
    private static String res;

    private static int[][] ingre;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());

        res = "res"; // 사전 순 확인 위함
        min = Integer.MAX_VALUE;

        ingre = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            ingre[i][0] = Integer.parseInt(st.nextToken()); // p
            ingre[i][1] = Integer.parseInt(st.nextToken()); // f
            ingre[i][2] = Integer.parseInt(st.nextToken()); // c
            ingre[i][3] = Integer.parseInt(st.nextToken()); // v
            ingre[i][4] = Integer.parseInt(st.nextToken()); // cost
        }
    }

    private static void sol() throws IOException {
        for (int i = 0; i < (1 << N); i++) {
            StringBuilder sb = new StringBuilder();

            int sp = 0;
            int sf = 0;
            int ss = 0;
            int sv = 0;
            int sc = 0;

            for (int j = 0; j < N; j++) {
                // contains
                if ((i & (1 << j)) != 0) {
                    sp += ingre[j][0];
                    sf += ingre[j][1];
                    ss += ingre[j][2];
                    sv += ingre[j][3];
                    sc += ingre[j][4];

                    sb.append(j + 1).append(" ");
                }
            }

            if (mp <= sp && mf <= sf && ms <= ss && mv <= sv) {
                if (min > sc) {
                    min = sc;
                    res = sb.toString();
                } else if (min == sc) {
                    if (res.compareTo(sb.toString()) > 0) {
                        res = sb.toString();
                    }
                }
            }
        }

        if (res.compareTo("res") == 0) {
            bw.write("-1");
        } else {
            bw.write(min + "\n" + res);
        }
        bw.flush();
        bw.close();
        br.close();
    }

}