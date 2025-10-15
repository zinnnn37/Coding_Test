import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    private static int N, M;
    private static Node[] nodes;
    private static Queue<Node> pq;

    private static class Node implements Comparable<Node> {
        int idx;
        int val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if (this.val == o.val) {
                return Integer.compare(this.idx, o.idx);
            }
            return Integer.compare(this.val, o.val);
        }

        @Override
        public String toString() {
            return "[" + idx + " " + val + "]";
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        nodes = new Node[N + 1];
        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i, Integer.parseInt(st.nextToken()));
            pq.offer(nodes[i]);
        }

        M = Integer.parseInt(br.readLine());
    }

    private static void sol() throws IOException {
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                nodes[a] = new Node(a, b); // 객체 참조 변경 시 pq 순서 꼬일 수 있음,,
                pq.offer(nodes[a]); // priority queue는 내부 객체가 변경되어도 재정렬 되지 않음
            } else if (cmd == 2) {
                // 업데이트 되기 이전 값은 poll()
                while (!pq.isEmpty() && pq.peek().val != nodes[pq.peek().idx].val) {
                    pq.poll();
                }
                sb.append(pq.peek().idx).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}