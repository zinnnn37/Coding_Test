import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    
    private static int dx[] = { 1, 1, -1, -1 };
    private static int dy[] = { -1, 1, 1, -1 };

    private static BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder   sb = new StringBuilder();
    private static StringTokenizer st;
    
    private static int N;
    private static int ans;
    
    private static Point start;
    
    private static boolean[] types;
    
    private static int[][]     cafe;
    
    public static void main(String[] args) throws IOException {
        sol();
    }
    
    private static void sol() throws IOException {
        int T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            init();
            dessertCafeTour();
            
            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }
        System.out.println(sb);
    }
    
    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        ans = -1;
        
        start = new Point(0, 0);
        types = new boolean[101];
        
        cafe = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cafe[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
    private static void dessertCafeTour() {
        for (int i = 0; i < N-2; i++) {
            for (int j = 1; j < N-1; j++) {
            	Arrays.fill(types, false);
                start.setLocation(i, j);
                types[cafe[i][j]] = true;

                dfs(i, j, 1, 0, 0);
            }
        }
    }
    
    private static void dfs(int i, int j, int cnt, int dir, int turn) {
        for (int d = dir; d < 4; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            // [start.x+1][start.y+1]에서 방향 전환하는 경우 turn == 2
            if (nx == start.x && ny == start.y) {
           		if (turn >= 2)
           			ans = Math.max(ans, cnt);
            	return ;
            }
            
            if (OOB(nx, ny) || types[cafe[nx][ny]]) continue ;
            
            types[cafe[nx][ny]] = true;
            
            int nextTurn = (d > dir) ? turn + 1 : turn;
            
            dfs(nx, ny, cnt+1, d, nextTurn);
            
            types[cafe[nx][ny]] = false;
        }
    }
    
    private static boolean OOB(int x, int y) {
        return x < 0 || N <= x || y < 0 || N <= y;
    }
    
}