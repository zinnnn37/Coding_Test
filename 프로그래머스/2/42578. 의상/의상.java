import java.util.*;

class Solution {
    
    private static int ans;
    private static Map<String, Integer> clothes;
    
    public int solution(String[][] cl) {
        clothes = new HashMap<>();
        ans = 1;
        
        for (String[] c : cl) {
            clothes.put(c[1], clothes.getOrDefault(c[1], 0) + 1);
        }
        
        for (String s : clothes.keySet()) {
            ans *= clothes.get(s) + 1;
        }
        
        return ans - 1;
    }
}