import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static int hLen;
    private static int nLen;
    private static int cnt;

    private static int[] pi;
    private static char[] haystack;
    private static char[] needle;

    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        haystack = br.readLine().toCharArray();
        needle = br.readLine().toCharArray();

        hLen = haystack.length;
        nLen = needle.length;
        cnt = 0;

        pi = new int[nLen];
        list = new ArrayList<>();
    }

    private static void sol() {
        for (int i = 1, j = 0; i < nLen; i++) {
            while (j > 0 && needle[i] != needle[j]) {
                j = pi[j - 1];
            }

            if (needle[i] == needle[j]) {
                pi[i] = ++j;
            } else {
                pi[i] = 0;
            }
        }
        count();

        sb.append(cnt).append("\n");
        for (int k : list) {
            sb.append(k + 1).append(" ");
        }
        System.out.println(sb);
    }

    private static void count() {
        for (int i = 0, j = 0; i < hLen; i++) {
            while (j > 0 && haystack[i] != needle[j]) {
                j = pi[j - 1];
            }

            if (haystack[i] == needle[j]) {
                if (j == nLen - 1) {
                    cnt++;
                    list.add(i - j);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
    }

}