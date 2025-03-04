import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    private static final int[] dx = { 0, 1, 0, -1 };
    private static final int[] dy = { 1, 0, -1, 0 };
    
    private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;
    private static int cnt;
    private static int ans = 0; // 명시적 초기화
    private static int maxHeight = 0; // 최대 높이 저장
    
    private static int[][]      board;
    private static boolean[][] visited;
    
    private static Queue<Point> q;
    
    public static void main(String[] args) throws IOException {
        init();
        sol();
        
        System.out.println(ans);
    }
    
    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        
        board = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, board[i][j]); // 최대 높이 계산
            }
        }
        
        q = new ArrayDeque<>();
    }
    
    private static void sol() {
        // 아무 지역도 물에 잠기지 않는 경우도 고려 (높이가 0일 때)
        for (int S = 0; S <= maxHeight; S++) {
            clearVisited();
            cnt = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] > S && !visited[i][j]) {
                        cnt++;
                        visited[i][j] = true;
                        q.offer(new Point(i, j));
                        bfs(S);
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
    }
    
    private static void bfs(int height) {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (isOOB(nx, ny) || visited[nx][ny] || board[nx][ny] <= height) continue;
                
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }
    }

    private static void clearVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }
    
    private static boolean isOOB(int x, int y) {
        return x < 0 || N <= x || y < 0 || N <= y;
    }
}