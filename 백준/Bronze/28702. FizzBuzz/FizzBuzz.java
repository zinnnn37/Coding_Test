import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = -1;
		for (int i = 0; i < 3; i++) {
			String s = br.readLine();

			if ('0' <= s.charAt(0) && s.charAt(0) <= '9') {
				num = Integer.parseInt(s);
			}

			if (num != -1) {
				num++;
			}
		}

		if (num % 3 == 0 && num % 5 == 0) {
			System.out.println("FizzBuzz");
		} else if (num % 3 == 0) {
			System.out.println("Fizz");
		} else if (num % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(num);
		}
	}

}