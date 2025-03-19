import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringBuilder sb = new StringBuilder();

    private static int T;
    private static int N;
    private static Trie trie;

    private static class TrieNode {

        boolean isEnd;
        Map<Integer, TrieNode> child;

        public TrieNode() {
            child = new HashMap<>();
            isEnd = false;
        }
    }

    private static class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public boolean insert(String phone) {
            // starts from the root
            TrieNode cur = root;

            for (int i = 0; i < phone.length(); i++) {
                // char to int
                int digit = phone.charAt(i) - '0';

                // if cur doesn't have child, add one
                cur.child.putIfAbsent(digit, new TrieNode());

                // move to the child
                cur = cur.child.get(digit);

                if (cur.isEnd) {
                    return false;
                }
            }
            cur.isEnd = true;

            // if the phone number is a prefix of another phone number
            if (cur.child.size() > 0) {
                return false;
            }

            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            init();
            sol();
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        trie = new Trie();

        N = Integer.parseInt(br.readLine());
    }

    private static void sol() throws IOException {
        boolean flag = true;

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            if (!trie.insert(input)) {
                flag = false;
                continue;
            }
        }
        sb.append(flag ? "YES\n" : "NO\n");
    }

}
