import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int max;
    private static int start;

    private static int[] nums;
    private static Node[] idx;

    private static List<Integer> res; // save index

    private static class Node {

        int idx;
        int val;

        Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        init();
        sol();
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        max = 1;
        start = 0;

        idx = new Node[N];
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        res = new ArrayList<>();
    }

    private static void sol() {
        res.add(Integer.MIN_VALUE);
        for (int i = 0; i < N; i++) {
            // 부분수열 중 제일 큰 수
            if (res.get(res.size() - 1) < nums[i]) {
                res.add(nums[i]);

                // 해당 숫자가 들어갈 수 있는 인덱스와 함께 값 저장
                idx[i] = new Node(res.size() - 1, nums[i]);

                if (res.size() - 1 > max) {
                    start = i;
                    max = res.size() - 1;
                }
            } else {
                // 중간에 끼워넣는 경우
                int target = binarySearch(0, res.size() - 1, nums[i]);

                res.set(target, nums[i]);

                idx[i] = new Node(target, nums[i]);

                if (target > max) {
                    start = i;
                    max = target;
                }
            }
        }
        printAns();
    }

    private static int binarySearch(int s, int e, int target) {
        while (s < e) {
            int mid = (s + e) / 2;

            if (res.get(mid) < target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return e;
    }

    private static void printAns() {
        int[] ans = new int[max];

        System.out.println(max);
        for (int i = start; i >= 0; i--) {
            if (idx[i].idx == max) {
                ans[--max] = idx[i].val;
            }
        }

        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

}