import java.util.*;

class Solution {
    
    private static Queue<Integer> pq;
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        while (pq.peek() < K) {
            if (pq.size() < 2) return -1;
            
            int a = pq.poll();
            int b = pq.poll();
            
            pq.offer(a + 2 * b);
            answer++;
        }
        
        return answer;
    }
}