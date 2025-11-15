class Solution {
    
    private static int target, len, ans;
    private static int[] nums, ops;
    
    private static void calc() {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += ops[i] * nums[i];
        }
        
        if (sum == target) ans++;
    }
    
    private static void dfs(int start) {
        if (start == len) {
            calc();
            return;
        }
        
        ops[start] = -1;
        dfs(start + 1);
            
        ops[start] = 1;
        dfs(start + 1);
    }
    
    public int solution(int[] n, int t) {
        target = t;
        nums = n;
        len = n.length;
        ans = 0;
        
        ops = new int[len];
        
        dfs(0);
        
        return ans;
    }
}