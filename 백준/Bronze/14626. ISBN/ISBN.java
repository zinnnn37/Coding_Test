import java.io.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        sol();
    }

    private static void sol() throws IOException {
        String str = br.readLine();
        
        int sum = 0;
        int missingPos = -1;
        
        for (int i = 0; i < 13; i++) {
            if (str.charAt(i) == '*') {
                missingPos = i;
            } else {
                int digit = str.charAt(i) - '0';
                sum += (i % 2 == 0) ? digit : 3 * digit;
            }
        }
        
        for (int digit = 0; digit <= 9; digit++) {
            int testSum = sum;
            if (missingPos % 2 == 0) {
                testSum += digit;
            } else {
                testSum += 3 * digit;
            }
            
            if (testSum % 10 == 0) {
                bw.write(String.valueOf(digit));
                break;
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}